package com.minesweeper.utility;

import com.minesweeper.model.Cell;

public class RevealerUtil {

    /**
     * Method to reveal the cells
     * @param grid
     * @param row
     * @param column
     * @return
     */
    public static boolean reveal(Cell[][] grid, int row, int column) {
        int size = grid.length;
        if (grid[row][column].isRevealed()) {
            return false;
        }

        grid[row][column].setRevealed(true);
        if (grid[row][column].isMine()) {
            return true;
        }

        if (grid[row][column].getAdjacentMines() == 0) {
            revealAdjacentSides(grid, row, column, size);
        }
        return false;
    }

    /**
     * Method to reveal adjacent sides in the grid
     * @param grid
     * @param row
     * @param column
     * @param size
     */
    private static void revealAdjacentSides(Cell[][] grid, int row, int column, int size) {
        for (int adjacentRow = -1; adjacentRow <= 1; adjacentRow++) {
            for (int adjacentColumn = -1; adjacentColumn <= 1; adjacentColumn++) {
                int nextRow = row + adjacentRow;
                int nextColumn = column + adjacentColumn;
                if (nextRow >= 0 && nextRow < size && nextColumn >= 0 && nextColumn < size) {
                    reveal(grid, nextRow, nextColumn);
                }
            }
        }
    }
}
