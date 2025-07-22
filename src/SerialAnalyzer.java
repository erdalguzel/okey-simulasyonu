import java.util.*;

public class SerialAnalyzer {
    public static int makeSeries(List<Integer> oddTiles, int okeyNumber) {
        if (oddTiles.isEmpty()) return 0;

        // Renklere göre ayır ve seri oluşturmaya çalış
        Map<Integer, List<Integer>> coloredTiles = new HashMap<>();

        for (int tas : oddTiles) {
            int renk = Tile.getTileColor(tas);
            coloredTiles.computeIfAbsent(renk, k -> new ArrayList<>()).add(Tile.getTileCount(tas));
        }

        int totalUsage = 0;
        int okeyToUse = okeyNumber;

        for (List<Integer> colorTiles : coloredTiles.values()) {
            Collections.sort(colorTiles);

            // Ardışık sayıları kontrol et
            for (int i = 0; i < colorTiles.size(); i++) {
                int seriUzunlugu = 1;

                // Ardışık taşları say
                while (i + 1 < colorTiles.size() &&
                        colorTiles.get(i + 1) == colorTiles.get(i) + 1) {
                    i++;
                    seriUzunlugu++;
                }

                if (seriUzunlugu >= 3) {
                    totalUsage += seriUzunlugu;
                } else if (seriUzunlugu == 2 && okeyToUse > 0) {
                    // 2'li seriyi okey ile 3'e tamamla
                    totalUsage += 3;
                    okeyToUse--;
                }
            }
        }

        return Math.min(totalUsage, oddTiles.size() + okeyNumber);
    }

    public static List<Integer> findConsecutiveNumbers(List<Integer> numbers) {
        if (numbers.size() < 3) return new ArrayList<>();

        Collections.sort(numbers);
        List<Integer> consecutives = new ArrayList<>();

        for (int i = 0; i < numbers.size() - 2; i++) {
            if (numbers.get(i + 1) == numbers.get(i) + 1 &&
                    numbers.get(i + 2) == numbers.get(i) + 2) {
                consecutives.add(numbers.get(i));
                consecutives.add(numbers.get(i + 1));
                consecutives.add(numbers.get(i + 2));
                i += 2; // Bu taşları kullandık, atla
            }
        }

        return consecutives;
    }
}
