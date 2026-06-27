package com.cognizant.springtestdemo.exercise9;

import org.springframework.stereotype.Service;

@Service
public class ParameterizedCalculatorService {
    public int add(int a, int b) {
        return a + b;
    }
}
