package com.minesweeper.model;

import com.minesweeper.constants.CommonConstants;

public record Coordinate(int row, int col) {
    public static Coordinate parse(String input, int size) {
        if (null == input || input.trim().length() < 2) {
            return null;
        }

        input = input.trim().toUpperCase();

        int row = input.charAt(0) - CommonConstants.UPPERCASE_CHARACTER_A;
        int col;
        try {
            col = Integer.parseInt(input.substring(1)) - 1;
        } catch (NumberFormatException e) {
            return null;
        }
        return (row >= 0 && row < size && col >= 0 && col < size) ? new Coordinate(row, col) : null;
    }
}