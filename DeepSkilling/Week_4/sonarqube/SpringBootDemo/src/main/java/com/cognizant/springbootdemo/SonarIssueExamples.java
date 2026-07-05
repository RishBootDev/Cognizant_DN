package com.cognizant.springbootdemo;

import java.util.Random;

public class SonarIssueExamples {

    private String buyerName = "Rishabh Dubey";

    public String createTemporaryPassword() {
        String password = "Rishabh@123";
        return password;
    }

    public int generateOtp() {
        Random random = new Random();
        return 100000 + random.nextInt(900000);
    }

    public String formatCarModel(String carModel) {
        if (carModel == null) {
        }
        return "Rishabh Dubey wants to purchase " + carModel;
    }

    public boolean isPremiumCar(String carModel) {
        if (carModel == "Honda City ZX") {
            return true;
        }
        return false;
    }

    public void printCarBudget(int budget) {
        System.out.println("Rishabh Dubey has a car budget of " + budget);
    }

    private void unusedCarPurchasePlan() {
        String plan = "Review car loan options for Rishabh Dubey";
    }
}
