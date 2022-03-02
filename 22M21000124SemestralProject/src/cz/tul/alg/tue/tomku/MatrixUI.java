package cz.tul.alg.tue.tomku;

/**
 * Třída UserInterface pro úlohu s maticemi.
 */
public class MatrixUI {
    // Vypíše matici do konzole
    public static void show(int[][] a) {
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                System.out.format("%4d", a[i][j]);
            }
            System.out.println();
        }
    }

    public static void UserInput() {
        int matrix = 0;
        String matrixString = "";

        do {
            Main.sc.nextLine();
            System.out.print("\nRozměr matic: ");
            do {
                matrixString = Main.sc.next();
                if (!Main.isStringInt(matrixString)) {
                    System.out.println("Zadejte pouze celé číslo!");
                } else {
                    matrix = Integer.parseInt(matrixString);
                }
            } while (!Main.isStringInt(matrixString));

            // Ošetření, že pokud uživatel zadá nulové nebo záporné číslo, program skončí.
            if (matrix < 1) break;

            // Deklarace matic
            int[][] matrixNo1 = new int[matrix][matrix];
            int[][] matrixNo2 = new int[matrix][matrix];

            // Načtení matic
            System.out.println("První matice: ");
            for (int i = 0; i < matrix; i++) {
                for (int j = 0; j < matrix; j++) {
                    matrixNo1[i][j] = Main.sc.nextInt();
                }
            }

            System.out.println("Druhá matice: ");
            for (int i = 0; i < matrix; i++) {
                for (int j = 0; j < matrix; j++) {
                    matrixNo2[i][j] = Main.sc.nextInt();
                }
            }

            // Výpis matic
            System.out.println();
            show(matrixNo1);
            System.out.println();
            show(matrixNo2);
            System.out.println();

            // Uložení výsledků do proměnných
            boolean isHorizontal = (MatrixTools.isSymetricHorizontalAxis(matrixNo1, matrixNo2));
            boolean isVertical = (MatrixTools.isSymetricVerticalAxis(matrixNo1, matrixNo2));
            boolean isMainDiag = (MatrixTools.isSymetricMainDiag(matrixNo1, matrixNo2));
            boolean isSideDiag = (MatrixTools.isSymetricSideDiag(matrixNo1, matrixNo2));

            // Výpis výsledků pomocí ternárního operátoru.
            System.out.format("%s%s%s%s%s",
                    (isHorizontal) ? "Zrcadlení dle horizontální osy." : "",
                    (isVertical) ? "\nZrcadlení dle vertikální osy." : "",
                    (isMainDiag) ? "\nZrcadlení dle hlavní diagonály." : "",
                    (isSideDiag) ? "\nZrcadlení dle vedlejší diagonály." : "",
                    (!(isHorizontal || isVertical || isMainDiag || isSideDiag)) ? "Nenalezena transformace." : ""); // Pokud ani jeden výsledek není true, tak se toto vypíše.
        } while (matrix > 0);
    }
}
