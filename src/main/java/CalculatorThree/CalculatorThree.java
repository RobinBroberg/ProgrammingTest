package CalculatorThree;

import java.util.Scanner;

public class CalculatorThree {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        boolean run = true;
        while (run) {
            System.out.println("Please enter numbers to be calculated with any operator (+-*/)");
            String input = scan.nextLine().replaceAll("\\s", "");

            if (validateInput(input)) {
                double result = performCalculation(input);
                System.out.println(input + " = " + formatResult(result));

            } else {
                System.out.println("Invalid input. Only numbers and operators please.");
            }


            System.out.println("Would you like to perform another calculation? (Y/N)");
            String answer = scan.nextLine().toUpperCase();
            if (!answer.equals("Y")) {
                run = false;
            }
        }

    }

    private static String formatResult(double result) {
        if (result % 1 == 0) {
            return String.format("%.0f", result);
        } else {
            return String.valueOf(result);
        }
    }

    public static boolean validateInput(String input) {
        String regex = "^[0-9]+([-+*/][0-9]+)*([-+*/][0-9]+)?$";
        return input.matches(regex);
    }

    public static double performCalculation(String input) {

        String[] numbers = input.split("[-+*/]");
        String[] operators = input.replaceAll("[0-9]", "").split("");

        double result = Double.parseDouble(numbers[0]);
        int operatorIndex = 0;

        for (int i = 1; i < numbers.length; i++) {
            double number = Double.parseDouble(numbers[i]);
            char operator = operators[operatorIndex].charAt(0);

            switch (operator) {
                case '+' -> result += number;
                case '-' -> result -= number;
                case '*' -> result *= number;
                case '/' -> result /= number;
            }

            operatorIndex++;
        }

        return result;
    }
}