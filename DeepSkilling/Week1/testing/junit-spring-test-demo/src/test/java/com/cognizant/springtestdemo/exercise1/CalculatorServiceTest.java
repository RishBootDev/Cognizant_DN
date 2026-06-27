package com.cognizant.springtestdemo.exercise1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CalculatorServiceTest {
    private final CalculatorService calculatorService = new CalculatorService();

    @Test
    void addReturnsSumOfTwoNumbers() {
        assertEquals(15, calculatorService.add(10, 5));
    }
}
