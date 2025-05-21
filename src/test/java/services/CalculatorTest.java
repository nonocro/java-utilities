package services;

import exceptions.CalculatorException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    private static final double DELTA = 0.0001; // Precision for floating-point comparisons

    @Nested
    public class AddTest {
        @Test
        void addBasic() {
            Assertions.assertEquals(5.0, Calculator.add(2.0, 3.0), DELTA);
        }

        @Test
        void addNegative(){
            Assertions.assertEquals(-1.0, Calculator.add(2.0, -3.0), DELTA);
        }

        @Test
        void addZero(){
            Assertions.assertEquals(2.0, Calculator.add(2.0, 0.0), DELTA);
        }

        @Test
        void addWithDecimal(){
            Assertions.assertEquals(0.3, Calculator.add(0.1, 0.2), DELTA);
        }
    }

    @Nested
    public class SubTest {
        @Test
        void subBasic(){
            Assertions.assertEquals(1.0, Calculator.sub(3.0, 2.0), DELTA);
        }

        @Test
        void subNegative(){
            Assertions.assertEquals(5.0, Calculator.sub(3.0, -2.0), DELTA);
        }

        @Test
        void subNegativeResult(){
            Assertions.assertEquals(-1.0, Calculator.sub(2.0, 3.0), DELTA);
        }

        @Test
        void subZero(){
            Assertions.assertEquals(2.0, Calculator.sub(2.0, 0.0), DELTA);
        }

        @Test
        void subWithDecimal(){
            Assertions.assertEquals(0.0001, Calculator.sub(1.0001, 1.0), DELTA);
        }
    }

    @Nested
    public class TimesTest {
        @Test
        void timesBasic(){
            Assertions.assertEquals(6.0, Calculator.times(2.0, 3.0), DELTA);
        }

        @Test
        void timesZero(){
            Assertions.assertEquals(0.0, Calculator.times(5.0, 0.0), DELTA);
        }

        @Test
        void timesNegative(){
            Assertions.assertEquals(-6.0, Calculator.times(2.0, -3.0), DELTA);
        }

        @Test
        void timesWithDecimal(){
            Assertions.assertEquals(3.3, Calculator.times(2.5, 1.32), DELTA);
        }
    }

    @Nested
    public class DivideTest {
        @Test
        void divideBasic() throws CalculatorException {
            Assertions.assertEquals(2.0, Calculator.divide(6.0, 3.0), DELTA);
        }

        @Test
        void divideBy1() throws CalculatorException {
            Assertions.assertEquals(5.0, Calculator.divide(5.0, 1.0), DELTA);
        }

        @Test
        void divideNegativeResult() throws CalculatorException {
            Assertions.assertEquals(-2.0, Calculator.divide(6.0, -3.0), DELTA);
        }

        @Test
        void divideDecimalResult() throws CalculatorException {
            Assertions.assertEquals(1.5, Calculator.divide(3.0, 2.0), DELTA);
        }

        @Test
        void divideOfZero() throws CalculatorException {
            Assertions.assertEquals(0.0, Calculator.divide(0.0, 5.0), DELTA);
        }

        @Test
        void divideByZero() throws CalculatorException {
            Exception exception = assertThrows(CalculatorException.class, () -> {
                Calculator.divide(5.0, 0.0);
            });

            assertTrue(exception.getMessage().contains("Divisor can't be equal to zero."));
        }
    }
}
