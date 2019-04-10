public class RpnCalculator {
    public int calculate(String expression) {
        String[] elements = expression.split(" ");
        if(elements.length > 1){
            int e1 = Integer.parseInt(elements[0]);
            int e2 = Integer.parseInt(elements[1]);
            if(elements[2].equals("+")){
                return e1 + e1;
            }
        }
        return Integer.parseInt(expression);
    }
}
