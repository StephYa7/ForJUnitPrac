package practice_sixth.homework;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class IntegrationTest {
    @Test
    public void testLoadArraysVsCompareAverage() {
        List<Integer> firstTestList = TwoListAverageNumber.loadArraysFromFile("src/main/java/practice_sixth/homework/Arrays1.txt");
        List<Integer> secondTestList = TwoListAverageNumber.loadArraysFromFile("src/main/java/practice_sixth/homework/Arrays1.txt");

        int comparison = TwoListAverageNumber.compareTwoAverageNumbersFromList(firstTestList, secondTestList);

        assertEquals(0, comparison);
    }

    @Test
    public void testLoadArraysFromFileVsCompareTwoAverageNumbersFromList() {
        List<Integer> firstList = new ArrayList<>(Arrays.asList(10,9,8,11,12));
        List<Integer> secondList = new ArrayList<>(Arrays.asList(3,4,5,6));
        int firstComparison = TwoListAverageNumber.compareTwoAverageNumbersFromList(firstList, secondList);
        int secondComparison = TwoListAverageNumber.compareTwoAverageNumbersFromList(secondList, secondList);
        String first = TwoListAverageNumber.sayWhichOneIsBigger(firstComparison);
        String second = TwoListAverageNumber.sayWhichOneIsBigger(secondComparison);

        assertEquals("Average number from first list is bigger", first);
        assertEquals("The average numbers are the same", second);
    }

}