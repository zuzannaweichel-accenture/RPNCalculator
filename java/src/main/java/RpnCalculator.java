import java.util.Arrays;
import java.util.List;



public class RpnCalculator {

    public int calculate(String expression) {
        String[] elements = expression.split(" ");
        String operator = "+";
        if (expression.equals("")) {
            return 0;
        } else if (elements.length == 1) {
            return Integer.parseInt(expression);
        } else if (expression.chars().filter(i -> i == operator.charAt(0)).count() > 1) {
            int index = expression.indexOf(operator);
            String expression1 = expression.substring(0, index); //
            String expression2 = expression.substring(index+1, expression.length() - 2); //
            int calculate = calculate(expression1);
            int calculate1 = calculate(expression2);
            return add(calculate, calculate1);
        } else {
            String expression1 = elements[0];
            String expression2 = elements[1];
            return calculate(expression1) + calculate(expression2);
        }
    }

    private int add(int first, int second) {
        return first + second;
    }
}
//"1 1 2 + + 3 +"
//"14 12 + 13 +"