public class TileDistributor {

    public static void distributeTiles(Player[] players, Deck deck, int shownTile) {
        // Gösterge taşını desteden çıkar
        deck.pullShownTile(shownTile);

        int desteIndex = 0;

        // İlk oyuncuya 15 taş
        for (int i = 0; i < 15; i++) {
            players[0].addTile(deck.pullTile(desteIndex++));
        }

        // Diğer oyunculara 14'er taş
        for (int oyuncu = 1; oyuncu < 4; oyuncu++) {
            for (int i = 0; i < 14; i++) {
                players[oyuncu].addTile(deck.pullTile(desteIndex++));
            }
        }
    }
}
