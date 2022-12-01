package bj.ch04_LinkedList;

import java.io.*;
import java.util.*;

public class BJ_1158_02 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N, K;
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        Queue<Integer> q1 = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            q1.offer(i);
        }
        int count = 0;
        StringBuilder sb = new StringBuilder();
        sb.append("<");
        while (true) {
            if (q1.isEmpty()) {
                sb.delete(sb.length() - 2, sb.length()); // 공백, ","제거
                sb.append(">");
                break;
            }
            int tmp = q1.poll();
            count++;
            if (count % K == 0) {
                sb.append(tmp);
                sb.append(", ");
                count = 0;
            } else {
                q1.offer(tmp);
            }
        }
        System.out.println(sb.toString());
    }
}
