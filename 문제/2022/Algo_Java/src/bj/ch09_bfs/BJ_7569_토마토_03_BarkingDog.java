package bj.ch09_Bfs;

import java.util.*;
import java.io.*;

public class BJ_7569_토마토_03_BarkingDog {
    /*
     * 
     */
    static int N, M, H;
    static int[][][] box;
    static int[][][] dist;
    static int[] dh = { -1, 1, 0, 0, 0, 0 };
    // static int[] dn = { 0, 0, 0, 0 - 1, 1 };
    // static int[] dm = { 0, 0, -1, 1, 0, 0 };
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
        dist = new int[H][N][M];

        for (int h = 0; h < H; h++) {
            for (int n = 0; n < N; n++) {
                st = new StringTokenizer(br.readLine());
                for (int m = 0; m < M; m++) {
                    int tomato = Integer.parseInt(st.nextToken());
                    box[h][n][m] = tomato;
                    if (tomato == 1) {
                        q.add(new int[] { h, n, m });
                    }
                    if (tomato == 0) {
                        dist[h][n][m] = -1;
                    }
                }
            }
        }

        bfs();
        int result = 0;
        for (int h = 0; h < H; h++) {
            for (int n = 0; n < N; n++) {
                for (int m = 0; m < M; m++) {
                    if (dist[h][n][m] == -1) {
                        System.out.println(-1);
                        return;
                    }
                    result = Math.max(result, dist[h][n][m]);
                }
            }
        }
        System.out.println(result);
    }

    private static void bfs() {
        while (!q.isEmpty()) {
            int[] point = q.poll();
            for (int j = 0; j < 6; j++) {
                int nextH = point[0] + dh[j];
                int nextN = point[1] + dn[j];
                int nextM = point[2] + dm[j];
                if (iNR(nextH, H) || iNR(nextM, M) || iNR(nextN, N)) {
                    continue;
                }
                if (box[nextH][nextN][nextM] == 0) {
                    box[nextH][nextN][nextM] = 1;
                    q.offer(new int[] { nextH, nextN, nextM });
                    dist[nextH][nextN][nextM] = dist[point[0]][point[1]][point[2]] + 1;
                }
            }
        }
    }

    private static boolean iNR(int v, int R) { // is not range
        return (v < 0 || v >= R) ? true : false;
    }
}
