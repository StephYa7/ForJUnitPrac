package practice_sixth.homework;

import java.util.List;

public class App {
    public static void main(String[] args) {
        String firstFile = "src/main/java/practice_sixth/homework/Arrays1.txt";
        String secondFile = "src/main/java/practice_sixth/homework/Arrays2.txt";

        List<Integer> firstList = TwoListAverageNumber.loadArraysFromFile(firstFile);
        List<Integer> secondList = TwoListAverageNumber.loadArraysFromFile(secondFile);

        int comparison = TwoListAverageNumber.compareTwoAverageNumbersFromList(firstList, secondList);

        System.out.println(TwoListAverageNumber.sayWhichOneIsBigger(comparison));

    }
}