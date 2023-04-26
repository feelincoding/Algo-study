package bj.ch12_Backtracking;

import java.io.*;
import java.util.*;

public class BJ_15649_N과M_01_01 {
    static int[] arr;
    static boolean[] visited;
    static int N, M;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[M];
        visited = new boolean[N];

        nPr(0);
    }

    private static void nPr(int count) {
        if (count == M) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < M; i++) {
                sb.append(arr[i]);
                sb.append(" ");
            }
            sb.substring(0, sb.length() - 1);
            System.out.println(sb.toString());
            return;
        }

        for (int i = 0; i < N; i++) {
            if (visited[i]) {
                continue;
            }
            arr[count] = i + 1;
            visited[i] = true;
            nPr(count + 1);
            visited[i] = false;
        }
    }
}
