import Calculator.Calculator;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class CalculatorTest {

    @Test
    void evaluatesExpression() {
        Calculator calculator = new Calculator();
        assertThat(Calculator.calculation(2, 6, '+')).isEqualTo(8);
    }

    @Test
    void substractionExpression() {
        Calculator calculator = new Calculator();
        assertThat(Calculator.calculation(2, 2, '-')).isEqualTo(0);
    }

    @Test
    void divisionExpression() {
        Calculator calculator = new Calculator();
        assertThat(Calculator.calculation(100, 50, '/')).isEqualTo(2);
    }

    @Test
    void multiplicationExpression() {
        Calculator calculator = new Calculator();
        assertThat(Calculator.calculation(2, 7, '*')).isEqualTo(14);
    }

    @Test
    void expectedIllegalStateExceptionOnInvalidOperationSymbol() {
        Calculator calculator = new Calculator();
        assertThatThrownBy(() -> Calculator.calculatingDiscount(101, 122))
                .isInstanceOf(ArithmeticException.class);
        assertThatThrownBy(() -> Calculator.calculatingDiscount(0, 10))
                .isInstanceOf(ArithmeticException.class);
    }

    @Test
    void exponentiateExpression() {
        Calculator calculator = new Calculator();
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
}