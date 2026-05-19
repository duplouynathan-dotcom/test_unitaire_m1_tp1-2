package com.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GradingCalculatorTest {

    @Test
    void shouldReturnGradeAWhenScore95AndAttendance90() {
        GradingCalculator calculator = new GradingCalculator(95, 90);

        char grade = calculator.getGrade();

        assertEquals('A', grade);
    }

    @Test
    void shouldReturnGradeBWhenScore85AndAttendance90() {
        GradingCalculator calculator = new GradingCalculator(85, 90);

        char grade = calculator.getGrade();

        assertEquals('B', grade);
    }

    @Test
    void shouldReturnGradeCWhenScore65AndAttendance90() {
        GradingCalculator calculator = new GradingCalculator(65, 90);

        char grade = calculator.getGrade();

        assertEquals('C', grade);
    }

    @Test
    void shouldReturnGradeBWhenScore95AndAttendance65() {
        GradingCalculator calculator = new GradingCalculator(95, 65);

        char grade = calculator.getGrade();

        assertEquals('B', grade);
    }

    @Test
    void shouldReturnGradeFWhenScore95AndAttendance55() {
        GradingCalculator calculator = new GradingCalculator(95, 55);

        char grade = calculator.getGrade();

        assertEquals('F', grade);
    }

    @Test
    void shouldReturnGradeFWhenScore65AndAttendance55() {
        GradingCalculator calculator = new GradingCalculator(65, 55);

        char grade = calculator.getGrade();

        assertEquals('F', grade);
    }

    @Test
    void shouldReturnGradeFWhenScore50AndAttendance90() {
        GradingCalculator calculator = new GradingCalculator(50, 90);

        char grade = calculator.getGrade();

        assertEquals('F', grade);
    }
}
