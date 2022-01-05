package com.letscode.battleship.service;

import com.letscode.battleship.entities.Player;

import java.util.Comparator;

public class PlayerComparator implements Comparator<Player> {

    @Override
    public int compare(Player p1, Player p2) {
        return Double.compare(p2.getTotalScore(), p1.getTotalScore());
    }
}
