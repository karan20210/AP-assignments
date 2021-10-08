import java.util.*;

class a1
{
    public static void main(String[] args) {
        cowin c = new cowin();
        c.displayMenu();
        
    }

}

class cowin
{
    Scanner scan_s = new Scanner(System.in);
    Scanner scan_i = new Scanner(System.in);

    //HashMap for vaccines
    // HashMap<String, ArrayList> vaccineMap = new HashMap<>();
    HashMap<String, vaccine> vaccineMap = new HashMap<>();

    // HashMap for hospital
    HashMap<String, hospital> hospitalMap = new HashMap<>();

    //HashMap for citizens
    HashMap<String, citizen> citizenMap = new HashMap<>();

    //HashMap for slots
    HashMap<String, ArrayList<slot>> slotMap = new HashMap<>();
    
    // Constructor
    cowin()
    {
        System.out.println("Cowin Portal Initialized...");
    }

    void displayMenu()
    {
        Scanner scan = new Scanner(System.in);
        System.out.println("-----------------------------------------");
        System.out.println("1. Add Vaccine");
        System.out.println("2. Register Hospital");
        System.out.println("3. Register Citizen");
        System.out.println("4. Add Slot for vaccination");
        System.out.println("5. Book Slot for vaccination");
        System.out.println("6. List all slots for a hospital");
        System.out.println("7. Check vaccination status");
        System.out.println("8. Exit");

        System.out.print("Enter number: ");
        int c = scan.nextInt();

        switch(c)
        {
            case 1: addVaccine();
                    displayMenu();
                    break;

            case 2: addHospital();
                    displayMenu();
                    break;

            case 3: addCitizen();
                    displayMenu();
                    break;

            case 4: addSlot();
                    displayMenu();
                    break;

            case 5: bookSlot();
                    displayMenu();
                    break;

            case 6: displayHospitalSlots();
                    displayMenu();
                    break;
            
            case 7: checkVaccinationStatus();
                    displayMenu();
                    break;

            case 8: break;
        }
    }

    void addVaccine()
    {
        String name;
        int doses_reqd, gap;

        System.out.print("Vaccine name: ");
        name = scan_s.nextLine();

        System.out.print("Number of doses: ");
        doses_reqd = scan_i.nextInt();

        if(doses_reqd!=1)
        {
            System.out.print("Gap between Doses: ");
            gap = scan_i.nextInt();
        }

        else
            gap = 0;

        vaccine v = new vaccine(name, doses_reqd, gap);
        v.out();
        vaccineMap.put(name, v);
    }

    void addHospital()
    {
        String name, pincode;

        System.out.print("Hospital Name: ");
        name = scan_s.nextLine();

        System.out.print("Pincode: ");
        pincode = scan_s.nextLine();

        hospital h = new hospital(name, pincode, hospitalMap);
        String h_id = h.out();

        hospitalMap.put(h_id, h);
    }

    void addCitizen()
    {
        String name, UID = "";
        int age;
        
        System.out.print("Citizen Name: ");
        name = scan_s.nextLine();

        System.out.print("Age: ");
        age = scan_i.nextInt();

        while(true)
        {
            System.out.print("Unique ID (12 digit number): ");
            UID = scan_s.nextLine();

            if(UID.equals("exit"))
            {
                System.out.println("Exiting...");
                return;
            }

            if(UID.length() != 12)
            {
                System.out.println("UID should be of 12 characters!!");
                continue;
            }

            if(!citizenMap.containsKey(UID))
                break;
            else
            {
                System.out.println("UID Already exists!");
            }
        }

        citizen c = new citizen(name, age, UID);
        c.out();
        if(age < 18)
        {
            System.out.println("Vaccination only available for 18+");
            return;
        }
        citizenMap.put(UID, c);
    }

