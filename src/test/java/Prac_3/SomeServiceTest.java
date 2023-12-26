package Prac_3;

import Prac_3.coverage.SomeService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

class SomeServiceTest {


    @Test
    void multipleThreeNotFiveReturnsFizz() {
        assertThat(SomeService.fizzBuzz(3)).isEqualTo("Fizz");
    }

    @Test
    void multipleFiveNotThreeReturnsBuzz() {
        assertThat(SomeService.fizzBuzz(5)).isEqualTo("Buzz");
    }

    @Test
    void multipleFiveAndThreeReturnsFizzBuzz() {
        assertThat(SomeService.fizzBuzz(15)).isEqualTo("FizzBuzz");
    }

    @Test
    void NotMultipleFiveAndThreeReturnsNumber() {
        assertThat(SomeService.fizzBuzz(17)).isEqualTo("17");
    }


    @Test
    void firstSixReturnFalse() {
        assertThat(SomeService.firstLast6(new int[]{6, 0, 7})).isFalse();
    }

    @Test
    void lastSixReturnFalse() {
        assertThat(SomeService.firstLast6(new int[]{1, 6, 0, 6})).isFalse();
    }

    @Test
    void firstAndLastSixReturnTrue() {
        assertThat(SomeService.firstLast6(new int[]{6, 0, 7, 6})).isTrue();
    }

    @Test
    void firstAndLastNotSixReturnFalse() {
        assertThat(SomeService.firstLast6(new int[]{2, 0, 7, 2})).isFalse();
    }

    @Test
    void arrayLengthIsZeroReturnFalse() {
        assertThat(SomeService.firstLast6(new int[0])).isFalse();
    }

    @Test
    void calculatingDiscountReturnDiscount() {
        assertThat(SomeService.calculatingDiscount(100, 5)).isEqualTo(95);
    }

    @Test
    void calculatingDiscountReturnExceptionByDiscountLessZero() {
        assertThatThrownBy(() -> SomeService.calculatingDiscount(55, -1))
                .isInstanceOf(ArithmeticException.class);
    }

    @Test
    void calculatingDiscountReturnExceptionByPurchaseLessZero() {
        assertThatThrownBy(() -> SomeService.calculatingDiscount(-1, 22))
                .isInstanceOf(ArithmeticException.class);
    }

    /**
     * @param i      discount
     * @param result result
     * @apiNote Обычная скидка
     */
    @ParameterizedTest
    @CsvSource({
            "50, 1000",
            "100, 0",
            "0, 2000"
    })
    void correctDiscountCalculatingTest(int i, int result) {
        assertThat(SomeService.calculatingDiscount(2000, i)).isEqualTo(result);
    }

    /**
     * @param i
     * @apiNote Некорректная скидка
     */
    @ParameterizedTest
    @ValueSource(ints = {101, -1})
    void incorrectDiscountValue(int i) {
        assertThatThrownBy(() -> SomeService.calculatingDiscount(2000, i))
                .isInstanceOf(ArithmeticException.class)
                .hasMessage("Скидка должна быть в диапазоне от 0 до 100%");
    }


    @Test
    void incorrectPurchaseAmount() {
        assertThatThrownBy(() -> SomeService.calculatingDiscount(-1, 10))
                .isInstanceOf(ArithmeticException.class)
                .hasMessage("Сумма покупки не может быть отрицательной");
    }

    @Test
    void luckySumReturnSumThreeNumber() {
        assertThat(SomeService.luckySum(1, 2, 3))
                .isEqualTo(6);
    }

    @Test
    void luckySumReturnSumTwoNumberAnd13() {
        assertThat(SomeService.luckySum(1, 2, 13))
                .isEqualTo(3);
    }

    @Test
    void luckySumReturnSumOneNumberAndDouble13() {
        assertThat(SomeService.luckySum(1, 13, 13))
                .isEqualTo(1);
    }

    @Test
    void luckySumReturnZeroByThree13() {
        assertThat(SomeService.luckySum(13, 13, 13))
                .isEqualTo(0);
    }


}