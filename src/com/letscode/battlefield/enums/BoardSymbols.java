package com.letscode.battlefield.enums;

public enum BoardSymbols {
    SHIP('S'),
    HIT('*'),
    MISS('-');

    private char Boardsymbol;

    BoardSymbols(char Boardsymbol){
        this.Boardsymbol = Boardsymbol;
    }

    public char getBoardsymbol() { return Boardsymbol; }
}
