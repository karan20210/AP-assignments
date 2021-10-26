import java.util.*;

public class game {
    
    private int total_points;
    private player current_player;
    private ArrayList<floor> floors = new ArrayList<>();

    game(player p)
    {
        System.out.println("The game setup is ready");
        current_player = p;
        
        floors.add(new empty_floor(1));
        floors.add(new elevator(2));
        floors.add(new empty_floor(3));
        floors.add(new empty_floor(4));
        floors.add(new snake_floor(5));
        floors.add(new empty_floor(6));
        floors.add(new empty_floor(7));
        floors.add(new ladder_floor(8));
        floors.add(new empty_floor(9));
        floors.add(new empty_floor(10));
        floors.add(new king_cobra(11));
        floors.add(new empty_floor(12));
        floors.add(new empty_floor(13));
    }

    public floor getFloor(int location)
    {
        return floors.get(location-1);
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

    /**
     * @return player return the current_player
     */
    public player getCurrent_player() {
        return current_player;
    }

    /**
     * @param current_player the current_player to set
     */
    public void setCurrent_player(player current_player) {
        this.current_player = current_player;
    }


}
