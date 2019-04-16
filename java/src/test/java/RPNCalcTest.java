import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RPNCalcTest {
    private RPNCalc calc;

    @Before
    public void setup(){
        calc = new RPNCalc();
    }

    @Test
    public void anEmptyStringIsZero() {
        assertEquals("", calc.calculate(""));
    }

    @Test
    public void theNumberFiveReturnsFive(){
        assertEquals("5", calc.calculate("5"));
    }

    @Test
    public void theNumberSevenReturnsSeven(){
        assertEquals("7", calc.calculate("7"));
    }

    @Test
    public void twoNumberExpressionWithAdditionOperationReturnsTheSum() {
        assertEquals("2", calc.calculate("1 1 +"));
    }
    @Test
    public void twoNumberExpressionWithSubstractionOperationReturnsTheDifference() {
        assertEquals("2", calc.calculate("4 2 -"));
    }

    @Test
    public void twoNumberExpressionWithDivisionOperationReturnsTheDifference() {
        assertEquals("2", calc.calculate("4 2 /"));
    }

    @Test
    public void twoNumberExpressionWithMultiplicationOperationReturnsTheResult() {
        assertEquals("8", calc.calculate("4 2 *"));
    }
    @Test
    public void expressionWithinAnotherExpressionReturnsResultOfBothExpressions() {
        assertEquals("9", calc.calculate("4 2 + 3 +"));
    }

    @Test
    public void expressionWithAdditionAndSubstarctionReturnsResultOfBothExpressions() {
        assertEquals("3", calc.calculate("4 2 + 3 -"));
    }

//    @Test
//    public void multipleDigitExpressionsAreCalculated() {
//        assertEquals("39", calc.calculate("14 12 + 13 +"));
//    }
    @Test
    public void foo() {
        assertEquals("7", calc.calculate("1 1 2 + + 3 +"));
    }

    @Test
    public void additionSubstractionMultiplication_inOneExpression(){
        assertEquals("10", calc.calculate("2 3 4 + 2 - *"));
    }

}
