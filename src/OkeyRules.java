public class OkeyRules {
    public static int findOkeyTile(int okeyTile) {
        if (okeyTile == 52) { // Sahte okey gösterge ise
            return 52; // Sahte okey kendisi okey olur
        }

        int color = Tile.getTileColor(okeyTile);
        int number = Tile.getTileCount(okeyTile);

        // Bir sonraki sayı
        int okeyNumber = number + 1;
        if (okeyNumber > 13) {
            okeyNumber = 1;
        }

        return color * 13 + (okeyNumber - 1);
    }
}
