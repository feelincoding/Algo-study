package bj.ch05_Stack;

import java.io.*;
import java.util.*;

public class BJ_2493_01 {// 0번째를 길이를 0으로 생각했을 때
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        Stack<Top> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        stack.push(new Top(0, 0));
        for (int i = 1; i <= N; i++) {
            int num = Integer.parseInt(st.nextToken());
            Top top = new Top(i, num);
            Top peek = stack.peek();
            if (peek.height >= top.height) {
                stack.push(top);
                sb.append(peek.location + " ");
            } else {
                while (stack.peek().height < top.height) {
                    if (stack.peek().height == 0) {
                        stack.push(top);
                        sb.append(0 + " ");
                        break;
                    }
                    stack.pop();
                    if (stack.peek().height >= top.height) {
                        sb.append(stack.peek().location + " ");
                        stack.push(top);
                    }
                }
            }
        }
        System.out.println(sb.toString());
    }

    private static class Top {
        int location;
        int height;

        public Top(int location, int height) {
            this.location = location;
            this.height = height;
        }

        @Override
        public String toString() {
            return "Top [location=" + location + ", height=" + height + "]";
        }
    }
}
