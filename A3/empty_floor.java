public class empty_floor extends floor {
    empty_floor(int location)
    {
        type = "Empty floor";
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
        return 1;
    }
}
