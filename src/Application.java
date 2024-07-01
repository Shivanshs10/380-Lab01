

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        if (args.length > 0) {
            // Process CLI arguments
        } else {
            // No CLI arguments, ask for user input
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter operation (e.g., add, subtract, multiply, divide, factorial):");
            String operation = scanner.next();
            // Further processing based on operation
            switch (operation.toLowerCase()) {
            case "add":
            case "subtract":
            case "multiply":
            case "divide":
          
                System.out.println("Enter the first operand:");
                double num1 = scanner.nextDouble();
                System.out.println("Enter the second operand:");
                double num2 = scanner.nextDouble();

                switch (operation) {
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
                        try {
                            System.out.println("Result: " + divide(num1, num2));
                        } catch (IllegalArgumentException e) {
                            System.out.println(e.getMessage());
                        }
                        break;
                }
                break;

            case "factorial":
                System.out.println("Enter a number:");
                double number = scanner.nextDouble();
                if (number < 0) {
                    System.out.println("Factorial is not defined for negative numbers.");
                } else {
                    System.out.println("Result: " + factorial(number));
                }
                break;

            default:
                System.out.println("Unsupported operation.");
        }
    }
}
    
    public static double add(double a, double b) {
        return a + b;
    }
    
    public static double subtract(double a, double b) {
        return a - b;
    }
    
    public static double multiply(double a, double b) {
        return a * b;
    }
    
    public static double divide(double a, double b) {
    	if (b == 0) {
        	throw new IllegalArgumentException("Cannot divide by zero");
        }
    	
        return a/b;
  
        
    }
    public static double factorial(double n) {
        if (n <= 1) {
            return 1;
        } else {
            return n * factorial(n - 1);
        }
    }

    // Other Methods' placeholders
}
