package bj.ch07_Deque;

import java.io.*;
import java.util.*;

public class BJ_1021_01 {
    static int count = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        Deque<Integer> dq = new ArrayDeque<>();
        for (int i = 1; i <= N; i++) {
            dq.add(i);
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            int select = Integer.parseInt(st.nextToken());
            if (select == dq.peekFirst()) {
                dq.pollFirst();
            } else {
                int idx = 0;
                for (Object tmp : dq.toArray()) {
                    if ((int) tmp == select)
                        break;
                    idx++;
                }
                if (idx <= dq.size() / 2) {
                    while (dq.peekFirst() != select) {
                        left(dq);
                    }
                } else {
                    while (dq.peekFirst() != select) {
                        right(dq);
                    }
                }
                dq.pollFirst();
            }
        }
        System.out.println(count);

    }

    public static void left(Deque<Integer> dq) {
        int first = dq.pollFirst();
        dq.addLast(first);
        count++;
    }

    public static void right(Deque<Integer> dq) {
        int last = dq.pollLast();
        dq.addFirst(last);
        count++;
    }
}
