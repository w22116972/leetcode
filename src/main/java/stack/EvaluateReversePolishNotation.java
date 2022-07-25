package stack;

import java.util.*;

public class EvaluateReversePolishNotation {

    private final HashSet<String> operands = new HashSet<>(List.of("+", "-", "*", "/"));

    public int evalRPN(String[] tokens) {
        final LinkedList<String> list = new LinkedList<>();


        for (int i = 0; i < tokens.length; i++) {
            final String currentToken = tokens[i];
            list.addLast(currentToken);
            while (list.size() - 3 >= 0 && isNumeric(list.get(list.size() - 3))
                    && isNumeric(list.get(list.size() - 2)) && !isNumeric(list.getLast())) {
                final String operand = list.removeLast();
                final Integer op2 = Integer.valueOf(list.removeLast());
                final Integer op1 = Integer.valueOf(list.removeLast());
                switch (operand) {
                    case "+" -> list.addLast(String.valueOf(op1 + op2));
                    case "-" -> list.addLast(String.valueOf(op1 - op2));
                    case "*" -> list.addLast(String.valueOf(op1 * op2));
                    case "/" -> list.addLast(String.valueOf(op1 / op2));
                }
            }

        }

        return Integer.parseInt(list.pop());
    }

    private boolean isNumeric(String str) {
        return !operands.contains(str);
    }

    public static void main(String[] args) {

    }
}
