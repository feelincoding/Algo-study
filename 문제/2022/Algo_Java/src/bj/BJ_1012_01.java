package bj;
import java.io.*;
import java.util.*;

public class BJ_1012_01 {
    static int T, M, N, K, whiteWorm;
    static int[][] farm;
    static boolean[][] isVisited;
    static Queue<Point> q = new LinkedList<Point>();
    static int[] dy = { 0, 1, 0, -1 }; // 오른쪽부터 시계방향
    static int[] dx = { 1, 0, -1, 0 };
    static int DIR = 4;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        T = Integer.parseInt(st.nextToken());
        for (int tc = 0; tc < T; tc++) {
            st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            farm = new int[N][M];
            isVisited = new boolean[N][M];
            K = Integer.parseInt(st.nextToken());
            for (int k = 0; k < K; k++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());// col
                int y = Integer.parseInt(st.nextToken());// row

                farm[y][x] = 1;
            }

            whiteWorm = 0;
            for (int y = 0; y < N; y++) {
                for (int x = 0; x < M; x++) {
                    if (farm[y][x] == 0 || isVisited[y][x])
                        continue;
                    bfs(y, x);
                }
            }
            System.out.println(whiteWorm);
        }
    }

    private static void bfs(int y, int x) {
        whiteWorm++;
        isVisited[y][x] = true;
        q.offer(new Point(y, x));

        while (!q.isEmpty()) {
            Point cur = q.poll();
            for (int dir = 0; dir < DIR; dir++) {
                int ny = cur.y + dy[dir];
                int nx = cur.x + dx[dir];
                if (ny < 0 || ny >= N || nx < 0 || nx >= M)
                    continue;
                if (farm[ny][nx] == 0 || isVisited[ny][nx])
                    continue;
                isVisited[ny][nx] = true;
                q.offer(new Point(ny, nx));
            }
        }

    }

    public static class Point {
        int y;
        int x;

        public Point(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
}
