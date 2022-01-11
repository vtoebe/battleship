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
    public Player (String name, int wins, int losses, int ties){
        this.name = name;
        this.wins = wins;
        this.losses = losses;
        this.ties = ties;
    }
    public String getName() { return name; }

    public void addHit() { hits++; }
    public int getHits(){ return hits; }

    public void addMiss() { misses++; }
    public int getMisses(){ return misses; }

    public void setWins() { wins++; }
    public void setWins(int updatedWins) { wins = updatedWins; }
    public int getWins() { return wins; }

    public void setLosses() { losses++; }
    public void setLosses(int updatedLosses) { losses = updatedLosses; }
    public int getLosses() { return losses; }

    public void setTies() { ties++; }
    public void setTies(int updatedTies) { ties = updatedTies; }
    public int getTies() { return ties; }

    public float getTotalScore(){
        int scoredWins = wins * 3;
        int scoredTies = ties * 2;
        int totalGames = wins + ties + losses;
        return (float) (scoredWins + scoredTies + losses) / (totalGames);
    }

    public void resetMatchStats(){
        board = new Board();
        hits = 0;
        misses = 0;
    }
}
