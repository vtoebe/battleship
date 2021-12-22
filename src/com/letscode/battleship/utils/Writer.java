package com.letscode.battleship.utils;

import com.letscode.battleship.entities.Player;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Writer {
    static Scanner scan = new Scanner(System.in);
    private static Player player1;
    private static Player player2;
    static int[] coordinates = new int[2];

    public static void setPlayer1() { player1 = new Player(scan.next()); }
    public static Player getPlayer1() { return player1; }

    public static void setPlayer2() { player2 = new Player(scan.next()); }
    public static void setPlayer2(String name) { player2 = new Player(name); }
    public static Player getPlayer2() { return player2; }

    public static int[] getCoordinates() { return coordinates; }

    public int menuSelection() {
        int choice = 0;
        try {
            choice = scan.nextInt();
        } catch (InputMismatchException e) {
            System.out.println(Printer.INVALID_CHOICE);
            scan.nextLine();
        }
        return choice;
    }

    public static int[] getRandomCoordinates() {
        int x = (int) (Math.random() * 10);
        int y = (int) (Math.random() * 10);
        return new int[] {x, y};
    }

    public static boolean getLine() {
        final String[] LINE_LETTERS = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j"};
        String line = scan.next();

        if (Arrays.asList(LINE_LETTERS).contains(line)) {
            coordinates[0] = charToInt(line);
            return true;
        } else {
            System.out.println(Printer.INVALID_CHOICE);
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
            System.out.println(Printer.INVALID_CHOICE);
            return false;
        }
    }

    private static int charToInt(String letter) {
        char charLetter = letter.toLowerCase().charAt(0);
        switch (charLetter) {
            case 'a':
                return 0;
            case 'b':
                return 1;
            case 'c':
                return 2;
            case 'd':
                return 3;
            case 'e':
                return 4;
            case 'f':
                return 5;
            case 'g':
                return 6;
            case 'h':
                return 7;
            case 'i':
                return 8;
            case 'j':
                return 9;
            default:
                return -1;
        }
    }
}
