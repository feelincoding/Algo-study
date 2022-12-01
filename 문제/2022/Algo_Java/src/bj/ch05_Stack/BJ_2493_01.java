package bj.ch05_Stack;

import java.io.*;
import java.util.*;

public class BJ_2493_01 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        stack.push(Integer.parseInt(st.nextToken()));
        sb.append(0 + " ");
        for (int i = 1; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());
            
        }
    }
}
