package com.letscode.battlefield.utils;

import com.letscode.battlefield.enums.Menu;

import java.util.Scanner;

public class Writer {
    Scanner scan = new Scanner(System.in);
    private String name = "";

    public String setName() { return this.name = scan.next(); }

    public Integer menuChoosen() {
        Integer choice = null;
        try {
            choice = scan.nextInt();
        } catch (Exception e) {
            System.out.println("Invalid input. Please try again.");
            scan.nextLine();
        }

        return choice;
    }

    // Colors
    private static final String ANSI_RESET = "\u001B[0m";
    private static final String ANSI_CYAN = "\u001B[36m";
    // Board
    private static final String SEPARATOR = "---------------------------------------------";

    // Inicitiol menu
  /*
    -------------------------------------
                BATALHA NAVAL
    -------------------------------------
               [1] Iniciar
               [2] Tutorial
               [3] Sobre
               [4] Sair
    -------------------------------------
    Resposta: 1
  */


    /*
      ---------------------------------------------
                        JOGADOR
      ---------------------------------------------
      |   | 0 | 1 | 2 | 3 | 4 | 5 | 6 | 7 | 8 | 9 |
      ---------------------------------------------
      | A | N |   |   |   |   |   |   |   |   |   |
      ---------------------------------------------
      | B |   |   |   |   |   | * |   |   |   | N |
      ---------------------------------------------
      | C |   |   | N |   |   |   |   |   |   |   |
      ---------------------------------------------
      | D |   |   |   |   | N |   |   |   |   |   |
      ---------------------------------------------
      | E |   |   |   |   |   |   | N |   | - |   |
      ---------------------------------------------
      | F |   |   | - |   |   |   |   |   |   |   |
      ---------------------------------------------
      | G |   |   |   |   |   |   |   |   | N |   |
      ---------------------------------------------
      | H |   | - |   |   |   |   | N |   |   |   |
      ---------------------------------------------
      | I | N |   |   |   |   |   |   |   |   |   |
      ---------------------------------------------
      | J |   |   |   |   |   |   | N |   |   |   |
      ---------------------------------------------
  */
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
