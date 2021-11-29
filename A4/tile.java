public class tile{
    private softToy toy; 

    public tile(String toy_name)
    {
        toy = new softToy(toy_name);
    }

    public softToy getToy() {
        return toy;
    }

    public void setToy(softToy toy) {
        this.toy = toy;
    }

    public softToy winToy()
    {
        return toy.clone();
    }

}
