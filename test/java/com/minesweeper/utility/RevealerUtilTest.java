package com.minesweeper.utility;

import com.minesweeper.model.Cell;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class RevealerUtilTest {

    @Test
    public void testRevealMineReturnsTrue() {
        Cell[][] grid = createEmptyGrid(2);
        grid[0][0].setMine(true);

        boolean result = RevealerUtil.reveal(grid, 0, 0);

        assertTrue(result);
        assertTrue(grid[0][0].isRevealed());
    }

    @Test
    public void testRevealAlreadyRevealedReturnsFalse() {
        Cell[][] grid = createEmptyGrid(2);
        grid[1][1].setRevealed(true);

        boolean result = RevealerUtil.reveal(grid, 1, 1);

        assertFalse(result);
        assertTrue(grid[1][1].isRevealed()); // Still revealed
    }

    @Test
    public void testRevealSafeCellReturnsFalse() {
        Cell[][] grid = createEmptyGrid(2);
        grid[0][0].setAdjacentMines(2);

        boolean result = RevealerUtil.reveal(grid, 0, 0);

        assertFalse(result);
        assertTrue(grid[0][0].isRevealed());
    }

    @Test
    public void testRevealTriggersRecursiveReveal() {
        Cell[][] grid = createEmptyGrid(3);
        grid[1][1].setAdjacentMines(0);
        grid[0][0].setAdjacentMines(0);
        grid[0][1].setAdjacentMines(1);
        grid[0][2].setAdjacentMines(0);

        boolean result = RevealerUtil.reveal(grid, 1, 1);

        assertFalse(result);
        assertTrue(grid[0][0].isRevealed());
        assertTrue(grid[0][1].isRevealed());
        assertTrue(grid[0][2].isRevealed());
        assertTrue(grid[1][1].isRevealed());
    }

    private Cell[][] createEmptyGrid(int size) {
        Cell[][] grid = new Cell[size][size];
        for (int row = 0; row < size; row++) {
            for (int column = 0; column < size; column++) {
                grid[row][column] = new Cell();
            }
        }
        return grid;
    }
}
