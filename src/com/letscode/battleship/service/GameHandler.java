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
        int rounds = 1;

        while (rounds <= 20){
            System.out.print(player1.getName() + " | ");

            getUserCoordinates(player1, player2);
            if (Objects.equals(player2.getName(), "Computer")){
                updateBoard(BattleshipWriter.getRandomCoordinates(), player1.board, player2);
                BattleshipPrinter.printBoard(player1);
            } else {
                System.out.print(player2.getName() + " | ");
                getUserCoordinates(player2, player1);
            }

            System.out.println("Round " + rounds + "/20");
            if (rounds < 20){
                System.out.println(player1);
                System.out.println(player2);
            }
            rounds++;
        }
        finalScore();
        savePlayerStatistics(player1);
        savePlayerStatistics(player2);
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
            System.out.println("It was a tie!");
        } else if (!winner.equals("Computer")){
            System.out.println("Congratulations " + winner + "! You won!");
        } else {
            System.out.println("The " + winner + " won!");
        }

        System.out.println(BattleshipFormatter.SEPARATOR.repeat(45));
        System.out.println(BattleshipPrinter.STATS);
        System.out.println(player1);
        System.out.println(player2);
        System.out.println(BattleshipFormatter.SEPARATOR.repeat(45));
        System.out.println("Name: " + player1.getName() + " | Wins: " + player1.getWins() + " | Losses: " + player1.getLosses() + " | Ties: " + player1.getTies());
        System.out.println("Name: " + player2.getName() + " | Wins: " + player2.getWins() + " | Losses: " + player2.getLosses() + " | Ties: " + player2.getTies());
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
