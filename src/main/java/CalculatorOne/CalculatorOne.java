package CalculatorOne;

import java.util.Scanner;

public class CalculatorOne {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);


        boolean run = true;
        while (run) {
            System.out.println("Please enter two numbers with an operator in between (e.g., 5 + 3)");
            String input = scan.nextLine().replaceAll("\\s", "");

            if (validateInput(input)) {
                double result = performCalculation(input);
                System.out.println(input + " = " + formatResult(result));

            } else {
                System.out.println("Invalid input. Please provide an expression with two numbers and one operator.");
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
        String regex = "^[0-9]+([-+*/])[0-9]+$";
        return input.matches(regex);
    }

    public static double performCalculation(String input) {
        char operator = ' ';

        if (input.indexOf('+') != -1) {
            operator = '+';
        } else if (input.indexOf('-') != -1) {
            operator = '-';
        } else if (input.indexOf('*') != -1) {
            operator = '*';
        } else if (input.indexOf('/') != -1) {
            operator = '/';
        }
        String[] numbers = input.split("[-+*/]");

        double firstNumber = Integer.parseInt(numbers[0]);
        double secondNumber = Integer.parseInt(numbers[1]);

        return switch (operator) {
            case '+' -> firstNumber + secondNumber;
            case '-' -> firstNumber - secondNumber;
            case '*' -> firstNumber * secondNumber;
            case '/' -> firstNumber / secondNumber;
            default -> 0;
        };
    }
}

