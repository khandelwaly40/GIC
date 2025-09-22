package com.minesweeper.initializer;

import com.minesweeper.model.Cell;
import com.minesweeper.model.GameBoard;
import com.minesweeper.utility.AdjacencyCalculatorUtil;
import com.minesweeper.utility.MinePlacerUtil;

public class BoardInitializer {

    /**
     * Initialize the game board
     * @param size
     * @param totalMines
     * @return
     */
    public GameBoard initialize(int size, int totalMines) {
        Cell[][] grid = new Cell[size][size];
        boolean[][] revealed = new boolean[size][size];

        for (int row = 0; row < size; row++)
            for (int column = 0; column < size; column++)
                grid[row][column] = new Cell();

        MinePlacerUtil.placeMines(grid, totalMines);
        AdjacencyCalculatorUtil.calculate(grid);

        return new GameBoard(size, totalMines, grid, revealed, false);
    }
}
