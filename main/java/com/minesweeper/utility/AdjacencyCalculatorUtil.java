package com.minesweeper.utility;

import com.minesweeper.model.Cell;

public class AdjacencyCalculatorUtil {

    /**
     * Method to calculate adjacent sides
     * @param grid
     */
    public static void calculate(Cell[][] grid) {
        int size = grid.length;
        for (int row = 0; row < size; row++) {
            for (int column = 0; column < size; column++) {
                if (!grid[row][column].isMine()) {
                    grid[row][column].setAdjacentMines(countAdjacent(grid, row, column));
                }
            }
        }
    }

    /**
     * Method to count adjacent sides
     * @param grid
     * @param row
     * @param column
     * @return
     */
    private static int countAdjacent(Cell[][] grid, int row, int column) {
        int count = 0;
        int size = grid.length;
        for (int adjacentRow = -1; adjacentRow <= 1; adjacentRow++) {
            for (int adjacentColumn = -1; adjacentColumn <= 1; adjacentColumn++) {
                int nextRow = row + adjacentRow;
                int nextColumn = column + adjacentColumn;
                if (nextRow >= 0 && nextRow < size && nextColumn >= 0 && nextColumn < size && grid[nextRow][nextColumn].isMine()) {
                    count++;
                }
            }
        }
        return count;
    }
}
