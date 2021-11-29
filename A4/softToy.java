public class softToy implements Cloneable {
    private String name;

    public softToy(String s)
    {
        name = s;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public softToy clone()
    {
        try
        {
            softToy copy = (softToy) super.clone();
            return copy;
        }

        catch(CloneNotSupportedException e)
        {
            return null;
        }
    }

}
