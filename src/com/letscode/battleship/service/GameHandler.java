package com.letscode.battleship.service;

import com.letscode.battleship.entities.Board;
import com.letscode.battleship.entities.Player;
import com.letscode.battleship.enums.BoardSymbols;
import com.letscode.battleship.utils.Printer;
import com.letscode.battleship.utils.Writer;

import java.util.Objects;

public class GameHandler {
    private static Player player1;
    private static Player player2;

    public void runGame(Player player1, Player player2){
        GameHandler.player1 = player1;
        GameHandler.player2 = player2;
        int rounds = 0;

        while (rounds <= 5){
            System.out.print(player1.getName() + " | ");
            Printer.requestCoordinates();
            updateBoard(Writer.getCoordinates(), player2.board, player1);

            if (Objects.equals(Writer.getPlayer2().getName(), "Computer")){
                updateBoard(Writer.getRandomCoordinates(), player1.board, player2);
                Printer.printBoard(player1.board.getGrids(), player1.getName());
            } else {
                System.out.print(player2.getName() + " | ");
                Printer.requestCoordinates();
                updateBoard(Writer.getCoordinates(), player1.board, player2);
            }

            System.out.println("Round " + rounds + "/5");
            if (rounds < 5){
                System.out.println(player1);
                System.out.println(player2);
            }
            rounds++;
        }
        finalScore();
    }

    public static void updateBoard(int[] positions, Board opponentBoard, Player player) {
        int x = positions[0];
        int y = positions[1];
        if (opponentBoard.getGrids()[x][y] == BoardSymbols.SHIP.getBoardsymbol()) {
            opponentBoard.getGrids()[x][y] = BoardSymbols.HIT.getBoardsymbol();
            player.addHit();
        } else if (opponentBoard.getGrids()[x][y] == ' ') {
            opponentBoard.getGrids()[x][y] = BoardSymbols.MISS.getBoardsymbol();
            player.addMiss();
        }
    }

    public static void finalScore(){
        System.out.println("End of the Game!");

        if (getWinner() != null  && !Objects.equals(getWinner().getName(), "Computer")){
            System.out.println("Congratulations " + getWinner().getName() + "! You won!");
        } else if (getWinner() != null && Objects.equals(getWinner().getName(), "Computer")){
            System.out.println("The " + getWinner().getName() + " won!");
        }else {
            System.out.println("It was a tie!");
        }
        System.out.println(Printer.STATS);
        System.out.println(player1);
        System.out.println(player2);
        Printer.printFinalBoards(player1, player2);

    }

    public static Player getWinner(){
        if (player2.getHits() == player1.getHits()){
            player1.setTies(1);
            player2.setTies(1);
            return null;
        } else if (player1.getHits() > player2.getHits()){
            player1.setWins(1);
            player2.setLosses(1);
            return player1;
        } else{
            player2.setWins(1);
            player1.setLosses(1);
            return player2;
        }
    }

}
