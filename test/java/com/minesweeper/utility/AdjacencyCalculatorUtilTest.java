package com.minesweeper.utility;

import com.minesweeper.model.Cell;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AdjacencyCalculatorUtilTest {

    @Test
    public void testAdjacencyCount() {
        Cell[][] grid = new Cell[3][3];
        for (int r = 0; r < 3; r++)
            for (int c = 0; c < 3; c++)
                grid[r][c] = new Cell();

        grid[0][0].setMine(true); // Top-left corner

        AdjacencyCalculatorUtil.calculate(grid);

        assertEquals(1, grid[0][1].getAdjacentMines());
        assertEquals(1, grid[1][0].getAdjacentMines());
        assertEquals(1, grid[1][1].getAdjacentMines());
        assertEquals(0, grid[2][2].getAdjacentMines());
    }
}
