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

    public int displaySlotsForBooking()
    {
        int cnt = 0;
        for(slot i: slots)
        {
            System.out.print(cnt + " --> ");
            i.displaySlot();
            cnt++;
        }

        return cnt;
    }

    public void displaySlotsForBooking(String vac_name)
    {
        int cnt = 0;
        for(slot i: slots)
        {
            if(i.getName().equals(vac_name))
            {
                System.out.print(cnt + " --> ");
                i.displaySlot();
            }
            cnt++;
        }
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