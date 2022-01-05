package com.letscode.battleship.service;

import com.letscode.battleship.enums.Menu;
import com.letscode.battleship.utils.BattleshipPrinter;
import com.letscode.battleship.utils.BattleshipWriter;

public class MenuHandler {
    private static boolean isRunning;

    public static void checkMenuSelection(){
        do {
            isRunning = true;
            BattleshipPrinter.gameInitialMenu();
            MenuHandler.checkMenu(BattleshipWriter.menuSelection());
        } while(isRunning);
    }

    public static void checkOpponentSelection(){
        do {
            BattleshipPrinter.opponentSelectionMenu();
        } while(!MenuHandler.checkOpponent(BattleshipWriter.menuSelection()));
    }

    public static void checkMenu(int choice){
        switch (choice) {
            case 1:
                BattleshipPrinter.requestName();
                BattleshipWriter.setPlayer1();
                checkOpponentSelection();
                break;
            case 2:
                try{
                    GameHandler.continueGame();
                    break;
                } catch (NullPointerException e){
                    System.out.println("No running game! Start a new one!");
                    break;
                }
            case 3:
                System.out.println(Menu.RANKING.getDescription());
                FileHandler.getRanking();
                break;
            case 4:
                System.out.println(Menu.TUTORIAL.getDescription());
                FileHandler.readFile("tutorial.txt");
                break;
            case 5:
                System.out.println(Menu.ABOUT.getDescription());
                FileHandler.readFile("about.txt");
                break;
            case 6:
                System.out.println(Menu.END_GAME.getDescription());
                FileHandler.savePlayerStatistics();
                isRunning = false;
                break;
            default:
                System.out.println(BattleshipPrinter.INVALID_CHOICE);
        }
    }

    public static boolean checkOpponent(int choice){
        switch (choice) {
            case 1:
                BattleshipPrinter.requestName();
                BattleshipWriter.setPlayer2();
                GameHandler.runGame(BattleshipWriter.getPlayer1(), BattleshipWriter.getPlayer2());
                return true;
            case 2:
                BattleshipWriter.setPlayer2("Computer");
                GameHandler.runGame(BattleshipWriter.getPlayer1(), BattleshipWriter.getPlayer2());
                return true;
            default:
                System.out.println(BattleshipPrinter.INVALID_CHOICE);
        }
        return false;
    }
}
