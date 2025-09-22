package com.minesweeper.model;

public class GameBoard {

    private final int size;
    private final Cell[][] grid;
    private final boolean[][] revealed;
    private final int totalMines;
    private boolean gameOver;

    public GameBoard(int size, int totalMines, Cell[][] grid, boolean[][] revealed, boolean gameOver) {
        this.size = size;
        this.totalMines = totalMines;
        this.grid = grid;
        this.revealed = revealed;
        this.gameOver = gameOver;
    }

    public int getSize() {
        return size;
    }

    public Cell[][] getGrid() {
        return grid;
    }

    public boolean[][] getRevealed() {
        return revealed;
    }

    public int getTotalMines() {
        return totalMines;
    }

    public boolean isGameOver() {
        return gameOver;
    }

    public void setGameOver(boolean gameOver) {
        this.gameOver = gameOver;
    }
}
