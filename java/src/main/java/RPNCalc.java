import java.util.HashMap;
import java.util.function.IntBinaryOperator;

public class RPNCalc {

    public String calculate(String expression){
        HashMap<String, IntBinaryOperator> operationMap = new HashMap<String, IntBinaryOperator>();
        operationMap.put("+", (a,b)-> a+b);
        operationMap.put("-", (a,b)-> a-b);
        operationMap.put("/", (a,b)-> a/b);
        operationMap.put("*", (a,b)-> a*b);
        String[] expArr = expression.split(" ");
        String operator = findFirsOperator(expression);
        if (expArr.length == 1){
            return expArr[0];
        }else {
            String base = findBase(expression,operator);
            int first = Integer.parseInt(base.split(" ")[0]);
            int second = Integer.parseInt(base.split(" ")[1]);
            int result = operationMap.get(operator).applyAsInt(first,second);
            expression = replaceBaseWithResult(expression,base,result);
        }
        return calculate(expression);
    }

    private String findBase(String expression, String operator){
        String [] elements = expression.split(" ");
        int index = -1;
        for (int i = 0; i <elements.length ; i++) {
            if (elements[i].equals(operator)){
                index = i;
                break;
            }
        }
        StringBuilder base = new StringBuilder();
        base.append(elements[index - 2]).append(" ")
                .append(elements[index - 1]).append(" ")
                .append(elements[index]);
        return base.toString();
    }

    private String findFirsOperator(String expression){
        String regex = "\\+|-|/|\\*|";
        int indexOfOperation = -1;
        for (int i = 0; i <expression.length() ; i++) {
            if (String.valueOf(expression.charAt(i)).matches(regex)){
                indexOfOperation = i;
                break;
            }
        }
        if (indexOfOperation < 0){
            return "";
        }
        return String.valueOf(expression.charAt(indexOfOperation));
    }

    private String replaceBaseWithResult(String expression, String base, int result){
        return expression.replace(base,String.valueOf(result));
    }
}
