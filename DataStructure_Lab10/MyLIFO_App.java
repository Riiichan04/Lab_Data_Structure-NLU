package lab10;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class MyLIFO_App {
    public static <E> void reserve(E[] array) {
        Stack<E> stack = new Stack<>();
        for (E ele : array) {
            stack.push(ele);
        }
        for (int i = 0; i < array.length; i++) {
            array[i] = stack.pop();
        }
    }

    public static boolean isCorrect(String input) {
        Stack<Character> listChar = new Stack<>();
        for (int i = 0; i < input.length(); i++) {
            char currentChar = input.charAt(i);
            switch (currentChar) {
                case ']': {
                    if (listChar.isEmpty() || listChar.pop() != '[') return false;
                    else break;
                }
                case '}': {
                    if (listChar.isEmpty() || listChar.pop() != '{') return false;
                    else break;
                }
                case ')': {
                    if (listChar.isEmpty() || listChar.pop() != '(') return false;
                    else break;
                }
                default:
                    listChar.push(currentChar);
            }
        }
        return listChar.isEmpty();
    }

    public static int evaluateExpression(String exp) {
        Stack<Integer> operandStack = new Stack<>();
        Stack<Character> operatorStack = new Stack<>();
        String num = "";
        for (int i = 0; i < exp.length(); i++) {
            char currentChar = exp.charAt(i);
            if (!isOpearator(currentChar)) {
                num += currentChar;
                if (i == exp.length() - 1) operandStack.push(Integer.parseInt(num));
            } else {
                if (!num.equals("")) {
                    operandStack.push(Integer.parseInt(num));
                }
                switch (currentChar) {
                    case ')': {
                        while (operatorStack.peek() != '(') {
                            operandStack.push(calc(operandStack.pop(), operatorStack.pop(), operandStack.pop()));
                        }
                        operatorStack.pop();
                        break;
                    }
                    case '+', '-': {
                        if (!operatorStack.isEmpty() && operandStack.size() > 1 && operatorStack.peek() != '(') {
                            int test = calc(operandStack.pop(), operatorStack.pop(), operandStack.pop());
                            operandStack.push(test);
                        }
                        operatorStack.push(currentChar);
                        break;
                    }
                    case '*', '/': {
                        if (!operatorStack.isEmpty())
                            if (operatorStack.peek() == '*' || operatorStack.peek() == '/') {
                                operandStack.push(calc(operandStack.pop(), operatorStack.pop(), operandStack.pop()));
                            }
                        operatorStack.push(currentChar);
                        break;
                    }
                    default: operatorStack.push(currentChar);
                }
                num = "";
            }
        }
        while (!operatorStack.isEmpty()) {
            operandStack.push(calc(operandStack.pop(), operatorStack.pop(), operandStack.pop()));
        }
        return operandStack.pop();
    }

    public static boolean isOpearator(char input) {
        return input == '+' || input == '-' || input == '*' || input == '/' || input == '(' || input == ')';
    }

    public static int calc(int a, char exp, int b) {
        switch (exp) {
            case '+':
                return a + b;
            case '-':
                return b - a;
            case '*':
                return a * b;
            case '/':
                return a / b;
        }
        return 0;
    }

    public static void main(String[] args) {
        String test = "((((()){}[]";
        System.out.println(isCorrect(test));
        String test2 = "51+(54*(3+2))+9-10+3*5-8-9+12/4+3-10";
        System.out.println(evaluateExpression(test2));
    }
}
