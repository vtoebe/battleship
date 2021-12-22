package com.letscode.battleship.service;

import com.letscode.battleship.entities.Board;
import com.letscode.battleship.entities.Player;
import com.letscode.battleship.enums.BoardSymbols;
import com.letscode.battleship.utils.Printer;
import com.letscode.battleship.utils.Writer;

import java.util.Objects;

public class GameHandler {

    public static void runGame(Player player1, Player player2){
        int rounds = 5;

        while (rounds >= 0){
            //TODO: handle invalid characters
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

            System.out.println("Rounds left: " + rounds);
            System.out.println(player1);
            System.out.println(player2);
            rounds--;
        }

        System.out.println("End of the game!");
        Printer.printBoard(player1.board.getGrids(), player1.getName());
        Printer.printBoard(player2.board.getGrids(), player2.getName());
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

}
