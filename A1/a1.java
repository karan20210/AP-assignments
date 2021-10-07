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