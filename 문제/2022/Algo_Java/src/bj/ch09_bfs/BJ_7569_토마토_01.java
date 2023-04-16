package bj.ch09_bfs;

import java.util.*;
import java.io.*;

public class BJ_7569_토마토_01 {
    /*
     * 
     */
    static int N, M, H;
    static int[][][] box;
    static int[][][] distance;
    static int[] dh = { -1, 1, 0, 0, 0, 0 };
    static int[] dn = { 0, 0, -1, 1, 0, 0 };
    static int[] dm = { 0, 0, 0, 0, -1, 1 };
    static Queue<int[]> q = new LinkedList<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        box = new int[H][N][M];
        distance = new int[H][N][M];

        for (int h = 0; h < H; h++) {
            for (int n = 0; n < N; n++) {
                st = new StringTokenizer(br.readLine());
                for (int m = 0; m < M; m++) {
                    int tomato = Integer.parseInt(st.nextToken());
                    box[h][n][m] = tomato;
                    if (tomato == 1) {
                        q.add(new int[] { h, n, m });
                    }
                }
            }
        }

        // for (int i = 0; i < H; i++) {
        // System.out.println(Arrays.deepToString(box[i]));
        // }
        while (!q.isEmpty()) {
            int[] point = q.poll();
        }
    }
}
