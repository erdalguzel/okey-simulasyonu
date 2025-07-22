import java.util.List;

public class Main {

    public static void main(String[] args) {
        // Oyun bileşenlerini oluştur
        Deck deck = new Deck();
        deck.shuffleDeck();

        // Gösterge taşı ve okey taşını belirle
        int shownTile = deck.chooseRandomTile();
        int okeyTile = OkeyRules.findOkeyTile(shownTile);

        // Ekran çıktıları
        System.out.println("=== OKEY OYUNU SİMÜLASYONU ===");
        GameScreenAnalyzer.printTileInfo(shownTile, okeyTile);

        // Oyuncuları oluştur
        Player[] players = new Player[4];
        for (int i = 0; i < 4; i++) {
            players[i] = new Player("Oyuncu " + (i + 1));
        }

        // Taş dağıtımı
        TileDistributor.distributeTiles(players, deck, shownTile);

        // Oyuncuları analiz et
        List<ResultAnalyzer.GameResult> results =
                ResultAnalyzer.analyzePlayers(players, okeyTile);

        System.out.println("=== OYUNCU ELLERİ VE ANALİZ ===");

        for (int i = 0; i < results.size(); i++) {
            GameScreenAnalyzer.printPlayerResult(results.get(i), players[i].getSize());
        }

        // En iyi oyuncuları belirle ve göster
        List<String> bestPlayer = ResultAnalyzer.findBestPlayer(results);
        int bestScore = results.isEmpty() ? 0 :
                results.stream()
                        .mapToInt(ResultAnalyzer.GameResult::getUsableTiles)
                        .max()
                        .orElse(0);

        GameScreenAnalyzer.printResults(bestPlayer, bestScore);
    }
}