package com.codecool.sudokusolver.model;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class CellTest {

    @Test
    public void testPossibleValuesWhenCreatingCellWithValue() {
        List<Integer> expected = new ArrayList<>();
        List<Integer> result = new Cell(1, 1, 3).getPossibleValues();
        assertEquals(expected, result);
    }

    @Test
    public void testPossibleValuesWhenCreatingCellWithoutValue() {
        List<Integer> expected = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9));
        List<Integer> result = new Cell(1, 1, 0).getPossibleValues();
        assertEquals(expected, result);
    }

    @Test
    public void testSettingValue() {
        Cell testCell = new Cell(1, 1, 0);
        int expected = 4;
        List<Integer> expectedPossibleValues = new ArrayList<>();

        testCell.setValue(4);
        List<Integer> resultPossibleValues = testCell.getPossibleValues();
        int result = testCell.getValue();

        assertEquals(result, expected);
        assertEquals(expectedPossibleValues, resultPossibleValues);
    }

    @Test
    public void testRemovingContainedPossibleValue() {
        Cell testCell = new Cell(1,1,0);
        List<Integer> expectedPossibleValues = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 6, 7, 8, 9));

        testCell.removeValue(5);
        List<Integer> result = testCell.getPossibleValues();

        assertEquals(expectedPossibleValues, result);
    }

    @Test
    public void testRemovingNotContainedPossibleValue() {
        Cell testCell = new Cell(1,1,0);
        List<Integer> expectedPossibleValues = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9));

        testCell.removeValue(0);
        List<Integer> result = testCell.getPossibleValues();

        assertEquals(expectedPossibleValues, result);
    }

    @Test
    public void testAssigningNinthSquare() {
        int expected = 8;
        int result1 = Cell.setSquare(6, 6);
        int result2 = Cell.setSquare(6, 7);
        int result3 = Cell.setSquare(6, 8);
        int result4 = Cell.setSquare(7, 6);
        int result5 = Cell.setSquare(7, 7);
        int result6 = Cell.setSquare(7, 8);
        int result7 = Cell.setSquare(8, 6);
        int result8 = Cell.setSquare(8, 7);
        int result9 = Cell.setSquare(8, 8);
        assertEquals(expected, result1);
        assertEquals(expected, result2);
        assertEquals(expected, result3);
        assertEquals(expected, result4);
        assertEquals(expected, result5);
        assertEquals(expected, result6);
        assertEquals(expected, result7);
        assertEquals(expected, result8);
        assertEquals(expected, result9);
    }

    @Test
    public void testAssigningEighthSquare() {
        int expected = 7;
        int result1 = Cell.setSquare(6, 3);
        int result2 = Cell.setSquare(6, 4);
        int result3 = Cell.setSquare(6, 5);
        int result4 = Cell.setSquare(7, 3);
        int result5 = Cell.setSquare(7, 4);
        int result6 = Cell.setSquare(7, 5);
        int result7 = Cell.setSquare(8, 3);
        int result8 = Cell.setSquare(8, 4);
        int result9 = Cell.setSquare(8, 5);
        assertEquals(expected, result1);
        assertEquals(expected, result2);
        assertEquals(expected, result3);
        assertEquals(expected, result4);
        assertEquals(expected, result5);
        assertEquals(expected, result6);
        assertEquals(expected, result7);
        assertEquals(expected, result8);
        assertEquals(expected, result9);
    }

    @Test
    public void testAssigningSeventhSquare() {
        int expected = 6;
        int result1 = Cell.setSquare(6, 0);
        int result2 = Cell.setSquare(6, 1);
        int result3 = Cell.setSquare(6, 2);
        int result4 = Cell.setSquare(7, 0);
        int result5 = Cell.setSquare(7, 1);
        int result6 = Cell.setSquare(7, 2);
        int result7 = Cell.setSquare(8, 0);
        int result8 = Cell.setSquare(8, 1);
        int result9 = Cell.setSquare(8, 2);
        assertEquals(expected, result1);
        assertEquals(expected, result2);
        assertEquals(expected, result3);
        assertEquals(expected, result4);
        assertEquals(expected, result5);
        assertEquals(expected, result6);
        assertEquals(expected, result7);
        assertEquals(expected, result8);
        assertEquals(expected, result9);
    }

    @Test
    public void testAssigningSixthSquare() {
        int expected = 5;
        int result1 = Cell.setSquare(3, 6);
        int result2 = Cell.setSquare(3, 6);
        int result3 = Cell.setSquare(3, 6);
        int result4 = Cell.setSquare(4, 7);
        int result5 = Cell.setSquare(4, 7);
        int result6 = Cell.setSquare(4, 7);
        int result7 = Cell.setSquare(5, 8);
        int result8 = Cell.setSquare(5, 8);
        int result9 = Cell.setSquare(5, 8);
        assertEquals(expected, result1);
        assertEquals(expected, result2);
        assertEquals(expected, result3);
        assertEquals(expected, result4);
        assertEquals(expected, result5);
        assertEquals(expected, result6);
        assertEquals(expected, result7);
        assertEquals(expected, result8);
        assertEquals(expected, result9);
    }
    @Test
    public void testAssigningFifthSquare() {
        int expected = 4;
        int result1 = Cell.setSquare(3, 3);
        int result2 = Cell.setSquare(3, 3);
        int result3 = Cell.setSquare(3, 3);
        int result4 = Cell.setSquare(4, 4);
        int result5 = Cell.setSquare(4, 4);
        int result6 = Cell.setSquare(4, 4);
        int result7 = Cell.setSquare(5, 5);
        int result8 = Cell.setSquare(5, 5);
        int result9 = Cell.setSquare(5, 5);
        assertEquals(expected, result1);
        assertEquals(expected, result2);
        assertEquals(expected, result3);
        assertEquals(expected, result4);
        assertEquals(expected, result5);
        assertEquals(expected, result6);
        assertEquals(expected, result7);
        assertEquals(expected, result8);
        assertEquals(expected, result9);
    }

    @Test
    public void testAssigningFourthSquare() {
        int expected = 3;
        int result1 = Cell.setSquare(3, 0);
        int result2 = Cell.setSquare(3, 0);
        int result3 = Cell.setSquare(3, 0);
        int result4 = Cell.setSquare(4, 1);
        int result5 = Cell.setSquare(4, 1);
        int result6 = Cell.setSquare(4, 1);
        int result7 = Cell.setSquare(5, 2);
        int result8 = Cell.setSquare(5, 2);
        int result9 = Cell.setSquare(5, 2);
        assertEquals(expected, result1);
        assertEquals(expected, result2);
        assertEquals(expected, result3);
        assertEquals(expected, result4);
        assertEquals(expected, result5);
        assertEquals(expected, result6);
        assertEquals(expected, result7);
        assertEquals(expected, result8);
        assertEquals(expected, result9);
    }

    @Test
    public void testAssigningThirdSquare() {
        int expected = 2;
        int result1 = Cell.setSquare(0, 6);
        int result2 = Cell.setSquare(0, 6);
        int result3 = Cell.setSquare(0, 6);
        int result4 = Cell.setSquare(1, 7);
        int result5 = Cell.setSquare(1, 7);
        int result6 = Cell.setSquare(1, 7);
        int result7 = Cell.setSquare(2, 8);
        int result8 = Cell.setSquare(2, 8);
        int result9 = Cell.setSquare(2, 8);
        assertEquals(expected, result1);
        assertEquals(expected, result2);
        assertEquals(expected, result3);
        assertEquals(expected, result4);
        assertEquals(expected, result5);
        assertEquals(expected, result6);
        assertEquals(expected, result7);
        assertEquals(expected, result8);
        assertEquals(expected, result9);
    }

    @Test
    public void testAssigningSecondSquare() {
        int expected = 1;
        int result1 = Cell.setSquare(0, 3);
        int result2 = Cell.setSquare(0, 3);
        int result3 = Cell.setSquare(0, 3);
        int result4 = Cell.setSquare(1, 4);
        int result5 = Cell.setSquare(1, 4);
        int result6 = Cell.setSquare(1, 4);
        int result7 = Cell.setSquare(2, 5);
        int result8 = Cell.setSquare(2, 5);
        int result9 = Cell.setSquare(2, 5);
        assertEquals(expected, result1);
        assertEquals(expected, result2);
        assertEquals(expected, result3);
        assertEquals(expected, result4);
        assertEquals(expected, result5);
        assertEquals(expected, result6);
        assertEquals(expected, result7);
        assertEquals(expected, result8);
        assertEquals(expected, result9);
    }

    @Test
    public void testAssigningFirstSquare() {
        int expected = 0;
        int result1 = Cell.setSquare(0, 0);
        int result2 = Cell.setSquare(0, 0);
        int result3 = Cell.setSquare(0, 0);
        int result4 = Cell.setSquare(1, 1);
        int result5 = Cell.setSquare(1, 1);
        int result6 = Cell.setSquare(1, 1);
        int result7 = Cell.setSquare(2, 2);
        int result8 = Cell.setSquare(2, 2);
        int result9 = Cell.setSquare(2, 2);
        assertEquals(expected, result1);
        assertEquals(expected, result2);
        assertEquals(expected, result3);
        assertEquals(expected, result4);
        assertEquals(expected, result5);
        assertEquals(expected, result6);
        assertEquals(expected, result7);
        assertEquals(expected, result8);
        assertEquals(expected, result9);
    }
}