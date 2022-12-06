package bj.ch05_Stack;

import java.io.*;
import java.util.*;

public class BJ_2493_02 {// 0번째 길이를 최고로 생각했을 때
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        Stack<Top> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        stack.push(new Top(0, 100000001));
        for (int i = 1; i <= N; i++) {
            int num = Integer.parseInt(st.nextToken());
            Top top = new Top(i, num);
            while (stack.peek().height < top.height) {
                stack.pop();
            }
            sb.append(stack.peek().location + " ");
            stack.push(top);
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
