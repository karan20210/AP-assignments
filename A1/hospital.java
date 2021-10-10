import java.util.*;

public class hospital
{
    String name, pincode, h_id;
    ArrayList<slot> slots = new ArrayList<>();

    hospital(String n, String p, HashMap<String, hospital> hospitalMap)
    {
        name = n;
        pincode = p;
        h_id = genId(hospitalMap);
        
    }

    String genId(HashMap<String, hospital> hospitalMap)
    {
        String s;
        while(true)
        {
            Random rnd = new Random();
            int no = rnd.nextInt(999999);
            s = String.format("%06d", no);

            if(!hospitalMap.containsKey(s))
                break;
        }

        return s;
    }

    String out()
    {
        System.out.println("Hospital Name: " + name + ", Pincode: " + pincode + ", Id: " + h_id);
        return h_id;
    }

    public void addSlot(slot s, HashMap<String, ArrayList<slot>> slotMap)
    {
        slots.add(s);
        slotMap.put(h_id, slots);
    }

    public void displaySlots()
    {
        for(slot i: slots)
        {
            i.displaySlot();
        }
    }

    public int displaySlotsForBooking(citizen c)
    {
        int cnt = 0, x = 0;
        for(slot i: slots)
        {
            if(c.eligible(i))
            {
                System.out.print(cnt + " --> ");
                i.displaySlot();
                x++;
            }
            cnt++;
        }

        return x;
    }

    public int displaySlotsForBooking(String vac_name, citizen c)
    {
        int cnt = 0, x = 0;
        for(slot i: slots)
        {
            if(i.getName().equals(vac_name) && c.eligible(i))
            {
                System.out.print(cnt + " --> ");
                i.displaySlot();
                x++;
            }

            cnt++;
        }

        return x;
    }

    slot getSlot(int slot_no)
    {
        int cnt = 0;
        for(slot i: slots)
        {
            if(slot_no == cnt)
            {
                return i;
            }
            cnt++;
        }

        return null;
    }

    ArrayList<String> getVaccineNames()
    {
        ArrayList<String> s = new ArrayList<>();
        for(slot i: slots)
        {
            s.add(i.getName());
        }

        return s;
    }

    boolean checkIfSlotExists(String vax_name, int day_no)
    {
        boolean exists = false;

        for(slot i: slots)
        {
            if(i.getDay() == day_no && i.getName().equals(vax_name))
                exists = true;
        }

        return exists;
    }   

    slot getSlotUpdateQuantity(String vax_name, int day_no)
    {
        for(slot i: slots)
        {
            if(i.getDay() == day_no && i.getName().equals(vax_name))
                return i;
        }

        return null;
    } 

    public void checkSlots()
    {
        ArrayList<slot> removable = new ArrayList<>();

        for(slot i: slots)
        {
            if(i.getQuantity() <= 0)
                removable.add(i);
        }

        slots.removeAll(removable);
    }

    String getPin()
    {
        return pincode;
    }

    String getName()
    {
        return name;
    }

    String getId()
    {
        return h_id;
    }
}