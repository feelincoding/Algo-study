package bj.stackProblem;

import java.io.*;
import java.util.*;

public class BJ_10773_01 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int K = Integer.parseInt(st.nextToken());
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            if (stack.isEmpty()) {
                stack.add(num);
            } else {
                if (num == 0) {
                    stack.pop();
                } else {
                    stack.add(num);
                }
            }
        }
        int answer = 0;
        while (!stack.isEmpty()) {
            answer += stack.pop();
        }
        System.out.println(answer);
    }
}
