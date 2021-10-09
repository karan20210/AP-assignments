import java.util.*;

public class citizen
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

    public void out()
    {
        System.out.println("Citizen Name: " + name + ", Age: " + age + ", Unique ID: " + UID);
    }

    public void getVaccinated(int slot_no, hospital h, HashMap<String, vaccine> vaccineMap)
    {
        slot vaccine_Slot = h.getSlot(slot_no);
        if(vaccine_Slot == null)
            return;
        String vaccine_name = vaccine_Slot.getName();
        int day_of_vaccination = vaccine_Slot.getDay();

        if(no_of_doses != 0 && !vaccine_name.equals(vaccine_taken))
        {
            System.out.println("Cannot take 2 different vaccines");
            return;
        }

        vaccine_taken = vaccine_name;
        no_of_doses++;
        reqd_number_of_doses = vaccineMap.get(vaccine_taken).getDoses();

        if(day_of_vaccination < next_due_date && vaccination_status.equals("PARTIALLY VACCINATED"))
        {
            System.out.println("Wait for next due date!");
            no_of_doses--;
            return;
        }

        if(no_of_doses > 0 && no_of_doses < reqd_number_of_doses)
        {
            vaccination_status = "PARTIALLY VACCINATED";
            next_due_date = day_of_vaccination + vaccineMap.get(vaccine_taken).getGap();
        }


        if(no_of_doses == reqd_number_of_doses)
            vaccination_status = "FULLY VACCINATED";
        
        vaccine_Slot.reduceQuantity(1);

        System.out.println(name + " vaccinated with " + vaccine_name);
        h.checkSlots();

    }

    public void getVaccinationDetails()
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