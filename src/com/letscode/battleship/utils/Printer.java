package com.letscode.battleship.utils;

import com.letscode.battleship.entities.Player;
import com.letscode.battleship.enums.Menu;

import static com.letscode.battleship.utils.Formatter.*;

public class Printer {
    private static final String BATTLESHIP_NAME = "BATTLESHIP";

    private static final String NAME_REQUEST = "Enter the player name: ";
    private static final String MENU_OPTION = "Please choose an option:";
    private static final String OPPONENT_SELECTION = "Select your opponent:";
    private static final String MENU_SELECTION = "Your selection: ";
    public static final String INVALID_CHOICE = "Invalid selection! Please try again.";

    private static final String REQUEST_COORDINATES = "Select a position to shoot";
    private static final String REQUEST_LINE = "Line (A-J): ";
    private static final String REQUEST_COL = "Column (0-9): ";

    public static final String STATS = "Player Stats";
      public static void requestName(){
        System.out.print(NAME_REQUEST);
    }

    public static void gameInitialMenu() {
        System.out.println(SEPARATOR);
        System.out.println(ANSI_CYAN + center(BATTLESHIP_NAME, SEPARATOR.length()) + ANSI_RESET);
        System.out.println(SEPARATOR);
        System.out.println(ANSI_CYAN + center(MENU_OPTION, SEPARATOR.length()) + ANSI_RESET);
        System.out.println(right("[1] " + Menu.START.getDescription()));
        System.out.println(right("[2] " + Menu.TUTORIAL.getDescription()));
        System.out.println(right("[3] " + Menu.ABOUT.getDescription()));
        System.out.println(right("[4] " + Menu.END_GAME.getDescription()));
        System.out.println(SEPARATOR);
        System.out.print(MENU_SELECTION);
    }

    public static void opponentSelectionMenu(){
        System.out.println(SEPARATOR);
        System.out.println(ANSI_CYAN + center(OPPONENT_SELECTION, SEPARATOR.length()) + ANSI_RESET);
        System.out.println(right("[1] Player 2"));
        System.out.println(right("[2] Machine"));
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

    public static void printFinalBoards(Player player1, Player player2){
        System.out.println(SEPARATOR + SEPARATOR);
        System.out.print(ANSI_CYAN + center(player1.getName(), SEPARATOR.length()) + ANSI_RESET);
        System.out.println(ANSI_CYAN + center(player2.getName(), SEPARATOR.length()*2) + ANSI_RESET);
        System.out.println(SEPARATOR + SEPARATOR);
          for (int line = 0; line < 10; line++){
              for (int col=0; col < 10; col++) {
                  System.out.printf("| %s ", player1.board.getGrids()[line][col]);
              }
              System.out.print("|");
              System.out.print("        ");
              for (int colboard2=0; colboard2 < 10; colboard2++) {
                  System.out.printf("| %s ", player2.board.getGrids()[line][colboard2]);
              }
              System.out.println("|");
              System.out.println(SEPARATOR + SEPARATOR);
          }
    }
}
