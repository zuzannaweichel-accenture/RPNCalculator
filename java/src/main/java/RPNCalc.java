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
        String opperator = findFirsOperator(expression);
        System.out.println("operator: "+opperator);
        if (expArr.length == 1){
            return expArr[0];
        }else{
            String base = findBase(expression,opperator);
            int first = Integer.parseInt(base.split(" ")[0]);
            int second = Integer.parseInt(base.split(" ")[1]);
            int result = operationMap.get(opperator).applyAsInt(first,second);
            expression = replaceBaseWithResult(expression,base,result);
        }

        return calculate(expression);
    }
    private String findBase(String expression, String operator){
        int indexOfOperator = expression.indexOf(operator);
        StringBuilder base = new StringBuilder();
        String preOperator = expression.substring(0,indexOfOperator+1);
        String[] preOpArr = preOperator.split(" ");
        int last = preOpArr.length-1;
        for (int i = 0; i < 3 ; i++) {
            base.append(preOpArr[last]).append(" ");
            last--;
        }
        System.out.println("base: "+ base);
        String cleandUpBase = base.reverse().toString().trim();
        System.out.println("trimmed base: "+cleandUpBase);
        return cleandUpBase;
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
        System.out.println("index of operator: "+indexOfOperation);
        return String.valueOf(expression.charAt(indexOfOperation));
    }

    private String replaceBaseWithResult(String expression, String base, int result){
        String newExpresion = expression.replace(base,String.valueOf(result));
        System.out.println(" new Expression:" + newExpresion);
       return newExpresion;
    }
}
