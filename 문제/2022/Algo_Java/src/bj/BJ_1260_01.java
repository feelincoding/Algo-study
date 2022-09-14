package bj;
import java.io.*;
import java.util.*;

public class BJ_1260_01 {
    static int N, M, V;
    static int[][] arr;
    static boolean[] isVisited;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());
        arr = new int[N + 1][N + 1];
        isVisited = new boolean[N + 1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            arr[v1][v2] = 1;
            arr[v2][v1] = 1;
        }
        dfs(V);
        System.out.println(sb.toString());
        sb = new StringBuilder();
        isVisited = new boolean[N + 1];
        bfs(V);
        System.out.println(sb.toString());
    }

    private static void dfs(int v) {
        if (!isVisited[v]) {
            isVisited[v] = true;
            sb.append(Integer.toString(v) + " ");
            for (int i = 1; i < N + 1; i++) {
                if (arr[v][i] == 1 && !isVisited[i]) {
                    dfs(i);
                }
            }
        } else
            return;
    }

    private static void bfs(int v) {
        Queue<Integer> q = new LinkedList<>();
        isVisited[v] = true;
        q.add(v);
        while (true) {
            if (q.isEmpty())
                break;
            int v1 = q.poll();
            sb.append(Integer.toString(v1) + " ");
            for (int i = 1; i < N + 1; i++) {
                if (arr[v1][i] == 1 && !isVisited[i]) {
                    isVisited[i] = true;
                    q.add(i);
                }
            }
        }
    }
}
