package com.letscode.battleship.enums;

public enum Menu {
    START("Start New Game"),
    CONTINUE("Continue"),
    TUTORIAL("Tutorial"),
    ABOUT("About"),
    END_GAME("End Battleship");

    private final String description;

    Menu(String description){
        this.description = description;
    }

    public String getDescription(){
        return description;
    }
}
