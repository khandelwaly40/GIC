package com.minesweeper.controller;

import com.minesweeper.model.Cell;
import com.minesweeper.model.Coordinate;
import com.minesweeper.model.GameBoard;
import com.minesweeper.initializer.BoardInitializer;
import com.minesweeper.utility.BoardRenderUtil;
import com.minesweeper.utility.RevealerUtil;

import java.util.Scanner;

public class GameController {

    private final Scanner scanner = new Scanner(System.in);
    private final BoardInitializer initializer = new BoardInitializer();

    /**
     * Method to start the Game
     * Start with user input
     */
    public void start() {

        // Starting the game
        System.out.println("Welcome to Minesweeper!");

        // Taking user inputs until user win or mine found
        while (true) {
            int size = 0;
            int maxMines = 0;
            int mines = 0;

            try {
                size = promptGridSize();
                maxMines = (int) (size * size * 0.35);
                mines = promptMineCount(maxMines);

                if (mines > maxMines) {
                    System.out.println("Oh no, input mines count is greater than 35%.");
                    break;
                } else if (mines == 0) {
                    System.out.println("Mines can not be 0 to play this game.");
                    break;
                }
            } catch (NumberFormatException nfe) {
                System.out.println("Oh no, invalid input. Please try again.");
                break;
            }

            GameBoard board = initializer.initialize(size, mines);

            BoardRenderUtil.render(board);

            while (!board.isGameOver()) {
                Coordinate coordinate = promptCoordinate(size);
                if (coordinate == null) {
                    System.out.println("Invalid input. Try again.");
                    continue;
                }

                boolean hitMine = RevealerUtil.reveal(board.getGrid(), coordinate.row(), coordinate.col());
                if (hitMine) {
                    board.setGameOver(true);
                    BoardRenderUtil.render(board);
                    System.out.println("Oh no, you detonated a mine! Game over.");
                    break;
                }

                Cell selectedCell = board.getGrid()[coordinate.row()][coordinate.col()];
                int adjacentMines = selectedCell.getAdjacentMines();
                System.out.println("This square contains " + adjacentMines + " adjacent mine" + (adjacentMines != 1 ? "s." : "."));

                BoardRenderUtil.render(board);

                if (isWin(board)) {
                    System.out.println("Congratulations, you have won the game!");
                    break;
                }
            }

            System.out.println("Press Enter to play again...");
            scanner.nextLine();
        }
    }

    private int promptGridSize() {
        System.out.println("Enter the size of the grid (e.g. 4 for a 4x4 grid):");
        return Integer.parseInt(scanner.nextLine());
    }

    private int promptMineCount(int maxMines) {
        System.out.println("Enter the number of mines to place on the grid (maximum is " + maxMines + "):");
        return Integer.parseInt(scanner.nextLine());
    }

    private Coordinate promptCoordinate(int size) {
        System.out.println("Select a square to reveal (e.g. A1): ");
        String input = scanner.nextLine();
        return Coordinate.parse(input, size);
    }

    private boolean isWin(GameBoard board) {
        Cell[][] grid = board.getGrid();
        for (int r = 0; r < board.getSize(); r++) {
            for (int c = 0; c < board.getSize(); c++) {
                if (!grid[r][c].isMine() && !grid[r][c].isRevealed()) {
                    return false;
                }
            }
        }
        return true;
    }
}
