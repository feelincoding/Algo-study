package bj.ch09_bfs;

import java.util.*;
import java.io.*;

/*
 * 한 칸 부술 수 있음
 * 안 부순 경우
 * 하나 부순 경우 더 부술수는 없어
 * 
 */
public class BJ_2206_01 {
    public static int[] di = { -1, 1, 0, 0 };
    public static int[] dj = { 0, 0, -1, 1 };
    public static int[][] map;
    public static Queue<int[][]> q = new LinkedList<int[][]>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }

}
