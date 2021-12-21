package com.letscode.battlefield.enums;

public enum Menu {
    START("Start Game"),
    TUTORIAL("Tutorial"),
    ABOUT("About"),
    END_GAME("End Game");

    private String description;

    Menu(String description){
        this.description = description;
    }

    public String getDescription(){
        return description;
    }
}
