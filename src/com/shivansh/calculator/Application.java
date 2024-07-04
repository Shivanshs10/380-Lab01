package com.shivansh.calculator;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nEnter operation (add, subtract, multiply, divide, pow, sqrt, log, log10, sin, cos, tan, factorial, permutation) or 'exit' to quit:");
            String operation = scanner.next();

            if (operation.equalsIgnoreCase("exit")) {
                System.out.println("Exiting calculator...");
                break;
            }

            // For operations requiring two inputs
            if (operation.equalsIgnoreCase("add") || operation.equalsIgnoreCase("subtract") || operation.equalsIgnoreCase("multiply") || operation.equalsIgnoreCase("divide") || operation.equalsIgnoreCase("pow") || operation.equalsIgnoreCase("permutation")) {
                System.out.print("Enter first number: ");
                double num1 = scanner.nextDouble();
                System.out.print("Enter second number: ");
                double num2 = scanner.nextDouble();

                switch (operation.toLowerCase()) {
                    case "add":
                        System.out.println("Result: " + add(num1, num2));
                        break;
                    case "subtract":
                        System.out.println("Result: " + subtract(num1, num2));
                        break;
                    case "multiply":
                        System.out.println("Result: " + multiply(num1, num2));
                        break;
                    case "divide":
                        System.out.println("Result: " + divide(num1, num2));
                        break;
                    case "pow":
                        System.out.println("Result: " + power(num1, num2));
                        break;
                    case "permutation":
                        int totalElements = (int) num1;
                        int selectedItems = (int) num2;
                        if (validatePermutationInputs(totalElements, selectedItems)) {
                            System.out.println("Result (recursive): " + permutationRecursive(totalElements, selectedItems));
                            System.out.println("Result (non-recursive): " + permutationNonRecursive(totalElements, selectedItems));
                        }
                        break;
                    default:
                        System.out.println("Invalid operation.");
                        break;
                }
            } else {
                // For operations requiring one input
                System.out.print("Enter number: ");
                double num = scanner.nextDouble();

                switch (operation.toLowerCase()) {
                    case "sqrt":
                        System.out.println("Result: " + sqrt(num));
                        break;
                    case "log":
                        System.out.println("Result: " + log(num));
                        break;
                    case "log10":
                        System.out.println("Result: " + log10(num));
                        break;
                    case "sin":
                        System.out.println("Result: " + sin(num));
                        break;
                    case "cos":
                        System.out.println("Result: " + cos(num));
                        break;
                    case "tan":
                        System.out.println("Result: " + tan(num));
                        break;
                    case "factorial":
                        // Factorial is a special case requiring an integer
                        System.out.println("Result: " + factorial((int) num));
                        break;
                    default:
                        System.out.println("Invalid operation.");
                        break;
                }
            }
        }
        scanner.close();
    }

    // Addition method
    public static double add(double a, double b) {
        return a + b;
    }

    // Subtraction method
    public static double subtract(double a, double b) {
        return a - b;
    }

    // Multiplication method
    public static double multiply(double a, double b) {
        return a * b;
    }

    // Division method
    public static double divide(double a, double b) {
        if (b == 0) {
            throw new IllegalArgumentException("Cannot divide by zero");
        }
        return a / b;
    }

    // Exponentiation
    public static double power(double base, double exponent) {
        return Math.pow(base, exponent);
    }

    // Square root
    public static double sqrt(double number) {
        return Math.sqrt(number);
    }

    // Natural logarithm
    public static double log(double number) {
        return Math.log(number);
    }

    // Base-10 logarithm
    public static double log10(double number) {
        return Math.log10(number);
    }

    // Sine function
    public static double sin(double angleRadians) {
        return Math.sin(Math.toRadians(angleRadians));
    }

    // Cosine function
    public static double cos(double angleRadians) {
        return Math.cos(Math.toRadians(angleRadians));
    }

    // Tangent function
    public static double tan(double angleRadians) {
        return Math.tan(Math.toRadians(angleRadians));
    }

    // Factorial calculation with progress display
    public static long factorial(int num) {
        if (num < 0) {
            System.out.println("Factorial of negative number is undefined.");
            return 0;
        }
        return factorialHelper(num, num);
    }

    private static long factorialHelper(int originalNum, int num) {
        if (num <= 1) {
            System.out.print("\rCalculating Factorial: 100% ");
            return 1;
        }

        // Calculate progress as fraction of completed iterations
        double progress = (double) (originalNum - num + 1) / originalNum;
        int progressPercent = (int) (progress * 100);
        System.out.print("\rCalculating factorial: " + progressPercent + "%");

        return num * factorialHelper(originalNum, num - 1);
    }

    // Validate inputs for permutation calculation
    private static boolean validatePermutationInputs(int totalElements, int selectedItems) {
        if (totalElements < 0) {
            System.out.println("Total number of elements cannot be negative.");
            return false;
        }
        if (selectedItems < 0 || selectedItems > 100) {
            System.out.println("Number of selected items must be between 0 and 100.");
            return false;
        }
        if (selectedItems > totalElements) {
            System.out.println("Number of selected items cannot exceed total number of elements.");
            return false;
        }
        if (totalElements > 100) {
            System.out.println("Total number of elements cannot exceed 100.");
            return false;
        }
        return true;
    }

    // Recursive method to calculate permutations
    public static long permutationRecursive(int n, int r) {
        if (r == 0) {
            return 1;
        }
        return n * permutationRecursive(n - 1, r - 1);
    }

    // Non-recursive method to calculate permutations
    public static long permutationNonRecursive(int n, int r) {
        long result = 1;
        for (int i = 0; i < r; i++) {
            result *= (n - i);
        }
        return result;
    }
}
