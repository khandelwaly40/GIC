package com.minesweeper.model;

import com.minesweeper.model.Coordinate;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CoordinateTest {

    @Test
    public void testValidCoordinateMiddleOfGrid() {
        Coordinate coord = Coordinate.parse("B3", 4);
        assertNotNull(coord);
        assertEquals(1, coord.row());
        assertEquals(2, coord.col());
    }

    @Test
    public void testValidCoordinateLowercaseInput() {
        Coordinate coordinate = Coordinate.parse("c2", 5);
        assertNotNull(coordinate);
        assertEquals(2, coordinate.row());
        assertEquals(1, coordinate.col());
    }

    @Test
    public void testValidCoordinateWithSpaces() {
        Coordinate coordinate = Coordinate.parse("  D4  ", 5);
        assertNotNull(coordinate);
        assertEquals(3, coordinate.row());
        assertEquals(3, coordinate.col());
    }

    @Test
    public void testInvalidCoordinateTooShort() {
        assertNull( Coordinate.parse("D", 2));
    }

    @Test
    public void testInvalidCoordinateNullInput() {
        assertNull(Coordinate.parse(null, 4));
    }

    @Test
    public void testInvalidCoordinateNonNumericColumn() {
        assertNull(Coordinate.parse("A&", 4));
    }

    @Test
    public void testOutOfBoundsCoordinateRow() {
        assertNull(Coordinate.parse("Z1", 4));
    }

    @Test
    public void testOutOfBoundsCoordinateColumn() {
        assertNull(Coordinate.parse("A9", 4));
    }
}
