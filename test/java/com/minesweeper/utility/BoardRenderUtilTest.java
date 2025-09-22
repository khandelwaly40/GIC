package com.minesweeper.utility;

import com.minesweeper.model.Cell;
import com.minesweeper.model.GameBoard;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class BoardRenderUtilTest {

    @Test
    public void testRenderRevealedMine() {
        Cell[][] grid = createGrid(2);
        grid[0][0].setMine(true);
        grid[0][0].setRevealed(true);
        GameBoard board = new GameBoard(2, 1, grid, new boolean[2][2], false);

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        BoardRenderUtil.render(board);

        String output = out.toString();
        assertTrue(output.contains("*"));
    }

    @Test
    public void testRenderRevealedSafeCell() {
        Cell[][] grid = createGrid(2);
        grid[1][1].setAdjacentMines(2);
        grid[1][1].setRevealed(true);
        GameBoard board = new GameBoard(2, 0, grid, new boolean[2][2], false);

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        BoardRenderUtil.render(board);

        String output = out.toString();
        assertTrue(output.contains("2"));
    }

    private Cell[][] createGrid(int size) {
        Cell[][] grid = new Cell[size][size];
        for (int r = 0; r < size; r++)
            for (int c = 0; c < size; c++)
                grid[r][c] = new Cell();
        return grid;
    }
}
