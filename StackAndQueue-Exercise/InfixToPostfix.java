package StackAndQueue.exercise;

import java.util.ArrayDeque;
import java.util.Scanner;

public class InfixToPostfix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] dataInput = scanner.nextLine().split("\\s+");
        ArrayDeque<Character> queueDigits = new ArrayDeque<>();
        ArrayDeque<Character> stackOperators = new ArrayDeque<>();

        for (String s : dataInput) {
            char symbol = s.charAt(0);
            if (Character.isDigit(symbol) || Character.isLetter(symbol)) {
                queueDigits.offer(symbol);
            } else {
                if (stackOperators.isEmpty()) {
                    stackOperators.push(symbol);
                } else {
                    Character lastOperator = stackOperators.peek();

                    switch (symbol) {
                        case '+':
                        case '-':
                            if (lastOperator.equals('(')) {
                                stackOperators.push(symbol);
                            } else {
                                queueDigits.offer(stackOperators.pop());
                                stackOperators.push(symbol);
                            }
                            break;
                        case '*':
                        case '/':
                            if (lastOperator.equals('*') || lastOperator.equals('/')) {
                                queueDigits.offer(stackOperators.pop());
                                stackOperators.push(symbol);
                            } else {
                                stackOperators.push(symbol);
                            }
                            break;
                        case '(':
                            stackOperators.push(symbol);
                            break;
                        case ')':
                            while (!stackOperators.peek().equals('(')) {
                                queueDigits.offer(stackOperators.pop());
                            }
                            stackOperators.pop();
                            break;
                    }
                }
            }
        }
        while (!queueDigits.isEmpty()) {
            System.out.print(queueDigits.poll() + " ");
        }

        while (!stackOperators.isEmpty()) {
            System.out.print(stackOperators.pop() + " ");
        }
        System.out.println();
    }
}
