package bj.ch05_Stack;

import java.io.*;
import java.util.*;

public class BJ_1874_01 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int count = 0;
        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        boolean flag = true;
        loop: for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            while (count < num) {
                count++;
                stack.push(count);
                sb.append("+\n");
            }
            if (count == num) {
                stack.pop();
                sb.append("-\n");
            } else if (count > num) {
                int peek = stack.peek();
                if (peek == num) {
                    stack.pop();
                    sb.append("-\n");
                } else {
                    System.out.println("No");
                    flag = false;
                    break loop;
                }
            }
            // System.out.println(">>>>num : " + num);
            // System.out.println(">>>>count : " + count);
            // System.out.println(">>>>stack : " + stack.toString());
            // System.out.println(">>>>sb : " + sb.toString());
        }
        if (flag) {
            sb.deleteCharAt(sb.length() - 1);
            System.out.println(sb.toString());
        }
    }
}
