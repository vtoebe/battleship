package com.letscode.battleship;

import com.letscode.battleship.service.GameHandler;
import com.letscode.battleship.service.MenuHandler;
import com.letscode.battleship.utils.Printer;
import com.letscode.battleship.utils.Writer;

public class Battleship {
    public static void main(String[] args) {
        Writer write = new  Writer();

        do{
            Printer.gameInitialMenu();
            MenuHandler.checkMenu(write.menuSelection());

            Printer.opponentSelectionMenu();
            MenuHandler.checkOpponent(write.menuSelection());

            GameHandler.runGame(Writer.getPlayer1(), Writer.getPlayer2());

            Printer.gameInitialMenu();
        } while (MenuHandler.checkMenu(write.menuSelection()));
    }
}
