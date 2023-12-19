import Calculator.Calculator;
import org.assertj.core.api.Assert;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class CalculatorTest {


    @Test
    void evaluatesExpression() {
        assertThat(Calculator.calculation(2, 6, '+')).isEqualTo(8);
    }

    @Test
    void substractionExpression() {
        assertThat(Calculator.calculation(2, 2, '-')).isEqualTo(0);
    }

    @Test
    void divisionExpression() {
        assertThat(Calculator.calculation(100, 50, '/')).isEqualTo(2);
    }

    @Test
    void multiplicationExpression() {
        assertThat(Calculator.calculation(2, 7, '*')).isEqualTo(14);
    }

    @Test
    void expectedIllegalStateExceptionOnInvalidOperationSymbol() {
        assertThatThrownBy(() -> Calculator.calculatingDiscount(101, 122))
                .isInstanceOf(ArithmeticException.class);
        assertThatThrownBy(() -> Calculator.calculatingDiscount(0, 10))
                .isInstanceOf(ArithmeticException.class);
    }    @Test
    void calculatingDiscountExpression() {

        assertThat(Calculator.calculatingDiscount(500,1))
                .isEqualTo(495);
        assertThat(Calculator.calculatingDiscount(111,45))
                .isEqualTo(61.05);

    }

    @Test
    void exponentiateExpression() {
        assertThat(Calculator.exponentiate(2, 5)).isEqualTo(32);
        assertThat(Calculator.exponentiate(0, 5)).isEqualTo(0);
        assertThat(Calculator.exponentiate(1, 5)).isEqualTo(1);
        assertThat(Calculator.exponentiate(5251, 1)).isEqualTo(5251);
        assertThat(Calculator.exponentiate(5251, 0)).isEqualTo(1);
    }

    @Test
    void getOperandCompletesCorrectlyWithNumbers() {
        String testedValue = "9";
        ByteArrayInputStream in = new ByteArrayInputStream(testedValue.getBytes());
        InputStream inputStream = System.in;
        System.setIn(in);
        Calculator.getOperand();
        System.out.println(testedValue);
        System.setIn(inputStream);
    }

    @Test
    void getOperandCompletesCorrectlyWithNotNumbers() {
        String testedValue = "в";
        ByteArrayInputStream in = new ByteArrayInputStream(testedValue.getBytes());
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        InputStream inputStream = System.in;
        System.setIn(in);
        System.setOut(new PrintStream(out));
        assertThatThrownBy(() -> Calculator.getOperand())
                .isInstanceOf(IllegalStateException.class).describedAs("Ошибка в вводимых данных");
        System.setIn(inputStream);
        System.setOut(null);
    }
}