package practice_sixth.homework;

import java.util.List;

public class TwoListAverageNumber {
    private TwoListAverageNumber() {
        throw new IllegalStateException("Utility class");
    }

    public static double getAverageNumber(List<Integer> inputList) {
        if (inputList == null || inputList.isEmpty()) {
            throw new IllegalStateException("List is empty");
        }
        double sum = 0;
        for (Integer i : inputList) {
            sum += i;
        }
        return sum / inputList.size();
    }

    public static int compareTwoAverageNumbersFromList(List<Integer> firstList, List<Integer> secondList) {
        double averageNumberFromFirstList = getAverageNumber(firstList);
        double averageNumberFromSecondList = getAverageNumber(secondList);

        double difference = averageNumberFromFirstList - averageNumberFromSecondList;

        if (difference > 0) return 1;
        else if (difference < 0) return -1;
        return 0;
    }

    public static void sayWhichOneIsBigger(int comparison) {
        switch (comparison) {
            case 1:
                System.out.println("Average number from first list is bigger");
                break;
            case -1:
                System.out.println("Average number from first list is bigger");
                break;
            case 0:
                System.out.println("The average numbers are the same");
                break;
            default:
                throw new IllegalArgumentException();
        }
    }
}