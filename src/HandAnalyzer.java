import java.util.*;

public class HandAnalyzer {

    public static int analyzeHand(List<Integer> hand, int okeyTile) {
        List<Integer> copiedHand = new ArrayList<>(hand);
        Collections.sort(copiedHand);

        // Okey sayısını hesapla ve normal taşları ayır
        int okeyCount = 0;
        List<Integer> normalTiles = new ArrayList<>();

        for (int tas : copiedHand) {
            if (Tile.isOkey(tas, okeyTile)) {
                okeyCount++;
            } else {
                normalTiles.add(tas);
            }
        }

        return findBestDistribution(normalTiles, okeyCount);
    }

    private static int findBestDistribution(List<Integer> normalTiles, int okeyCount) {
        if (normalTiles.size() + okeyCount == 0) return 0;

        // Taş sayılarını hesapla
        Map<Integer, Integer> tileNumbers = new HashMap<>();
        for (int tas : normalTiles) {
            tileNumbers.put(tas, tileNumbers.getOrDefault(tas, 0) + 1);
        }

        int totalUsed = 0;
        int currentOkey = okeyCount;

        // Çiftleri oluştur
        List<Integer> oddTiles = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : tileNumbers.entrySet()) {
            int tile = entry.getKey();
            int count = entry.getValue();

            if (count >= 2) {
                totalUsed += 2; // Çift oluştur
            } else {
                oddTiles.add(tile);
            }
        }

        // Kalan tek taşlarla seri oluştur
        int seriUsage = SerialAnalyzer.makeSeries(oddTiles, currentOkey);
        totalUsed += seriUsage;

        // Kalan okey taşlarını çift olarak kullan
        int remainingOkey = currentOkey - Math.max(0, seriUsage - oddTiles.size());
        if (remainingOkey > 0) {
            totalUsed += (remainingOkey / 2) * 2;
        }

        return totalUsed;
    }
}
