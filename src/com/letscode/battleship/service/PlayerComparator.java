package com.letscode.battleship.service;

import com.letscode.battleship.entities.Player;

import java.util.Comparator;

public class PlayerComparator implements Comparator<Player> {

    @Override
    public int compare(Player p1, Player p2) {
        if (p2.getWins() == p1.getWins()){
            if (p1.getTies() != p2.getTies()){
                return p2.getTies() - p1.getTies();
            }
            return p1.getLosses() - p2.getLosses();
        }
        return p2.getWins() - p1.getWins();
    }
}
