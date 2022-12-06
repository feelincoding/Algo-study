package bj.ch06_Queue;

import java.io.*;
import java.util.*;

public class BJ_18258_01 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        LinkedList<String> q = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(st.nextToken());
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String command = st.nextToken();
            switch (command) {
                case "push":
                    q.offer(st.nextToken());
                    break;
                case "pop":
                    sb.append(q.isEmpty() ? "-1\n" : q.pop() + "\n");
                    break;
                case "size":
                    sb.append(q.size() + "\n");
                    break;
                case "empty":
                    sb.append(q.isEmpty() ? 1 + "\n" : 0 + "\n");
                    break;
                case "front":
                    sb.append(q.isEmpty() ? "-1\n" : q.peek() + "\n");
                    break;
                default:
                    sb.append(q.isEmpty() ? "-1\n" : q.peekLast() + "\n");
                    break;
            }
        }
        System.out.println(sb.toString());
    }
}
