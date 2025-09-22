package com.minesweeper.utility;

import com.minesweeper.constants.CommonConstants;
import com.minesweeper.model.Cell;
import com.minesweeper.model.GameBoard;

public class BoardRenderUtil {

    /**
     * Method to render the grid after every input
     * @param board
     */
    public static void render(GameBoard board) {
        int size = board.getSize();
        Cell[][] grid = board.getGrid();

        System.out.print(CommonConstants.SPACE + CommonConstants.SPACE);
        for (int i = 1; i <= size; i++) {
            System.out.print(i + CommonConstants.SPACE);
        }

        System.out.println();

        for (int row = 0; row < size; row++) {
            System.out.print((char) (CommonConstants.UPPERCASE_CHARACTER_A + row) + CommonConstants.SPACE);
            for (int column = 0; column < size; column++) {
                Cell cell = grid[row][column];
                if (!cell.isRevealed()) {
                    System.out.print(CommonConstants.UNDERSCORE_SPACE);
                } else if (cell.isMine()) {
                    System.out.print(CommonConstants.ASTERISK_SPACE);
                } else {
                    System.out.print(cell.getAdjacentMines() + CommonConstants.SPACE);
                }
            }
            System.out.println();
        }
    }
}
