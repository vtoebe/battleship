package com.letscode.battleship.utils;

import com.letscode.battleship.enums.Menu;

public class Printer {
    private static final String NAME_REQUEST = "Enter the player name: ";
    private static final String BATTLESHIP_NAME = "BATTLESHIP";
    private static final String MENU_OPTION = "Please choose an option:";
    private static final String OPPONENT_SELECTION = "Select your opponent:";
    private static final String MENU_SELECTION = "Your selection: ";
    public static final String INVALID_CHOICE = "Invalid selection! Please try again.";

    private static final String REQUEST_COORDINATES = "Select a position to shoot";
    private static final String REQUEST_LINE = "Line (A-J): ";
    private static final String REQUEST_COL = "Column (0-9): ";

    // Colors
    private static final String ANSI_RESET = "\u001B[0m";
    private static final String ANSI_CYAN = "\u001B[36m";
    // Board
    private static final String SEPARATOR = "---------------------------------------------";

    public static void requestName(){
        System.out.print(NAME_REQUEST);
    }

    public static void gameInitialMenu() {
        System.out.println(SEPARATOR);
        System.out.println(ANSI_CYAN + center(BATTLESHIP_NAME, SEPARATOR.length()) + ANSI_RESET);
        System.out.println(SEPARATOR);
        System.out.println(ANSI_CYAN + center(MENU_OPTION, SEPARATOR.length()) + ANSI_RESET);
        System.out.println(right("[1] " + Menu.START.getDescription(), 16));
        System.out.println(right("[2] " + Menu.TUTORIAL.getDescription(), 16));
        System.out.println(right("[3] " + Menu.ABOUT.getDescription(), 16));
        System.out.println(right("[4] " + Menu.END_GAME.getDescription(), 16));

        // FIXME: check string builder/utils
        System.out.println(SEPARATOR);
        System.out.print(MENU_SELECTION);
    }

    public static void opponentSelectionMenu(){
        System.out.println(SEPARATOR);
        System.out.println(ANSI_CYAN + center(OPPONENT_SELECTION, SEPARATOR.length()) + ANSI_RESET);
        System.out.println(right("[1] Player 2", 16));
        System.out.println(right("[2] Machine", 16));
        // FIXME: check string builder/utils
        System.out.println(SEPARATOR);
        System.out.print(MENU_SELECTION);
    }

    public static void requestCoordinates(){
        System.out.println(REQUEST_COORDINATES);

        do {
            System.out.print(REQUEST_LINE);
        } while (!Writer.getLine());

        do {
            System.out.print(REQUEST_COL);
        } while (!Writer.getCol());
    }

    public static void printBoard(char[][] board, String player) {
        System.out.println();
        System.out.println(SEPARATOR);
        System.out.println(ANSI_CYAN + center(player, SEPARATOR.length()) + ANSI_RESET);
        System.out.println(SEPARATOR);

        for (char[] grid : board) {
            for (char value : grid) {
                System.out.printf("| %s ", value);
            }
            System.out.println("|");
            System.out.println(SEPARATOR);
        }
    }

    private static String center(String text, int size) {
        int center = size / 2 - text.length() / 2;
        return String.format("%" + (center) + "s", "") + text;
    }

    private static String right(String text, int size) {
        return String.format("%" + (size) + "s", "") + text;
    }

}
