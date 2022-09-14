package bj;
import java.io.*;
import java.util.*;

public class BJ_1926_01 {
    static int[][] canvas;
    static boolean[][] isVisited;
    static int[] dy = { 0, 1, 0, -1 }; // 오른쪽부터 시계방향
    static int[] dx = { 1, 0, -1, 0 };
    static int count = 0;
    static int maxArea = 0;
    static int n, m;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        canvas = new int[n][m];
        isVisited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                canvas[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (canvas[i][j] == 0 || isVisited[i][j])
                    continue;
                bfs(i, j);
            }
        }
        System.out.println(count);
        System.err.println(maxArea);
    }

    private static void bfs(int y, int x) {
        Queue<int[]> q = new LinkedList<int[]>();
        isVisited[y][x] = true;
        q.add(new int[] { y, x });
        count++;
        int area = 0;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            area++;
            for (int dir = 0; dir < 4; dir++) {
                int ny = cur[0] + dy[dir];
                int nx = cur[1] + dx[dir];

                if (ny < 0 || ny >= n || nx < 0 || nx >= m)
                    continue;
                if (isVisited[ny][nx] || canvas[ny][nx] == 0)
                    continue;

                isVisited[ny][nx] = true;
                q.offer(new int[] { ny, nx });
            }
        }
        if (area > maxArea)
            maxArea = area;
    }
}