    void addSlot()
    {
        String h_id = "";

        while(true)
        {
            System.out.print("Enter Hospital Id: ");
            h_id = scan_s.nextLine();

            if(h_id.equals("exit"))
            {
                System.out.println("Exiting...");
                return;
            }

            if(!hospitalMap.containsKey(h_id))
            {
                System.out.println("Not a valid hospital ID!! Try Again");
            }

            else
            {
                break;
            }
        }

        int no_slots, day_no, quantity, vax;

        System.out.print("Enter number of slots to be added: ");
        no_slots = scan_i.nextInt();

        for(int i = 0; i<no_slots; i++)
        {
            System.out.print("Enter Day Number: ");
            day_no = scan_i.nextInt();
            System.out.print("Enter Quantity: ");
            quantity = scan_i.nextInt();
            System.out.println("Select Vaccine: ");

            Set<String> keys = vaccineMap.keySet();
            int cnt = 0;

            ArrayList<String> vaccines = new ArrayList<>();

            for(String v: keys)
            {
                System.out.println(cnt + ". " + v);
                cnt++;
                vaccines.add(v);
            };

            vax = scan_i.nextInt();

            slot s = new slot(day_no, quantity, h_id, vaccines.get(vax));
            s.out();
            hospitalMap.get(h_id).addSlot(s, slotMap);
        }


    }

    void bookSlot()
    {
        String uid = "";

        while(true)
        {
            System.out.print("Enter patient Unique Id: ");
            uid = scan_s.nextLine();

            if(uid.equals("exit"))
            {
                System.out.println("Exiting...");
                return;
            }

            if(!citizenMap.containsKey(uid))
                System.out.println("No one exists with that UID!! Try Again");
            else
                break;
        }

        citizen c = citizenMap.get(uid);

        if(c.getVaccinationStatus().equals("FULLY VACCINATED"))
        {
            System.out.println("Person is fully vaccinated");
            return;
        }

        System.out.println("1. Search by area");
        System.out.println("2. Search by vaccine");
        System.out.println("3. Exit");

        int choice = scan_i.nextInt();

        if(choice == 1)
        {
            ArrayList<String> availableHospitals = new ArrayList<>();
            System.out.println("Searching by area...");
            String pincode;

            System.out.print("Enter pincode: ");
            pincode = scan_s.nextLine();

            for(hospital h: hospitalMap.values())
            {
                
                if(pincode.equals(h.getPin()))
                {
                    System.out.println(h.getId() + " " + h.getName());
                    availableHospitals.add(h.getId());
                }
            }

            String h_id;
            System.out.print("Enter hospital Id: ");
            h_id = scan_s.nextLine();

            if(!availableHospitals.contains(h_id))
            {
                System.out.println("Invalid hospital!");
                return;
            }

            hospital h = hospitalMap.get(h_id);
            h.displaySlotsForBooking();

            System.out.print("Choose slot: ");
            int slot_no = scan_i.nextInt();

            c.getVaccinated(slot_no, h, vaccineMap);
        }

        if(choice == 2)
        {
            ArrayList<String> availableHospitals = new ArrayList<>();
            String vaccine_name;
            System.out.println("Searching by vaccine...");
            System.out.print("Enter vaccine name: ");
            vaccine_name = scan_s.nextLine();

            for(hospital h: hospitalMap.values())
            {
                if(h.getVaccineNames().contains(vaccine_name))
                {
                    System.out.println(h.getId() + " " + h.getName());
                    availableHospitals.add(h.getId());
                }
            }

            String h_id;
            System.out.print("Enter hospital Id: ");
            h_id = scan_s.nextLine();

            if(!availableHospitals.contains(h_id))
            {
                System.out.println("Invalid hospital!");
                return;
            }

            hospital h = hospitalMap.get(h_id);
            h.displaySlotsForBooking();

            System.out.print("Choose slot: ");
            int slot_no = scan_i.nextInt();

            c.getVaccinated(slot_no, h, vaccineMap);
        }
    }

    void displayHospitalSlots()
    {
        String h_id = "";
        while(true)
        {
            if(h_id.equals("exit"))
            {
                System.out.println("Exiting...");
                return;
            }
            System.out.print("Enter Hospital Id: ");
            h_id = scan_s.nextLine();

            if(!hospitalMap.containsKey(h_id))
            {
                System.out.println("Not a valid hospital ID!! Try Again");
            }

            else
            {
                break;
            }
        }

        hospitalMap.get(h_id).displaySlots();

    }

