import java.util.*;

public class player {
    private String name;
    private int current_position;
    private int moves;
    private game g;
    private dice d;
    private int total_points;

    player(String n)
    {
        name = n;
        g = new game(this);
        d = new dice();
        current_position = 0;
        moves = 0;
        total_points = 0;
    }

    public int play()
    {
        int number = d.roll();

        System.out.println("Dice gave " + number);

        if(moves == 0 && number!=1)
        {
            System.out.println("Game cannot start until you get 1");
            return 0;
        }

        current_position += number;
        if(current_position > 13)
        {
            System.out.println("Cannot move 2 steps from 12");
            current_position -= number;
            return 0;
        }

        total_points += (g.getFloor(current_position).getPoints());


        System.out.println("Player position floor - " + current_position);
        System.out.println(name + " has reached a " + g.getFloor(current_position).getType());
        System.out.println("Total points: " + total_points);
        
        if(!g.getFloor(current_position).getType().equals("Empty floor"))
        {
            changeFloor(g.getFloor(current_position));
        }

        moves++;

        if(current_position == 13)
        {
            System.out.println("GAME OVER");
            System.out.println(name + " accumulated " + total_points + " points");
            return 1;
        }

        return 0;
    }

    public void changeFloor(floor f)
    {
        int new_floor = f.newLocation();
        current_position = new_floor;
        total_points += (g.getFloor(current_position).getPoints());

        System.out.println("Player position floor: " + new_floor);
        System.out.println(name + " has reached a " + g.getFloor(current_position).getType());
        System.out.println("Total points: " + total_points);
        return;

    }


    /**
     * @return String return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return int return the current_position
     */
    public int getCurrent_position() {
        return current_position;
    }

    /**
     * @param current_position the current_position to set
     */
    public void setCurrent_position(int current_position) {
        this.current_position = current_position;
    }

    /**
     * @return int return the moves
     */
    public int getMoves() {
        return moves;
    }

    /**
     * @param moves the moves to set
     */
    public void setMoves(int moves) {
        this.moves = moves;
    }

    /**
     * @return game return the g
     */
    public game getG() {
        return g;
    }

    /**
     * @param g the g to set
     */
    public void setG(game g) {
        this.g = g;
    }

    /**
     * @return dice return the d
     */
    public dice getD() {
        return d;
    }

    /**
     * @param d the d to set
     */
    public void setD(dice d) {
        this.d = d;
    }


    /**
     * @return int return the total_points
     */
    public int getTotal_points() {
        return total_points;
    }

    /**
     * @param total_points the total_points to set
     */
    public void setTotal_points(int total_points) {
        this.total_points = total_points;
    }

}
