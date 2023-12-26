package Prac_3.coverage;

public class SomeService {

    public static String fizzBuzz(int i) {
        if (i % 15 == 0) {
            return "FizzBuzz";
        } else if (i % 5 == 0) {
            return "Buzz";
        } else if (i % 3 == 0)
            return "Fizz";
        return String.valueOf(i);
    }

    public static boolean firstLast6(int[] nums) {
        if (nums.length == 0 || nums == null) return false;
        else if (nums[0] == 6 && nums[nums.length - 1] == 6) {
            return true;
        }
        return false;
    }

    public static double calculatingDiscount(double purchaseAmount, int discountAmount) {
        double discountedAmount = 0;
        if (purchaseAmount >= 0) {
            if (discountAmount >= 0 && discountAmount <= 100) {
                discountedAmount = purchaseAmount - (purchaseAmount * discountAmount) / 100;
            } else {
                throw new ArithmeticException("Скидка должна быть в диапазоне от 0 до 100%");
            }
        } else {
            throw new ArithmeticException("Сумма покупки не может быть отрицательной");
        }
        return discountedAmount;
    }

    public static int luckySum(int a, int b, int c) {
        int[] number = new int[]{a, b, c};
        int result = 0;
        for (int i = 0; i < number.length; i++) {
            if (number[i] != 13) {
                result += number[i];
            }
        }
        return result;
    }
}