package com.letscode.battleship.utils;

import com.letscode.battleship.entities.Player;
import com.letscode.battleship.enums.BoardSymbols;
import com.letscode.battleship.enums.Menu;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Objects;

import static com.letscode.battleship.utils.BattleshipPrinter.*;

public class BattleshipFormatter {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_ORANGE = "\u001B[38;5;208m";
    public static final String SEPARATOR = "-";
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

    static void coloredBoard(Player player, int line) {
        for (int col = 0; col < 10; col++) {
            if (player.board.getGrids()[line][col] == BoardSymbols.HIT.getBoardsymbol()) {
                System.out.printf("| " + ANSI_GREEN + "%s " + ANSI_RESET, player.board.getGrids()[line][col]);
            } else if (player.board.getGrids()[line][col] == BoardSymbols.MISS.getBoardsymbol()) {
                System.out.printf("| " + ANSI_RED + "%s " + ANSI_RESET, player.board.getGrids()[line][col]);
            } else {
                System.out.printf("| %s ", player.board.getGrids()[line][col]);
            }
        }
    }

    static void boardLetters(int line){
        System.out.printf("| " + ANSI_CYAN + "%s " + ANSI_RESET, ROW_POSITION[line]);
    }

    static void boardNumbers(){
        for (char value : COLUMN_POSITION) {
            System.out.printf("| " + ANSI_CYAN + "%s " + ANSI_RESET, value);
        }
        System.out.println("|");
        System.out.println(SEPARATOR.repeat(45));
    }

    static void singlePlayerTopBoard(Player player){
        System.out.println();
        System.out.println(SEPARATOR.repeat(45));
        System.out.println(ANSI_CYAN + center(player.getName(), 45) + ANSI_RESET);
        System.out.println(SEPARATOR.repeat(45));
    }

    static void finalBoardsTop(Player player1, Player player2){
        System.out.println(SEPARATOR.repeat(41) + "        " + SEPARATOR.repeat(41));
        System.out.print(ANSI_CYAN + center(player1.getName(), 41) + ANSI_RESET);
        System.out.print("        ");
        System.out.println(ANSI_CYAN + center(player2.getName(), 82) + ANSI_RESET);
        System.out.println(SEPARATOR.repeat(41) + "        " + SEPARATOR.repeat(41));
    }

    static void initialMenuTop(){
        System.out.println(SEPARATOR.repeat(45));
        System.out.println(ANSI_CYAN + center(BATTLESHIP_NAME, 45) + ANSI_RESET);
        System.out.println(SEPARATOR.repeat(45));
        System.out.println(ANSI_CYAN + center(MENU_OPTION, 45) + ANSI_RESET);
    }

    static void rankingHeader(){
        System.out.println(SEPARATOR.repeat(45));
        System.out.println(ANSI_CYAN + center(Menu.RANKING.getDescription().toUpperCase(), 45) + ANSI_RESET);
        System.out.println(SEPARATOR.repeat(45));
    }

    static void ranking(ArrayList<Player> gameRanking){
        DecimalFormat df = new DecimalFormat();
        df.setMaximumFractionDigits(2);

        int rankPosition = 1;

        if (gameRanking.size() == 0){ System.out.println( ANSI_RED + "No players on record!" + ANSI_RESET); }
        else {
            for (Player player : gameRanking){
                if (!Objects.equals(player.getName(), "Computer")){
                    System.out.print(
                            ANSI_CYAN + "[" + rankPosition + "] " + player.getName() + ANSI_RESET +
                            " | Total Score: " + ANSI_CYAN + df.format(player.getTotalScore()) + ANSI_RESET
                    );
                    printPlayerStats(player);
                    rankPosition++;
                }
            }
        }
    }
}
