import java.util.*;

public class dice {
    private int number;

    public int roll()
    {
        Random random = new Random();
        number = random.nextInt(2) + 1;
        return number;
    }

    /**
     * @return int return the number
     */
    public int getNumber() {
        return number;
    }

    /**
     * @param number the number to set
     */
    public void setNumber(int number) {
        this.number = number;
    }

}
