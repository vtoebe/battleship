package com.letscode.battlefield.entities;

import com.letscode.battlefield.enums.BoardSymbols;

public class Player {
    private String name;
    private int attempts;
    private int hits;
    private int misses;

    public Board board = new Board();

    public Player (String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void attack(int[] positions) {
        int x = positions[0];
        int y = positions[1];
        if (board.getGrids()[x][y] == BoardSymbols.SHIP.getBoardsymbol()) {
            board.getGrids()[x][y] = BoardSymbols.HIT.getBoardsymbol();
            addHit();
        } else if (board.getGrids()[x][y] == ' ') {
            board.getGrids()[x][y] = BoardSymbols.MISS.getBoardsymbol();
            addMiss();
        }
        addAttempt();
    }

    public int[] randomPosition() {
        int x = (int) (Math.random() * 10);
        int y = (int) (Math.random() * 10);
        return new int[] {x, y};
    }

    public void addAttempt() {
        if (this.attempts < 20) {
            attempts++;
        }
    }

    public void addHit() {
        hits++;
    }

    public void addMiss() {
        misses++;
    }

    @Override
    public String toString() {
        return name + ": " + hits + " certeiros, " + misses + " perdidos";
    }
}
