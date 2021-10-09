import java.util.*;

public class cowin
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
    public cowin()
    {
        System.out.println("Cowin Portal Initialized...");
    }

    public void displayMenu()
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

    public void addVaccine()
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

    public void addHospital()
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

    public void addCitizen()
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

    public void addSlot()
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

    public void bookSlot()
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
            boolean exists = false;

            System.out.print("Enter pincode: ");
            pincode = scan_s.nextLine();

            for(hospital h: hospitalMap.values())
            {   
                if(pincode.equals(h.getPin()))
                {
                    exists = true;
                    System.out.println(h.getId() + " " + h.getName());
                    availableHospitals.add(h.getId());
                }
            }

            if(exists == false)
            {
                System.out.println("No slots found!!");
                return;
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
            int cnt = h.displaySlotsForBooking();

            if(cnt!=0)
            {
                System.out.print("Choose slot: ");
                int slot_no = scan_i.nextInt();

                c.getVaccinated(slot_no, h, vaccineMap);
            }

            else
                System.out.println("No slots");
        }

        if(choice == 2)
        {
            ArrayList<String> availableHospitals = new ArrayList<>();
            String vaccine_name;
            System.out.println("Searching by vaccine...");
            System.out.print("Enter vaccine name: ");
            vaccine_name = scan_s.nextLine();
            boolean exists = false;

            for(hospital h: hospitalMap.values())
            {
                if(h.getVaccineNames().contains(vaccine_name))
                {
                    exists = true;
                    System.out.println(h.getId() + " " + h.getName());
                    availableHospitals.add(h.getId());
                }
            }

            if(exists == false)
            {
                System.out.println("No slots found!!");
                return;
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
            h.displaySlotsForBooking(vaccine_name);

            System.out.print("Choose slot: ");
            int slot_no = scan_i.nextInt();

            c.getVaccinated(slot_no, h, vaccineMap);
        }
    }

    public void displayHospitalSlots()
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

    public void checkVaccinationStatus()
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