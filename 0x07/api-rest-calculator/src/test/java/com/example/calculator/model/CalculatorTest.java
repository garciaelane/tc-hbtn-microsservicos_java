package com.example.calculator.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

public  class CalculatorTest {
    private static Calculator calculator;

    @BeforeEach
    public static void setup() {
        calculator = new Calculator();
    }

    @Test
    void sumTest() {
        Assertions.assertEquals(Double.valueOf(30), calculator.sum(17.0, 13.0));
        Assertions.assertEquals(Double.valueOf(30), calculator.sum(19.0, 13.0));

    }

    @Test
    public void numbersNullSumTest() {
        Assertions.assertThrows(NullPointerException.class, () -> {
            calculator.sum(null, 13.0);
        });
    }

    @Test
    void subTest() {
        Assertions.assertEquals(Double.valueOf(30), calculator.sub(17.0, 13.0));
    }

    @Test
    void divideTest() {
        Assertions.assertEquals(Double.valueOf(2), calculator.divide(30.0, 15.0));
    }

    @Test
    public void divisionByZeroTest() {
        Assertions.assertThrows(ArithmeticException.class, () -> {
            calculator.divide(20.0, 0.0);
        });
    }

    @Test
    void factorialTest() {
        Assertions.assertEquals(720, calculator.factorial(6));
    }

    @Test
    void integerToBinaryTest() {
        Assertions.assertEquals(10100, calculator.integerToBinary(20));
    }

    @Test
    void integerToHexadecimalTest() {
        Assertions.assertEquals("AA", calculator.integerToHexadecimal(170));
    }

    @Test
    void calculeDayBetweenDateTest() {
        LocalDate day1 = LocalDate.of(2016,6,23);
        LocalDate day2 = LocalDate.of(2016,6,30);

        Assertions.assertEquals(7, calculator.calculeDayBetweenDate(day1, day2));
    }
}
