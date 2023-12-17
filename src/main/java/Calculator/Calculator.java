package Calculator;

import java.util.Scanner;

public class Calculator {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int firstOperand = getOperand();
        int secondOperand = getOperand();
        char operator = getOperator();
        int result = calculation(firstOperand, secondOperand, operator);
        System.out.println("Результат: " + result);
    }

    public static char getOperator() {
        System.out.println("Введите операцию: ");
        char operation = scanner.next().charAt(0);
        return operation;
    }

    public static int getOperand() {
        System.out.println("Введите число: ");
        int operand;

        if (scanner.hasNextInt()) {
            operand = scanner.nextInt();
        } else {
            System.out.println("Вы допустили ошибку при вводе числа. Попробуйте еще раз.");
            if (scanner.hasNextInt()) {
                scanner.next();
                operand = getOperand();
            } else {
                throw new IllegalStateException("Ошибка вводимых данных");
            }
        }
        return operand;
    }

    public static int calculation(int firstOperand, int secondOperand, char operator) {
        int result;
        switch (operator) {
            case '+':
                result = firstOperand + secondOperand;
                break;
            case '-':
                result = firstOperand - secondOperand;
                break;
            case '*':
                result = firstOperand * secondOperand;
                break;
            case '/':
                if (secondOperand != 0) {
                    result = firstOperand / secondOperand;
                    break;
                } else {
                    throw new ArithmeticException("Division by zero is not possible");
                }
            default:
                throw new IllegalStateException("Unexpected value operator: " + operator);
        }
        return result;
    }

    public static double squareRootExtraction(double num) {

        if (num < 0) {
            throw new IllegalArgumentException("Cannot calculate square root of a negative number");
        }
        return Math.sqrt(num);
    }

    public static double calculatingDiscount(double purchaseAmount, int discountAmount) {
        if (purchaseAmount <= 0 || discountAmount > 100) throw new ArithmeticException();
        double result = purchaseAmount - purchaseAmount * ((double) discountAmount) / 100;
        return result;
    }

    public static double exponentiate(double number, int power) {
        if (number == 1 || power == 0) return 1;
        if (power == 1) return number;
        double result = number;
        for (int i = 1; i < power; i++) {
            result *= number;
        }
        return result;
    }
}