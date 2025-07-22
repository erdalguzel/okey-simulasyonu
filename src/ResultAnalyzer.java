import java.util.*;

public class ResultAnalyzer {

    public static class GameResult {
        private String playerName;
        private int usableTiles;
        private int remainingTiles;
        private List<String> tileDefinitions;

        public GameResult(String playerName, int usableTiles, int remainingTiles, List<String> tileDefinitions) {
            this.playerName = playerName;
            this.usableTiles = usableTiles;
            this.remainingTiles = remainingTiles;
            this.tileDefinitions = tileDefinitions;
        }

        // Getters
        public String getPlayerName() { return playerName; }
        public int getUsableTiles() { return usableTiles; }
        public int getRemainingTiles() { return remainingTiles; }
        public List<String> getTileDefinitions() { return tileDefinitions; }
    }

    public static List<GameResult> analyzePlayers(Player[] players, int okeyTile) {
        List<GameResult> results = new ArrayList<>();

        for (Player player : players) {
            int score = HandAnalyzer.analyzeHand(player.getHand(), okeyTile);
            int remainingTile = player.getSize() - score;

            GameResult result = new GameResult(
                    player.getName(),
                    score,
                    remainingTile,
                    player.getTiles()
            );

            results.add(result);
        }

        return results;
    }

    public static List<String> findBestPlayer(List<GameResult> results) {
        if (results.isEmpty()) return new ArrayList<>();

        int bestScore = results.stream()
                .mapToInt(GameResult::getUsableTiles)
                .max()
                .orElse(-1);

        List<String> bestPlayers = new ArrayList<>();
        for (GameResult result : results) {
            if (result.getUsableTiles() == bestScore) {
                bestPlayers.add(result.getPlayerName());
            }
        }

        return bestPlayers;
    }
}
