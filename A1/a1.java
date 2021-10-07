import java.util.*;

class vaccine
{
    String name;
    int doses_reqd, gap;

    vaccine(String n, int dr, int g)
    {
        name = n;
        doses_reqd = dr;
        gap = g;
    }

    void out()
    {
        System.out.println("Name: " + name +  ", Doses Required: " + doses_reqd + ", Gap between doses: " + gap);
    }
}

class hospital
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

    void addSlot(slot s, HashMap<String, ArrayList<slot>> slotMap)
    {
        slots.add(s);
        slotMap.put(h_id, slots);
    }

    void displaySlots()
    {
        for(slot i: slots)
        {
            i.displaySlot();
        }
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

class citizen
{
    String name, UID, vaccination_status;
    int age;

    citizen(String n, int a, String id)
    {
        name = n;
        UID = id;
        age = a;

        vaccination_status = "REGISTERED";
    }

    void out()
    {
        System.out.println("Citizen Name: " + name + ", Age: " + age + ", Unique ID: " + UID);
    }
}

class slot
{
    int day_number, quantity;
    String vaccine, hospitalId;

    slot(int day_no, int quant, int vaccine_no, String h_id)
    {
        day_number = day_no;
        quantity = quant;
        hospitalId = h_id;

        if(vaccine_no == 0)
            vaccine = "Covax";
        else if(vaccine_no == 1)
            vaccine = "Covi";
    }

    void out()
    {
        System.out.println("Slot added by hospital " + hospitalId + " for Day: " + day_number + ", Available Quantity: " + quantity + " of vaccine " + vaccine);
    }

    void displaySlot()
    {
        System.out.print("Day: " + day_number + " Vaccine: " + vaccine + " Qty: " + quantity);
        System.out.println();
    }
}

