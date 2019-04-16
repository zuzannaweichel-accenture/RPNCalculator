import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class RpnCalculatorTest {
	//private RpnCalculator calc;
    private RPNCalc calc;

	@Before
    public void setup(){
	    //calc = new RpnCalculator();
        calc = new RPNCalc();
    }

    @Test
    public void anEmptyStringIsZero() {
        assertEquals(0, calc.calculate(""));
    }

    @Test
    public void theNumberFiveReturnsFive(){
        assertEquals(5, calc.calculate("5"));
    }

    @Test
    public void theNumberSevenReturnsSeven(){
        assertEquals(7, calc.calculate("7"));
    }

    @Test
    public void twoNumberExpressionWithAdditionOperationReturnsTheSum() {
        assertEquals(2, calc.calculate("1 1 +"));
    }

@Test
    public void expressionWithinAnotherExpressionReturnsResultOfBothExpressions() {
        assertEquals(9, calc.calculate("4 2 + 3 +"));
    }

    @Test
    public void multipleDigitExpressionsAreCalculated() {
        assertEquals(39, calc.calculate("14 12 + 13 +"));
    }
    @Test
    @Ignore
    public void foo() {
        assertEquals(7, calc.calculate("1 1 2 + + 3 +"));
    }



}
