package practice_sixth.homework;

import org.junit.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class E2eTest {
    @Test
    public void testFullApp() {

        String firstFile = "src/main/java/practice_sixth/homework/Arrays1.txt";
        String secondFile = "src/main/java/practice_sixth/homework/Arrays2.txt";

        List<Integer> firstList = TwoListAverageNumber.loadArraysFromFile(firstFile);
        List<Integer> secondList = TwoListAverageNumber.loadArraysFromFile(secondFile);

        int comparison = TwoListAverageNumber.compareTwoAverageNumbersFromList(firstList, secondList);

        String result = TwoListAverageNumber.sayWhichOneIsBigger(comparison);
        assertEquals("Average number from first list is bigger",result);
    }
}