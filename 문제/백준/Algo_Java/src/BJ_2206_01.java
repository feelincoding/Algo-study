import java.util.*;
import java.io.*;

public class BJ_2206_01 {
    static int N, M;
    static int[][] map;
    static int[][] distance;
    static boolean[][] isVisited;
    static int[] dy = { 0, 1, 0, -1 }; // 오른쪽부터 시계방향
    static int[] dx = { 1, 0, -1, 0 };
    static int DIR = 4;
    static Queue<Point> q = new LinkedList<>();
    static List<Point> wallList = new ArrayList<>();
    static int count = Integer.MAX_VALUE;
    static boolean check = false;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        distance = new int[N][M];
        isVisited = new boolean[N][M];

        for (int n = 0; n < N; n++) {
            st = new StringTokenizer(br.readLine());
            char[] temp = st.nextToken().toCharArray();
            for (int m = 0; m < M; m++) {
                if (temp[m] == 1) {
                    wallList.add(new Point(n, m));
                }
                map[n][m] = temp[m] - '0';
            }
        }

        for (int i = 0; i < wallList.size(); i++) {
            check = false;
            distance = new int[N][M];
            map[wallList.get(i).y][wallList.get(i).x] = 0;
            isVisited = new boolean[N][M];

            isVisited[0][0] = true;
            q.offer(new Point(0, 0));
            distance[0][0] = 1;
            int ny, nx;
            while (!q.isEmpty()) {
                Point cur = q.poll();
                for (int dir = 0; dir < DIR; dir++) {
                    ny = cur.y + dy[dir];
                    nx = cur.x + dx[dir];
                    if (ny < 0 || ny >= N || nx < 0 || nx >= M)
                        continue;
                    if (map[ny][nx] == 0 || isVisited[ny][nx])
                        continue;
                    isVisited[ny][nx] = true;
                    q.offer(new Point(ny, nx));
                    if (distance[ny][nx] > distance[cur.y][cur.x] + 1) {
                        distance[ny][nx] = distance[cur.y][cur.x] + 1;
                    }
                }
            }
            if (distance[N - 1][M - 1] != 0) {
                count = Math.min(count, distance[N - 1][M - 1]);
            } else {
                count = -1;
            }
        }

        System.out.println(count);
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
