package com.letscode.battlefield;

import com.letscode.battlefield.entities.Player;
import com.letscode.battlefield.utils.Printer;
import com.letscode.battlefield.utils.Writer;

public class Game {
    public static void main(String[] args) {
        Printer print = new Printer();
        Writer write = new  Writer();

        print.requestName();
        Player player1 = new Player(write.setName());

        // ask if wants to play against other player or against the machine

        write.printBoard(player1.board.getGrids(), player1.getName());
    }
}
