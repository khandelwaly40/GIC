package com.minesweeper.initializer;

import com.minesweeper.model.Cell;
import com.minesweeper.model.GameBoard;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BoardInitializerTest {

    @Test
    public void testGridSizeAndStructure() {
        int size = 4;
        int mines = 5;
        GameBoard board = new BoardInitializer().initialize(size, mines);

        assertEquals(size, board.getSize());
        assertEquals(mines, board.getTotalMines());

        Cell[][] grid = board.getGrid();
        assertEquals(size, grid.length);
        assertEquals(size, grid[0].length);
    }

    @Test
    public void testMineCountAccuracy() {
        int size = 5;
        int mines = 6;
        GameBoard board = new BoardInitializer().initialize(size, mines);

        int actualMines = 0;
        for (Cell[] row : board.getGrid()) {
            for (Cell cell : row) {
                if (cell.isMine()) {
                    actualMines++;
                }
            }
        }

        assertEquals(mines, actualMines);
    }

    @Test
    public void testRevealedMatrixInitializedFalse() {
        int size = 3;
        GameBoard board = new BoardInitializer().initialize(size, 2);

        boolean[][] revealed = board.getRevealed();
        for (int row = 0; row < size; row++) {
            for (int column = 0; column < size; column++) {
                assertFalse(revealed[row][column]);
            }
        }
    }

    @Test
    public void testAdjacencyCountsAreNonNegative() {
        GameBoard board = new BoardInitializer().initialize(4, 4);

        for (Cell[] row : board.getGrid()) {
            for (Cell cell : row) {
                assertTrue(cell.getAdjacentMines() >= 0);
            }
        }
    }
}
