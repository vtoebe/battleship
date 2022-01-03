package com.letscode.battleship.utils;

import com.letscode.battleship.entities.Player;

import java.util.*;

import static com.letscode.battleship.utils.BattleshipFormatter.charToInt;

public class BattleshipWriter {
    static Scanner scan = new Scanner(System.in);
    private static Player player1;
    private static Player player2;
    static int[] coordinates = new int[2];
    static ArrayList<int[]> computerCoordinates = new ArrayList<>();

    public static void setPlayer1() { player1 = new Player(scan.next()); }
    public static Player getPlayer1() { return player1; }

    public static void setPlayer2() { player2 = new Player(scan.next()); }
    public static void setPlayer2(String name) { player2 = new Player(name); }
    public static Player getPlayer2() { return player2; }

    public static int[] getCoordinates() { return coordinates; }

    public static int menuSelection() {
        int choice = 0;
        try {
            choice = scan.nextInt();
        } catch (InputMismatchException e) {
            System.out.println(BattleshipPrinter.INVALID_CHOICE);
            scan.nextLine();
        }
        return choice;
    }

    public static int[] getRandomCoordinates() {
        int num1, num2;
        do {
            num1 = (int) (Math.random() * 9);
            num2 = (int) (Math.random() * 9);
        } while(computerCoordinates.contains(new int[]{num1, num2}));

        computerCoordinates.add(new int[]{num1, num2});
        return coordinates;
    }

    public static boolean getLine() {
        final String[] LINE_LETTERS = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j"};
        String line = scan.next().toLowerCase();

        if (Arrays.asList(LINE_LETTERS).contains(line)) {
            coordinates[0] = charToInt(line);
            return true;
        } else {
            System.out.println(BattleshipPrinter.INVALID_CHOICE);
            return false;
        }
    }

    public static boolean getCol() {
        final String[] COL_NUMBERS = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
        String col = scan.next();

        if (Arrays.asList(COL_NUMBERS).contains(col)) {
            coordinates[1] = Integer.parseInt(col);
            return true;
        } else {
            System.out.println(BattleshipPrinter.INVALID_CHOICE);
            return false;
        }
    }
}
