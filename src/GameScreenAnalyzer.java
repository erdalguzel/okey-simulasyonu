import java.util.List;

public class GameScreenAnalyzer {
    public static void printTileInfo(int shownTile, int okeyTile) {
        System.out.println("Gösterge Taşı: " + Tile.getTileName(shownTile));
        System.out.println("Okey Taşı: " + Tile.getTileName(okeyTile));
        System.out.println();
    }

    public static void printPlayerResult(ResultAnalyzer.GameResult result, int handSize) {
        System.out.println("\n" + result.getPlayerName() + " (" + handSize + " taş):");
        System.out.println("Taşlar: " + String.join(", ", result.getTileDefinitions()));
        System.out.println("Kullanılabilir taş sayısı: " + result.getUsableTiles());
        System.out.println("Kalan taş sayısı: " + result.getRemainingTiles());
    }

    public static void printResults(List<String> bestPlayers, int bestScore) {
        System.out.println("\n=== SONUÇ ===");
        System.out.println("En iyi el(ler) (bitmeye en yakın):");
        for (String playerName : bestPlayers) {
            System.out.println("- " + playerName + " (Kullanılabilir taş: " + bestScore + ")");
        }
    }
}

