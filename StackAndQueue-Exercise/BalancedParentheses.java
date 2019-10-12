package StackAndQueue.exercise;

import java.util.ArrayDeque;
import java.util.Scanner;

public class BalancedParentheses {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        ArrayDeque<Character> stack = new ArrayDeque<>();

        boolean isEqual = true;
        for (int i = 0; i < input.length(); i++) {
            char symbol = input.charAt(i);
            if (symbol == '{' || symbol == '[' || symbol == '(') {
                stack.push(symbol);
            } else {
                if (stack.isEmpty()) {
                    isEqual = false;
                    break;
                } else {
                    char lastSymbol = stack.pop();
                    if (lastSymbol == '{' && symbol != '}') {
                        isEqual = false;
                        break;
                    } else if (lastSymbol == '[' && symbol != ']') {
                        isEqual = false;
                        break;
                    } else if (lastSymbol == '(' && symbol != ')') {
                        isEqual = false;
                        break;
                    }
                }
            }
        }
        if (isEqual) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}
