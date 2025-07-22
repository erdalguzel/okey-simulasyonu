import java.util.*;

public class Player {
    private String name;
    private List<Integer> hand;

    public Player(String name) {
        this.name = name;
        this.hand = new ArrayList<>();
    }

    public void addTile(int tas) {
        hand.add(tas);
    }

    public String getName() {
        return name;
    }

    public List<Integer> getHand() {
        return new ArrayList<>(hand); // Defensive copy
    }

    public int getSize() {
        return hand.size();
    }

    public List<String> getTiles() {
        List<String> tiles = new ArrayList<>();
        for (int tas : hand) {
            tiles.add(Tile.getTileName(tas));
        }
        Collections.sort(tiles);
        return tiles;
    }
}
