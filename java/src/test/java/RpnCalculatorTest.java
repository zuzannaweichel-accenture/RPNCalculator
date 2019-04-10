import static org.junit.Assert.*;

import org.junit.Test;

public class RpnCalculatorTest {
	@Test
    public void givenOne_return1() {
	    RpnCalculator calc = new RpnCalculator();
        String expression = "1";
        assertEquals(1, calc.calculate(expression));
    }
    @Test
    public void onePlusOne_makes2(){
        RpnCalculator calc = new RpnCalculator();
        String expression = "1 1 +";
        assertEquals(2, calc.calculate(expression));
    }
}
