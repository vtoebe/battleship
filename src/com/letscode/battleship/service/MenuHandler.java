package com.letscode.battleship.service;

import com.letscode.battleship.enums.Menu;
import com.letscode.battleship.utils.Printer;
import com.letscode.battleship.utils.Writer;

public class MenuHandler {
    public static boolean isRunning = false;

    public static void checkMenuSelection(){
        do {
            isRunning = true;
            Printer.gameInitialMenu();
            MenuHandler.checkMenu(Writer.menuSelection());
        } while(isRunning);
    }

    public static void checkOpponentSelection(){
        do {
            Printer.opponentSelectionMenu();
        } while(!MenuHandler.checkOpponent(Writer.menuSelection()));
    }

    public static boolean checkMenu(int choice){
        switch (choice) {
            case 1:
                Printer.requestName();
                Writer.setPlayer1();
                checkOpponentSelection();
                return isRunning = true;
            case 2:
                System.out.println(Menu.TUTORIAL.getDescription());
                return isRunning = true;
            case 3:
                System.out.println(Menu.ABOUT.getDescription());
                return isRunning = true;
            case 4:
                System.out.println(Menu.END_GAME.getDescription());
                return isRunning = false;
            default:
                System.out.println(Printer.INVALID_CHOICE);
                return isRunning = true;
        }
    }

    public static boolean checkOpponent(int choice){
        switch (choice) {
            case 1:
                Printer.requestName();
                Writer.setPlayer2();
                GameHandler.runGame(Writer.getPlayer1(), Writer.getPlayer2());
                return true;
            case 2:
                Writer.setPlayer2("Computer");
                GameHandler.runGame(Writer.getPlayer1(), Writer.getPlayer2());
                return true;
            default:
                System.out.println(Printer.INVALID_CHOICE);
        }
        return false;
    }
}
