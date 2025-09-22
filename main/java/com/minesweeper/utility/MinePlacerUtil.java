package com.minesweeper.utility;

import com.minesweeper.model.Cell;

import java.util.Random;

public class MinePlacerUtil {

    /**
     * Place mines in the grid
     * @param grid
     * @param count
     */
    public static void placeMines(Cell[][] grid, int count) {
        int size = grid.length;
        Random rand = new Random();
        int placed = 0;
        while (placed < count) {
            int row = rand.nextInt(size);
            int column = rand.nextInt(size);
            if (!grid[row][column].isMine()) {
                grid[row][column].setMine(true);
                placed++;
            }
        }
    }
}
