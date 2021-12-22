package com.letscode.battleship.entities;

import com.letscode.battleship.enums.BoardSymbols;

public class Player {
    private final String name;
    private int attempts;
    private int hits;
    private int misses;

    public Board board = new Board();
    public Player (String name){
        this.name = name;
    }
    public String getName() { return name; }

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
        return name + ": " + hits + " hits, " + misses + " misses";
    }
}
