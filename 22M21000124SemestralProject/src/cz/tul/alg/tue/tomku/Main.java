package cz.tul.alg.tue.tomku;

import java.util.Scanner;

/**
 * @author Tomáš Kulhavý - M21000124
 * 22. úloha
 * Program s UI pro výběr mezi vánoční úlohou nebo semestrální prací.
 * Semestrální práce požaduje vstup dvou matic. Poté porovná druhou matici s první.
 * Vypíše jestli je symetrická podle hlavní, vedlejší diagonály nebo vertikální nebo horizontální osy.
 * Pokud žádná taková transformace neexistuje vypíše, že neexistuje.
 */
public class Main {
    public static Scanner sc = new Scanner(System.in);

    public static boolean isStringInt(String s)
    {
        try
        {
            Integer.parseInt(s);
            return true;
        } catch (NumberFormatException ex)
        {
            return false;
        }
    }

    public static void main(String[] args) {
        boolean end = false;

        do {
            displayMenu();
            int choice = 0;
            String choiceString = "";
            do {
                choiceString = sc.next();
                if (!isStringInt(choiceString)) {
                    System.out.println("Zadejte pouze celé číslo!");
                    choiceString = "";
                } else {
                    choice = Integer.parseInt(choiceString);
                }
            } while (!isStringInt(choiceString));

            switch (choice) {
                case 1:
                    ChristmasPresent.DrawChristmasPresent();
                    break;
                case 2:
                    MatrixUI.UserInput();
                    break;
                case 0:
                    end = true;
                    break;
                default:
                    System.out.println("Neplatný vstup!");
            }
        } while (!end);
    }

    // UI Menu
    public static void displayMenu() {
        System.out.println("\n1 - Vánoční úloha");
        System.out.println("2 - Semestrální práce");
        System.out.println("0 - EXIT");
    }
}
