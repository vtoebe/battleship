package com.letscode.battleship.service;

import com.letscode.battleship.enums.Menu;
import com.letscode.battleship.utils.Printer;
import com.letscode.battleship.utils.Writer;

public class MenuHandler {

    public static boolean checkMenu(int choice){
        switch (choice) {
            case 1:
                Printer.requestName();
                Writer.setPlayer1();
                return true;
            case 2:
                System.out.println(Menu.TUTORIAL.getDescription());
                return true;
            case 3:
                System.out.println(Menu.ABOUT.getDescription());
                return true;
            case 4:
                System.out.println(Menu.END_GAME.getDescription());
                return false;
            default:
                System.out.println(Printer.INVALID_CHOICE);
                return true;
        }
    }

    public static void checkOpponent(int choice){
        switch (choice) {
            case 1:
                Printer.requestName();
                Writer.setPlayer2();
                break;
            case 2:
                Writer.setPlayer2("Computer");
                break;
            default:
                System.out.println(Printer.INVALID_CHOICE);
        }
    }
}
