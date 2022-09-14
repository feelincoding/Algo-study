package programmers;

import java.util.*;

public class StackQueue_dontLikeSameNum {
    static int[] arr = { 1, 1, 3, 3, 0, 1, 1 };

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            if (stack.isEmpty())
                stack.add(arr[i]);
            else {
                int tmp = stack.peek();
                if (tmp != arr[i]) {
                    stack.add(arr[i]);
                }
            }
        }
        Object[] stackArr = stack.toArray();
        int[] answer = new int[stackArr.length];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = (int) stackArr[i];
        }
    }
}
