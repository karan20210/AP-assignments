public class king_cobra extends floor
{
    king_cobra(int location)
    {
        type = "King Cobra";
        setLocation(location);
        setPoints(1);
    }

    /**
     * @return String return the type
     */
    @Override
    public String getType() {
        return type;
    }

    /**
     * @param type the type to set
     */
    @Override
    public void setType(String type) {
        this.type = type;
    }

    @Override
    public int getPoints()
    {
        return -4;
    }

    @Override
    public int newLocation()
    {
        return 3;
    }
    
}
