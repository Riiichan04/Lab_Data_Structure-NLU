package lab10;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class MyFIFO_App {
    public static <E> void stutter(Queue<E> input) {
        Queue<E> temp = new LinkedList<>();
        while (!input.isEmpty()) {
            temp.add(input.peek());
            temp.add(input.poll());
        }
        input.addAll(temp);
    }

    public static <E> void mirror (Queue<E> input) {
        Queue<E> temp = new LinkedList<>();
        Stack<E> stack = new Stack<>();
        while (!input.isEmpty()) {
            temp.add(input.peek());
            stack.push(input.poll());
        }
        while (!stack.isEmpty()) {
            temp.add(stack.pop());
        }
        input.addAll(temp);
    }

    public static void main(String[] args) {
        Queue<Integer> test = new LinkedList<>();
        test.add(1); test.add(2); test.add(3);
        stutter(test);
        System.out.println(test);
        mirror(test);
        System.out.println(test);
    }
}


