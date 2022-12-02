package bj.ch05_Stack;

import java.io.*;
import java.util.*;

public class BJ_1874_02 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int count = 1;
        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        boolean flag = true;
        loop: for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            while (count < num) {
                stack.push(count);
                sb.append("+\n");
                count++;
            }
            if (count == num) {
                sb.append("+\n");
                sb.append("-\n");
                count++;
            } else if (count > num) {
                int peek = stack.peek();
                if (peek == num) {
                    stack.pop();
                    sb.append("-\n");
                } else {
                    System.out.println("NO");
                    flag = false;
                    break loop;
                }
            }
        }
        if (flag) {
            sb.deleteCharAt(sb.length() - 1);
            System.out.println(sb.toString());
        }
    }
}
