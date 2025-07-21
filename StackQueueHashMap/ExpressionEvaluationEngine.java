import java.util.Stack;

interface ExpressionEvaluator {
    int evaluate(String expression);
}

class PostfixEvaluator implements ExpressionEvaluator {
    @Override
    public int evaluate(String expression) {
        Stack<Integer> stack = new Stack<>();
        String[] tokens = expression.split(" ");
        for (String token : tokens) {
            if (token.matches("-?\\d+")) {
                stack.push(Integer.parseInt(token));
            } else {
                int b = stack.pop();
                int a = stack.pop();
                switch (token) {
                    case "+": stack.push(a + b); break;
                    case "-": stack.push(a - b); break;
                    case "*": stack.push(a * b); break;
                    case "/": stack.push(a / b); break;
                }
            }
        }
        return stack.pop();
    }
}

class InfixToPostfixConverter {
    public static String convert(String infix) {
        StringBuilder output = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < infix.length(); i++) {
            char c = infix.charAt(i);
            if (Character.isDigit(c)) {
                output.append(c).append(' ');
            } else if (c == '(') {
                stack.push(c);
            } else if (c == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    output.append(stack.pop()).append(' ');
                }
                stack.pop();
            } else if (isOperator(c)) {
                while (!stack.isEmpty() && precedence(stack.peek()) >= precedence(c)) {
                    output.append(stack.pop()).append(' ');
                }
                stack.push(c);
            }
        }
        while (!stack.isEmpty()) {
            output.append(stack.pop()).append(' ');
        }
        return output.toString().trim();
    }
    private static boolean isOperator(char c) {
        return c == '+' || c == '-' || c == '*' || c == '/';
    }
    private static int precedence(char op) {
        if (op == '+' || op == '-') return 1;
        if (op == '*' || op == '/') return 2;
        return 0;
    }
}

public class ExpressionEvaluationEngine {
    public static void main(String[] args) {
        String infix = "3+(2*4)-5";
        String postfix = InfixToPostfixConverter.convert(infix);
        System.out.println("Infix: " + infix);
        System.out.println("Postfix: " + postfix);
        ExpressionEvaluator evaluator = new PostfixEvaluator();
        int result = evaluator.evaluate(postfix);
        System.out.println("Result: " + result);
    }
}