import java.util.*;

public class slot
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

    public void out()
    {
        System.out.println("Slot added by hospital " + hospitalId + " for Day: " + day_number + ", Available Quantity: " + quantity + " of vaccine " + vaccine);
    }

    public void displaySlot()
    {
        System.out.print("Day: " + day_number + " Vaccine: " + vaccine + " Qty: " + quantity);
        System.out.println();
    }

    public void reduceQuantity(int a)
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

    int getQuantity()
    {
        return quantity;
    }
}
