package com.letscode.battleship.service;

import com.letscode.battleship.entities.Board;
import com.letscode.battleship.entities.Player;
import com.letscode.battleship.enums.BoardSymbols;
import com.letscode.battleship.utils.BattleshipFormatter;
import com.letscode.battleship.utils.BattleshipPrinter;
import com.letscode.battleship.utils.BattleshipWriter;

import java.util.Objects;

import static com.letscode.battleship.service.FileHandler.*;

public class GameHandler {
    private static Player player1;
    private static Player player2;
    static String winner;

    public static void runGame(Player player1, Player player2){
        GameHandler.player1 = player1;
        GameHandler.player2 = player2;
        boolean isRunning = true;
        int rounds = 1;

        while (rounds <= 20 && isRunning){
            System.out.print( BattleshipFormatter.ANSI_CYAN + player1.getName() + BattleshipFormatter.ANSI_RESET + " | ");
            getUserCoordinates(player1, player2);

            if (Objects.equals(player2.getName(), "Computer")){
                updateBoard(BattleshipWriter.getRandomCoordinates(), player1.board, player2);
                BattleshipPrinter.printBoard(player1);
            } else {
                System.out.print(BattleshipFormatter.ANSI_ORANGE + player2.getName() + BattleshipFormatter.ANSI_RESET + " | ");
                getUserCoordinates(player2, player1);
            }

            System.out.println(BattleshipFormatter.SEPARATOR.repeat(45));
            System.out.println("Round " + rounds + "/20");
            if (rounds < 20){ BattleshipPrinter.printRoundStats(player1, player2); }

            if (player1.getHits() == 10 || player2.getHits() == 10){ isRunning = false; }
            rounds++;
        }

        finalScore();
        updatePlayerStatistics(player1);
        updatePlayerStatistics(player2);
    }

    public static void continueGame(){
        player1.resetMatchStats();
        player2.resetMatchStats();
        GameHandler.runGame(player1, player2);
    }

    private static void getUserCoordinates(Player player, Player opponent){
        do {
            BattleshipPrinter.requestCoordinates();
        } while (!updateBoard(BattleshipWriter.getCoordinates(), opponent.board, player));
    }

    private static boolean updateBoard(int[] positions, Board opponentBoard, Player player) {
        int x = positions[0];
        int y = positions[1];
        if (opponentBoard.getGrids()[x][y] == BoardSymbols.SHIP.getBoardsymbol()) {
            opponentBoard.getGrids()[x][y] = BoardSymbols.HIT.getBoardsymbol();
            player.addHit();
            return true;
        } else if (opponentBoard.getGrids()[x][y] == ' ') {
            opponentBoard.getGrids()[x][y] = BoardSymbols.MISS.getBoardsymbol();
            player.addMiss();
            return true;
        }
        System.out.println(BattleshipPrinter.INVALID_COORD);
        return false;
    }

    private static void finalScore(){
        BattleshipPrinter.printFinalBoards(player1, player2);
        System.out.println(BattleshipFormatter.SEPARATOR.repeat(90));
        System.out.println(BattleshipFormatter.SEPARATOR.repeat(45));
        System.out.println("End of the Game!");

        getWinner();
        if (winner == null){
            System.out.println(BattleshipFormatter.ANSI_YELLOW + "It was a tie!" + BattleshipFormatter.ANSI_RESET);
        } else if (!winner.equals("Computer")){
            System.out.println(BattleshipFormatter.ANSI_GREEN + "Congratulations " + winner + "! You won!" + BattleshipFormatter.ANSI_RESET);
        } else {
            System.out.println(BattleshipFormatter.ANSI_RED + "The " + winner + " won!" + BattleshipFormatter.ANSI_RESET);
        }

        System.out.println(BattleshipFormatter.SEPARATOR.repeat(45));
        System.out.println(BattleshipPrinter.STATS);
        BattleshipPrinter.printRoundStats(player1, player2);
        System.out.print(BattleshipFormatter.ANSI_CYAN + player1.getName() + BattleshipFormatter.ANSI_RESET);
        BattleshipPrinter.printPlayerStats(player1);
        System.out.print(BattleshipFormatter.ANSI_ORANGE + player2.getName() + BattleshipFormatter.ANSI_RESET);
        BattleshipPrinter.printPlayerStats(player2);
    }

    public static void getWinner(){
        if (player1.getHits() == player2.getHits()){
            player1.setTies();
            player2.setTies();
            winner = null;
        } else if (player1.getHits() > player2.getHits()){
            player1.setWins();
            player2.setLosses();
            winner = player1.getName();
        } else{
            player2.setWins();
            player1.setLosses();
            winner =  player2.getName();
        }
    }
}
