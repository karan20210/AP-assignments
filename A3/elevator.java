public class elevator extends floor{
    elevator(int location)
    {
        type = "Elevator";
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
        return 4;
    }

    @Override
    public int newLocation()
    {
        return 10;
    }
}
