import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class RpnCalculatorTest {
	private RpnCalculator calc;

	@Before
    public void setup(){
	    calc = new RpnCalculator();
    }

    @Test
    public void onePlusOne_makes2(){
        String expression = "1 1 +";
        assertEquals(2, calc.calculate(expression));
    }
//    @Test
//    public void oneMinusOne_makes0(){
//	    RpnCalculator calc = new RpnCalculator();
//	    String expression = "1 1 -";
//	    assertEquals(0, calc.calculate(expression));
//    }
//    @Test
//    public void twoTimesThree_makes6(){
//        String expression = "2 3 *";
//        assertEquals(6, calc.calculate(expression));
//    }
//    @Test
//    public void tenDividedByFive_makes2(){
//	    String expression ="10 5 /";
//	    assertEquals(2, calc.calculate(expression));
//    }
//    @Test
//    public void fourPlusTwoMinusThree_makes3() {
//        String expression = "4 2 + 3 -";
//        assertEquals(3, calc.calculate(expression));
//    }
}
