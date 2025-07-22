import java.util.*;

public class Deck {
    private List<Integer> tiles;
    private Random random;

    public Deck() {
        this.tiles = new ArrayList<>();
        this.random = new Random();
        createDeck();
    }

    private void createDeck() {
        // Her taştan 2 adet (0-52 arası)
        for (int i = 0; i <= 52; i++) {
            tiles.add(i);
            tiles.add(i);
        }
    }

    public void shuffleDeck() {
        Collections.shuffle(tiles, random);
    }

    public int chooseRandomTile() {
        return tiles.get(random.nextInt(tiles.size()));
    }

    public void pullShownTile(int shownTile) {
        tiles.removeIf(tile -> tile.equals(shownTile));
    }

    public int pullTile(int index) {
        return tiles.get(index);
    }

    public int size() {
        return tiles.size();
    }
}
