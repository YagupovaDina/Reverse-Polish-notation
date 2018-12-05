package task3;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExpressionEvaluation {
    private Deque<String> numbers;
    private String number;
    private Pattern patternNumber;
    private String operations;
    private Pattern patternExpression;
    private Matcher matcherForExpression;
    private Matcher matcherForExtractNumber;


    /**
     * В конструкторе инициализируются строки для регулярных выражений
     * структура, в которой происхоид  вычисления выражения, представлена в виде stack (Deque представим в виде стека)
     */
    public ExpressionEvaluation(){
        numbers = new ArrayDeque<>();
        number = "\\d+";
        patternNumber = Pattern.compile((number));
        operations = "[\\+ | \\* | \\- | \\/]";
        patternExpression = Pattern.compile((number +"|"+operations));
    }

    private int calcExpr(int a, int b, String operation){
        if (operation.equals("+"))
            return a+b;
        if (operation.equals("-"))
            return a-b;
        if (operation.equals("*"))
            return a*b;
        if (operation.equals("/"))
            return a/b;
        return 0;
    }

    /**
     *
     * @param expression - числа из арифметического выражения expression записываются в stack,
     *                   далее над числами производится арифметическая операция.
     */
    public String parseAndCalc(String expression){
        matcherForExpression = patternExpression.matcher(expression);
        while (matcherForExpression.find()){
            if (!matcherForExpression.group().equals(" ")){
                    matcherForExtractNumber = patternNumber.matcher(matcherForExpression.group());
                    if (matcherForExtractNumber.matches())
                        numbers.push(matcherForExpression.group());
                    else{
                        int a = Integer.parseInt(numbers.pop());
                        int b = Integer.parseInt(numbers.pop());
                        Integer result = calcExpr(b,a, matcherForExpression.group());
                        numbers.push(result.toString());
                    }
            }
        }
       return numbers.getLast();
    }
}
