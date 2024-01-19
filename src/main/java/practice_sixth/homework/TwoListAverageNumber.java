package practice_sixth.homework;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
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

    public static String sayWhichOneIsBigger(int comparison) {
        switch (comparison) {
            case 1:
                return "Average number from first list is bigger";
            case -1:
                return "Average number from second list is bigger";
            case 0:
                return "The average numbers are the same";
            default:
                throw new IllegalArgumentException();
        }
    }

    public static List<Integer> loadArraysFromFile(String fileName) {
        List<Integer> result = new ArrayList<>();
        try (BufferedReader buffer = new BufferedReader(new InputStreamReader(new FileInputStream(fileName)));
        ) {
            String input = buffer.readLine();
            String[] arrayStringNumbers = input.trim().split(" ");
            Arrays.stream(arrayStringNumbers).forEach(o -> result.add(Integer.valueOf(o)));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

}