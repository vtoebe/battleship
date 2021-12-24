package com.letscode.battleship.utils;

import com.letscode.battleship.entities.Player;
import com.letscode.battleship.enums.Menu;

import static com.letscode.battleship.utils.BattleshipFormatter.*;

public class BattleshipPrinter {
    static final String BATTLESHIP_NAME = "BATTLESHIP";

    private static final String NAME_REQUEST = "Enter the player name: ";
    static final String MENU_OPTION = "Please choose an option:";
    private static final String OPPONENT_SELECTION = "Select your opponent:";
    private static final String MENU_SELECTION = "Your selection: ";
    public static final String INVALID_CHOICE = "Invalid selection! Please try again.";
    public static final String INVALID_COORD = "Coordinates already entered, please choose another one.";

    private static final String REQUEST_COORDINATES = "Select a position to shoot";
    private static final String REQUEST_LINE = "Line (A-J): ";
    private static final String REQUEST_COL = "Column (0-9): ";
    public static final String STATS = "Player Stats";

    public static void requestName(){
        System.out.print(NAME_REQUEST);
    }

    public static void gameInitialMenu() {
        initialMenuTop();
        System.out.println(right("[1] " + Menu.START.getDescription()));
        System.out.println(right("[2] " + Menu.TUTORIAL.getDescription()));
        System.out.println(right("[3] " + Menu.ABOUT.getDescription()));
        System.out.println(right("[4] " + Menu.END_GAME.getDescription()));
        System.out.println(SEPARATOR.repeat(45));
        System.out.print(MENU_SELECTION);
    }

    public static void opponentSelectionMenu(){
        System.out.println(SEPARATOR.repeat(45));
        System.out.println(ANSI_CYAN + center(OPPONENT_SELECTION, 45) + ANSI_RESET);
        System.out.println(right("[1] Player 2"));
        System.out.println(right("[2] Machine"));
        System.out.println(SEPARATOR.repeat(45));
        System.out.print(MENU_SELECTION);
    }

    public static void requestCoordinates(){
        System.out.println(REQUEST_COORDINATES);

        do {
            System.out.print(REQUEST_LINE);
        } while (!BattleshipWriter.getLine());

        do {
            System.out.print(REQUEST_COL);
        } while (!BattleshipWriter.getCol());
    }

    public static void printBoard(Player player) {
        singlePlayerTopBoard(player);
        boardNumbers();

        for (int line = 0; line < player.board.getGrids().length; line++) {
            boardLetters(line);
            coloredBoard(player, line);
            System.out.println("|");
            System.out.println(SEPARATOR.repeat(45));
        }
    }

    public static void printFinalBoards(Player player1, Player player2){
        finalBoardsTop(player1, player2);
        for (int line = 0; line < 10; line++){
            coloredBoard(player1, line);
            System.out.print("|");
            System.out.print("        ");
            coloredBoard(player2, line);
            System.out.println("|");
            System.out.println(SEPARATOR.repeat(41) + "        " + SEPARATOR.repeat(41));
          }
    }
}
