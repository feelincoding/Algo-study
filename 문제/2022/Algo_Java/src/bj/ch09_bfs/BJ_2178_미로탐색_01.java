package bj.ch09_bfs;

import java.util.*;
import java.io.*;

public class BJ_2178_미로탐색_01 {
    /*
     * 1은 이동할 수 있는 칸, 0은 이동할 수 없는 칸
     * 
     */
    static int[] dx = { -1, 1, 0, 0 };
    static int[] dy = { 0, 0, -1, 1 };
    static int N, M;
    static int[][] map;
    static int[][] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        visited = new int[N][M];
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = str.charAt(j) - '0';
            }
        }
        Queue<int[]> q = new LinkedList<>();
        visited[0][0] = 1;
        q.add(new int[] { 0, 0 });
        while (!q.isEmpty()) {
            int[] curPoint = q.poll();
            int curI = curPoint[0];
            int curJ = curPoint[1];

            for (int i = 0; i < 4; i++) {
                int nextI = curI + dx[i];
                int nextJ = curJ + dy[i];

                if (nextI < 0 || nextI >= N || nextJ < 0 || nextJ >= M)// 범위 벗어남
                    continue;
                if (map[nextI][nextJ] != 1 || visited[nextI][nextJ] > 0)// 이동할 수 없는 칸, 방문했던 칸
                    continue;

                visited[nextI][nextJ] = visited[curI][curJ] + 1;
                q.add(new int[] { nextI, nextJ });
            }
        }
        System.out.println(visited[N - 1][M - 1]);
    }
}
