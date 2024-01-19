package practice_sixth.homework;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestTwoListAverageNumber {
    List<Integer> firstList;
    List<Integer> secondList;

    @Before
    public void setUp() {
        firstList = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
        secondList = new ArrayList<>(Arrays.asList(-5, 5, 10, -10, -25));
    }

    @Test
    public void testAverageNumberFromList() {
        double averageFirstList = firstList.stream().mapToInt(Integer::intValue).average().getAsDouble();
        double averageSecondList = secondList.stream().mapToInt(Integer::intValue).average().getAsDouble();

        assertEquals(averageFirstList, TwoListAverageNumber.getAverageNumber(firstList));
        assertEquals(averageSecondList, TwoListAverageNumber.getAverageNumber(secondList));
    }

    @Test
    public void testAverageNumberFromListThrowException() {
        List<Integer> test = null;
        assertThatThrownBy(() -> TwoListAverageNumber
                .getAverageNumber(test))
                .isInstanceOf(IllegalStateException.class)
                .describedAs("List is empty");
    }

    @Test
    public void testCompareTwoAverageNumberList() {
        assertEquals(1, TwoListAverageNumber.compareTwoAverageNumbersFromList(firstList,secondList));
        assertEquals(-1, TwoListAverageNumber.compareTwoAverageNumbersFromList(secondList,firstList));
        assertEquals(0, TwoListAverageNumber.compareTwoAverageNumbersFromList(firstList,firstList));
    }
}