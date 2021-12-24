package com.letscode.battleship.entities;

public class Player {
    private final String name;
    private int hits;
    private int misses;
    private int wins;
    private int losses;
    private int ties;

    public Board board = new Board();
    public Player (String name){
        this.name = name;
    }
    public String getName() { return name; }

    public void addHit() {
        hits++;
    }
    public int getHits(){ return hits; }

    public void addMiss() {
        misses++;
    }
//    public int getMisses(){ return misses; }

    public void setWins() { wins++; }
//    public int getWins() { return wins; }

    public void setLosses() { losses++; }
//    public int getLosses() { return losses; }

    public void setTies() { ties++; }
//    public int getTies() { return ties; }

    @Override
    public String toString() {
        return name + ": " + hits + " hits, " + misses + " misses";
    }
}
