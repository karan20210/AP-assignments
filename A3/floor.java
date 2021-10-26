abstract public class floor {
    private int points;
    private int location;
    protected String type;
    
    /**
     * @return int return the points
     */
    public int getPoints() {
        return points;
    }

    /**
     * @param points the points to set
     */
    public void setPoints(int points) {
        this.points = points;
    }

    /**
     * @return int return the location
     */
    public int getLocation() {
        return location;
    }

    /**
     * @param location the location to set
     */
    public void setLocation(int location) {
        this.location = location;
    }

    public String getType()
    {
        return type;
    }

    public void setType(String s)
    {
        this.type = s;
    }

    public int newLocation()
    {
        return location;
    }

}
