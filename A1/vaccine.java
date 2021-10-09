import java.util.*;

public class vaccine
{
    String name;
    int doses_reqd, gap;

    vaccine(String n, int dr, int g)
    {
        name = n;
        doses_reqd = dr;
        gap = g;
    }

    public void out()
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
