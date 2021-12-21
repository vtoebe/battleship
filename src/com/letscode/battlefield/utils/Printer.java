package com.letscode.battlefield.utils;

import com.letscode.battlefield.enums.Menu;

public class Printer {

    public static void requestName(){
        System.out.print("Nome do jogador: ");
    }

    // Colors
    private static final String ANSI_RESET = "\u001B[0m";
    private static final String ANSI_CYAN = "\u001B[36m";
    // Board
    private static final String SEPARATOR = "---------------------------------------------";

    public static void menu() {
        System.out.println(SEPARATOR);
        System.out.println(ANSI_CYAN + center("BATALHA NAVAL", SEPARATOR.length()) + ANSI_RESET);
        System.out.println(SEPARATOR);
        System.out.println(ANSI_CYAN + center("Por favor, escolha uma opção:", SEPARATOR.length()) + ANSI_RESET);
        System.out.println(right("[1] " + Menu.START.getDescription(), 16));
        System.out.println(right("[2] " + Menu.TUTORIAL.getDescription(), 16));
        System.out.println(right("[3] " + Menu.ABOUT.getDescription(), 16));
        System.out.println(right("[4] " + Menu.END_GAME.getDescription(), 16));

        // FIXME: check string builder/utils
        System.out.println(SEPARATOR);
        System.out.print("Resposta: ");
    }


    private static String center(String text, int size) {
        int center = size / 2 - text.length() / 2;
        return String.format("%" + (center) + "s", "") + text;
    }

    private static String right(String text, int size) {
        return String.format("%" + (size) + "s", "") + text;
    }

}
