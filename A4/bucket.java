import java.util.*;

public class bucket {

    private ArrayList<softToy> toys;

    public bucket()
    {
        toys = new ArrayList<softToy>();
    }

    public ArrayList<softToy> getToys() {
        return toys;
    }

    public void setToys(ArrayList<softToy> toys) {
        this.toys = toys;
    }

    public void addToy(softToy t)
    {
        toys.add(t);
    }

}
