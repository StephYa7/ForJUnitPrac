package practice_sixth.homework;

import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

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
                .isInstanceOf(IllegalStateException.class);
    }

    @Test
    public void testCompareTwoAverageNumberList() {
        assertEquals(1, TwoListAverageNumber.compareTwoAverageNumbersFromList(firstList, secondList));
        assertEquals(-1, TwoListAverageNumber.compareTwoAverageNumbersFromList(secondList, firstList));
        assertEquals(0, TwoListAverageNumber.compareTwoAverageNumbersFromList(firstList, firstList));
    }

    @Test
    public void testFromSayWhichOneIsBiggerReturnString() {
        assertEquals("Average number from first list is bigger"
                , TwoListAverageNumber.sayWhichOneIsBigger(1));
        assertEquals("Average number from second list is bigger"
                , TwoListAverageNumber.sayWhichOneIsBigger(-1));
        assertEquals("The average numbers are the same"
                , TwoListAverageNumber.sayWhichOneIsBigger(0));
    }

    @Test
    public void testFromSayWhichOneIsBiggerReturnException() {
        assertThatThrownBy(() -> TwoListAverageNumber
                .sayWhichOneIsBigger(2))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void testLoadArraysFromFile() {
        List<Integer> testList = TwoListAverageNumber.
                loadArraysFromFile("src/main/java/practice_sixth/homework/Arrays1.txt");

        assertEquals(22, testList.get(0));
    }

    @Test
    public void testConstructorThrowException() throws ClassNotFoundException {
        Class<?> testClass = Class.forName("practice_sixth.homework.TwoListAverageNumber");
        Constructor[] constructors = testClass.getDeclaredConstructors();
        Constructor testConstructor = constructors[0];
        testConstructor.setAccessible(true);

        assertThrows(InvocationTargetException.class, () -> testConstructor.newInstance());
    }
}