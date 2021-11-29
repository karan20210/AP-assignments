import java.util.*;

public class carpet {

    private ArrayList<tile> tiles;

    public carpet()
    {
        tiles = new ArrayList<tile>();
        tiles.add(new tile("Rubix Cube"));
        tiles.add(new tile("Minion"));
        tiles.add(new tile("Spider Man"));
        tiles.add(new tile("Batman"));
        tiles.add(new tile("Santa Claus"));
        tiles.add(new tile("Cosco Ball"));
        tiles.add(new tile("Football"));
        tiles.add(new tile("Jerry"));
        tiles.add(new tile("Tom"));
        tiles.add(new tile("Teddy Bear"));
        tiles.add(new tile("Bird"));
        tiles.add(new tile("PS4"));
        tiles.add(new tile("PS5"));
        tiles.add(new tile("iPhone 13 Pro Max"));
        tiles.add(new tile("RC car"));
        tiles.add(new tile("Monopoly"));
        tiles.add(new tile("Pictionary"));
        tiles.add(new tile("iPad Pro"));
        tiles.add(new tile("Smurf"));
        tiles.add(new tile("Football"));
    }

    
    public ArrayList<tile> getTiles() {
        return tiles;
    }

    public void setTiles(ArrayList<tile> tiles) {
        this.tiles = tiles;
    }

}
