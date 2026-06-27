package com.cognizant.springtestdemo.exercise9;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ParameterizedCalculatorServiceTest {
    private final ParameterizedCalculatorService calculatorService = new ParameterizedCalculatorService();

    @ParameterizedTest
    @CsvSource({
            "1, 2, 3",
            "5, 7, 12",
            "10, -3, 7",
            "0, 0, 0"
    })
    void addReturnsExpectedResultForMultipleInputs(int a, int b, int expected) {
        assertEquals(expected, calculatorService.add(a, b));
    }
}
