public class snake_floor extends floor {

    snake_floor(int location)
    {
        type = "Snake floor";
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
        return -2;
    }

    @Override
    public int newLocation()
    {
        return 1;
    }
    
}
