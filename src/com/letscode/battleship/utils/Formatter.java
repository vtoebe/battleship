package com.letscode.battleship.utils;

public class Formatter {
    static final String ANSI_RESET = "\u001B[0m";
    static final String ANSI_CYAN = "\u001B[36m";
    static final String ANSI_RED = "\u001B[31m";
    static final String ANSI_GREEN = "\u001B[32m";
    static final String SEPARATOR = "-";
    static final char[] COLUMN_POSITION = {' ', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
    static final char[] ROW_POSITION = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J'};

    static String center(String text, int size) {
        int center = size / 2 - text.length() / 2;
        return String.format("%" + (center) + "s", "") + text;
    }

    static String right(String text) {
        return String.format("%" + (12) + "s", "") + text;
    }

    static int charToInt(String letter) {
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
