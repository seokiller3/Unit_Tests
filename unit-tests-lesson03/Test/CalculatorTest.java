
import org.assertj.core.api.AbstractThrowableAssert;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.awt.*;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTest {
    @Test
    void evaluatesExpression() {
        Calculator calculator = new Calculator();
        assertThat(calculator.calculation(2, 6, '+')).isEqualTo(8);
    }

    @Test
    void subtractionExpression() {
        Calculator calculator = new Calculator();
        assertThat(Calculator.calculation(2, 2, '-')).isEqualTo(0);
    }

    @Test
    void multiplicationExpression() {
        Calculator calculator = new Calculator();
        assertThat(Calculator.calculation(2, 7, '*')).isEqualTo(14);
    }

    @Test
    void divisionExpression() {
        Calculator calculator = new Calculator();
        assertThat(Calculator.calculation(100, 50, '/')).isEqualTo(2);
    }

    @Test
    void divisionByZero() {
        Calculator calculator = new Calculator();

        assertThatThrownBy(() ->
                Calculator.calculation(10, 0, '/'))
                .isInstanceOf(ArithmeticException.class)
                .hasMessage("Division by zero is not possible");
    }

    @Test
    void expectedIllegalStateExpression() {
        Calculator calculator = new Calculator();
        assertThatThrownBy(() -> Calculator.calculation(8, 4, '_'))
                .isInstanceOf(IllegalStateException.class);
    }

    // <-------JUnit-Jupiter-Params
    @ParameterizedTest
    @ValueSource(chars = {'&', '#', '='})
    void expectedIllegalStateExpressionToo(char i) {
        // Arrange
        Calculator calculator = new Calculator();
        char o = i;

        // Act
        IllegalStateException exception = assertThrows(IllegalStateException.class, () -> {
            calculator.calculation(8, 4, o);
        });

        // Assert
        String expectedMessage = "Unexpected value operator: " + o;
        String actualMessage = exception.getMessage();

        assertEquals(expectedMessage, actualMessage);

    }
    @Disabled
    @Test
    void getOperandCompletesCorrectlyWithNumbers() {
        String testedValue = "9"; // Значение для тестов
        ByteArrayInputStream in = new ByteArrayInputStream(testedValue.getBytes());
        InputStream inputStream = System.in;  // Сохраняем ссылку на ввод с клавиатуры
        System.setIn(in); // Подменяем ввод

        Calculator.getOperand(); // Вызываем метод

        System.out.println(testedValue); // Для наглядности вывода
        System.setIn(inputStream); // Подменяем обратно
    }
@Disabled
    @Test
    void getOperandCompletesCorrectlyWithNotNumbers() {
        String testedValue = "K";
        ByteArrayInputStream in = new ByteArrayInputStream(testedValue.getBytes());
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        InputStream inputStream = System.in;
        System.setIn(in);
        System.setOut(new PrintStream(out));
        assertThatThrownBy(() -> Calculator.getOperand())
                .isInstanceOf(IllegalStateException.class)
                .describedAs("Input error");
        System.setIn(inputStream);
        System.setOut(null);
    }



    @Test
    void computeAreaCircle() {
        Calculator calculator = new Calculator();
        assertEquals(314.1592653589793, calculator.computeAreaCircle(10), "Should return right circle area");
    }

    //HW3.1L: Попробуйте реализовать в калькуляторе с помощью методологии TDD (с описанием шагов) функцию расчета длины окружности
    // P=2πR (Для окружности с радиусом 10 длина окружности = 62.83185307179586)
    @Test
    void computeLengthCircle() {
        Calculator calculator = new Calculator();
        assertThat(calculator.computeLengthCircle(10)).isEqualTo(62.83185307179586);
        assertTrue(Math.abs(62 - calculator.computeLengthCircle(10)) < 1);
    }

//    @Test
//    void insufficientCoverageTest(){
//
//        System.out.println(someService.calculatingDiscount(2000.0, 10));
//        assertThat(someService.calculatingDiscount(2000.0, 50))
//                .isEqualTo(1000); // обычная скидка
//        assertThat(someService.calculatingDiscount(2000.0, 100))
//                .isEqualTo(0); // обычная скидка
//        assertThat(someService.calculatingDiscount(2000.0, 0))
//                .isEqualTo(2000); // обычная скидка
//
//
//        assertThatThrownBy(() ->
//                someService.calculatingDiscount(2000.0, 110))
//                .isInstanceOf(ArithmeticException.class)
//                .hasMessage("Скидка должна быть в диапазоне от 0 до 100%"); // процент скидки больше 100%
//
//        assertThatThrownBy(() ->
//                someService.calculatingDiscount(2000.0, -10))
//                .isInstanceOf(ArithmeticException.class)
//                .hasMessage("Скидка должна быть в диапазоне от 0 до 100%"); // процент скидки меньше 0
//
//    }


    @ParameterizedTest
    @ValueSource(ints = {0, 100})
    void calculatingDiscountTestValues() {
        assertThat(Calculator.calculatingDiscount(2000.0, 50))
                .isEqualTo(1000);
        assertThat(Calculator.calculatingDiscount(2000.0, 100))
                .isEqualTo(0);
        assertThat(Calculator.calculatingDiscount(2000.0, 0))
                .isEqualTo(2000);
    }

    @Test
    void discountIntervalTestValueOver100() {
        assertThatThrownBy(() ->
                Calculator.calculatingDiscount(2000.0, 110))
                .isInstanceOf(ArithmeticException.class)
                .hasMessage("Скидка должна быть в диапазоне от 0 до 100%"); // процент скидки больше 100%
    }

    @Test
    void discountIntervalTestValueLower100() {
        assertThatThrownBy(() ->
                Calculator.calculatingDiscount(2000.0, -10))
                .isInstanceOf(ArithmeticException.class)
                .hasMessage("Скидка должна быть в диапазоне от 0 до 100%"); // процент скидки меньше 0
    }

    @Test
    void purchaseAmountIntervalTestValueLower100() {
        assertThatThrownBy(() ->
                Calculator.calculatingDiscount(-1000, 15))
                .isInstanceOf(ArithmeticException.class)
                .hasMessage("Сумма покупки не может быть отрицательной"); // процент скидки меньше 0
    }

    @Test
    void squareRootExtractionTest() {
        assertThat(Calculator.squareRootExtraction(16)).isEqualTo(4);
    }

    @Test
    void powNumTest() {
        assertThat(Calculator.pow(2, 2)).isEqualTo(4);
    }
    @Test
    void evenOddNumberTestTrue(){
        assertTrue(Calculator.evenOddNumber(6));
    }
    @Test
    void evenOddNumberTestFalse(){
        assertFalse(Calculator.evenOddNumber(5));
    }

    @Test
    void numberIntervalTrue() {
        assertTrue(Calculator.numberInInterval(36));
    }
    @Test
    void numberIntervalHigher() {
        assertFalse(Calculator.numberInInterval(110));
    }
    @Test
    void numberIntervalLower() {
        assertFalse(Calculator.numberInInterval(20));
    }

}