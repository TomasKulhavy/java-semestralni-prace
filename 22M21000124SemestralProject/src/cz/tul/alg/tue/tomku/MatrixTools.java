package cz.tul.alg.tue.tomku;

/**
 * Třída pro práci s maticemi.
 */
public class MatrixTools {
    /**
     * Zkontroluje zda je porovnávaná matice symetrická podle hlavní diagonály.
     * @param a, matice s proměnnými integer.
     * @param b, matice s proměnnými integer.
     * @return boolean výsledku
     */
    public static boolean isSymetricMainDiag(int[][] a, int[][] b) {
        // Cyklus for postupně porovnává prvky zrcadlově podle hlavní diagonály.
        for (int c = 0; c < a.length; c++) {
            for (int r = 0; r < c; r++) {
                if (a[c][r] != b[r][c]) return false;
            }
        }
        return true;
    }

    /**
     * Zkontroluje zda je porovnávaná matice symetrická podle vedlejší diagonály.
     * @param a, matice s proměnnými integer.
     * @param b, matice s proměnnými integer.
     * @return boolean výsledku
     */
    public static boolean isSymetricSideDiag(int[][] a, int[][] b) {
        // Cyklus for postupně porovnává prvky zrcadlově podle vedlejší diagonály.
        for (int c = 0; c < a.length - 1; c++) {
            for (int r = 0; r < a[c].length - 1 - c; r++) {
                if (a[c][r] != b[a.length - 1 - r][a[c].length - 1 - c]) return false;
            }
        }
        return true;
    }

    /**
     * Zkontroluje zda je porovnávaná matice symetrická podle vertikální osy.
     * @param a, matice s proměnnými integer.
     * @param b, matice s proměnnými integer.
     * @return boolean výsledku
     */
    public static boolean isSymetricVerticalAxis(int[][] a, int[][] b) {
        // Postupně cyklus for bere levý horní prvek a pravý horní prvek a postupuje směrem k sobě a poté dolů.
        for (int c = 0; c < a.length / 2; c++) {
            for (int r = 0; r < a[c].length; r++) {
                if (a[c][r] != b[a.length - 1 - c][r]) return false;
            }
        }
        return true;
    }

    /**
     * Zkontroluje zda je porovnávaná matice symetrická podle horizontální osy.
     * @param a, matice s proměnnými integer.
     * @param b, matice s proměnnými integer.
     * @return boolean výsledku
     */
    public static boolean isSymetricHorizontalAxis(int[][] a, int[][] b) {
        // Postupně cyklus for bere levý horní prvek a levý dolní prvek a postupuje směrem k sobě a poté doprava.
        for (int c = 0; c < a.length; c++) {
            for (int r = 0; r < a[c].length / 2; r++) {
                if (a[c][r] != b[c][a[c].length - 1 - r]) return false;
            }
        }
        return true;
    }
}
