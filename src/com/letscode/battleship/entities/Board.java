package com.letscode.battleship.entities;

import java.util.Arrays;

public class Board {
    private final char[][] grids = new char[10][10];

    public Board() {
        this.init();
        this.placeShips();
    }

    public void init() {
        for (char[] grid : grids) {
            Arrays.fill(grid, ' ');
        }
    }

    public void placeShips() {
        for (int i = 0; i < grids.length; i++) {
            int x = (int) (Math.random() * 10);
            int y = (int) (Math.random() * 10);

            if(grids[x][y] != 'S'){
                grids[x][y] = 'S';
            } else { i--; }
        }
    }

    public char[][] getGrids() {
        return grids;
    }
}
