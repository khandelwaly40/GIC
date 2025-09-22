package com.minesweeper.utility;

import com.minesweeper.model.Cell;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MinePlacerUtilTest {

    @Test
    public void testMinePlacementCount() {
        int size = 5;
        int mines = 5;
        Cell[][] grid = new Cell[size][size];
        for (int row = 0; row < size; row++) {
            for (int column = 0; column < size; column++) {
                grid[row][column] = new Cell();
            }
        }

        MinePlacerUtil.placeMines(grid, mines);

        int mineCount = 0;
        for (Cell[] row : grid) {
            for (Cell cell : row) {
                if (cell.isMine()) {
                    mineCount++;
                }
            }
        }

        assertEquals(mines, mineCount);
    }
}
