package com.letscode.battlefield.service;

import com.letscode.battlefield.entities.Player;
import com.letscode.battlefield.enums.Menu;
import com.letscode.battlefield.utils.Printer;
import com.letscode.battlefield.utils.Writer;

public class MenuHandler {
    Printer print = new Printer();
    Writer write = new Writer();

    public boolean checkMenu(int choice){
        switch (choice) {
            case 1:
                print.requestName();
                Player player1 = new Player(write.setName());
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
                System.out.println("Opção inválida.");
                return true;
        }
    }
}
