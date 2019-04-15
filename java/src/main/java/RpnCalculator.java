import java.util.Arrays;
import java.util.List;

public class RpnCalculator {

    public int calculate(String expression) {
        List<Character> operators = Arrays.asList('+', '-','/', '*');
       String[] expressionArr = expression.split(" ");
        while(expressionArr.length > 2){
            String[] chunks = chunkify(expression,operators);
            int calculatedBase = calculateBase(chunks[1]);

            StringBuilder dechunk = new StringBuilder();
            String reducedExpression = dechunk.append(chunks[0]+" ").append(calculatedBase+" ").append(chunks[2]+" ").toString();
            expressionArr = reducedExpression.split(" ");
        }

        return Integer.parseInt(expressionArr[0]);
    }

    private Integer calculateBase(String chunk) {
        String[] elem = chunk.split(" ");
        int e1 = Integer.parseInt(elem[0]);
        int e2 = Integer.parseInt(elem[1]);
        String op = elem[2];
        if (op.equals("+")) {
            return e1 + e2;
        }
        if (op.equals("-")) {
            return e1 - e2;
        }
        if (op.equals("*")) {
            return e1 * e2;
        }
        if (op.equals("/")) {
            return e1 / e2;
        }
        return null;
    }

    private String[] chunkify(String expression, List<Character> operators){
        int index = 0;
        for (int i = 0; i <expression.length() ; i++) {
            if (operators.contains(expression.charAt(i))){
                index = i;
            }
        }
        String prechunk = expression.substring(0, index-4);
        String chunk = expression.substring(index-4, index+1);
        String postchunk = expression.substring(index+2);

        return new String[] {prechunk, chunk, postchunk};
    }

}

