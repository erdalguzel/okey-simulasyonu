public class Tile {
    private static final String[] COLORS = {"Sarı", "Mavi", "Siyah", "Kırmızı"};

    public static String getTileName(int tile) {
        if (tile == 52) return "Sahte-Okey";

        int color = tile / 13;
        int number = (tile % 13) + 1;
        return COLORS[color] + "-" + number;
    }

    public static int getTileColor(int tile) {
        if (tile == 52) return -1; // Sahte okey
        return tile / 13;
    }

    public static int getTileCount(int tile) {
        if (tile == 52) return 0; // Sahte okey
        return (tile % 13) + 1;
    }

    public static boolean isOkey(int tile, int okeyTile) {
        return tile == okeyTile || tile == 52; // Normal okey veya sahte okey
    }
}