    void checkVaccinationStatus()
    {
        String uid;

        while(true)
        {
            System.out.print("Enter patient Unique Id: ");
            uid = scan_s.nextLine();

            if(uid.equals("exit"))
            {
                System.out.println("Exiting...");
                return;
            }

            if(!citizenMap.containsKey(uid))
                System.out.println("No one exists with that UID!! Try Again");
            else
                break;
        }

        citizen c = citizenMap.get(uid);
        c.getVaccinationDetails();

    }
}

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

    int getDoses()
    {
        return doses_reqd;
    }

    int getGap()
    {
        return gap;
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

    void displaySlotsForBooking()
    {
        int cnt = 0;
        for(slot i: slots)
        {
            System.out.print(cnt + " --> ");
            i.displaySlot();
            cnt++;
        }
    }

    String takeVaccineFromHospital(int slot_no, String vaccine_taken, String vaccination_status)
    {
        int cnt = 0;
        String vaccine_name = "";
        for(slot i: slots)
        {
            if(slot_no == cnt)
            {
                vaccine_name = i.getName();
                if(vaccination_status.equals("PARTIALLY VACCINATED"))
                {
                    if(!vaccine_name.equals(vaccine_taken))
                    {
                        System.out.println("Can't take 2 different vaccines!!");
                        return "-1";
                    }
                }
            }

            cnt++;
        }

        return vaccine_name;
    }

    int getDayOfVaccination(int slot_no)
    {
        int cnt = 0, day = 0;
        for(slot i: slots)
        {
            if(slot_no == cnt)
            {
                day = i.getDay();
                // i.reduceQuantity(1);
            }
            cnt++;
        }

        return day;
    }

    slot getSlot(int slot_no)
    {
        int cnt = 0;
        for(slot i: slots)
        {
            if(slot_no == cnt)
                return i;
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
    String name, UID, vaccination_status, vaccine_taken = "\0";
    int age, no_of_doses = 0, next_due_date, reqd_number_of_doses;

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

    void getVaccinated(int slot_no, hospital h, HashMap<String, vaccine> vaccineMap)
    {
        // String vaccine_name = h.takeVaccineFromHospital(slot_no, vaccine_taken, vaccination_status);
        // if(vaccine_name == "-1")
        //     return;
        
        // int day_of_vaccination = h.getDayOfVaccination(slot_no);

        slot vaccine_Slot = h.getSlot(slot_no);
        String vaccine_name = vaccine_Slot.getName();
        int day_of_vaccination = vaccine_Slot.getDay();

        vaccine_taken = vaccine_name;
        no_of_doses++;
        reqd_number_of_doses = vaccineMap.get(vaccine_taken).getDoses();

        if(no_of_doses > 0 && no_of_doses < reqd_number_of_doses)
        {
            vaccination_status = "PARTIALLY VACCINATED";
            next_due_date = day_of_vaccination + vaccineMap.get(vaccine_taken).getGap();
        }

        if(day_of_vaccination < next_due_date)
        {
            System.out.println("Wait for next due date!");
            no_of_doses--;
            return;
        }

        if(no_of_doses == reqd_number_of_doses)
            vaccination_status = "FULLY VACCINATED";

        System.out.println(name + " vaccinated with " + vaccine_name);

    }

    void getVaccinationDetails()
    {
        System.out.println(vaccination_status);

        if(vaccination_status.equals("REGISTERED"))
            return;
        System.out.println("Vaccine given: " + vaccine_taken);
        System.out.println("No. of doses given: " + no_of_doses);

        if(vaccination_status.equals("PARTIALLY VACCINATED"))
            System.out.println("Next Dose due data: " + next_due_date);
    }

    int getAge()
    {
        return age;
    }

    String getVaccinationStatus()
    {
        return vaccination_status;
    }
}

class slot
{
    int day_number, quantity;
    String vaccine, hospitalId;

    slot(int day_no, int quant, String h_id, String vax_name)
    {
        day_number = day_no;
        quantity = quant;
        hospitalId = h_id;

        vaccine = vax_name;
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

    void reduceQuantity(int a)
    {
        quantity = quantity - a;
    }

    String getName()
    {
        return vaccine;
    }

    int getDay()
    {
        return day_number;
    }
}
