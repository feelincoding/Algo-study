package bj;
import java.io.*;
import java.util.*;

public class BJ_1926_03 {
    // static int n, m, count, maxArea, area;
    // static int[][] canvas;
    // static boolean[][] isVisited;
    // static int[] dy = { 0, 1, 0, -1 }; // 오른쪽부터 시계방향
    // static int[] dx = { 1, 0, -1, 0 };
    // static Queue<int[]> q = new LinkedList<>();

    static int n, m;
    static int[][] canvas;
    static boolean[][] isVisited;
    static int[] dx;
    static int[] dy;
    static Queue<int[]> q;
    static int count = 0;
    static int area = 0;
    static int maxArea = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        canvas = new int[n][m];
        isVisited = new boolean[n][m];
        q = new LinkedList<>();

        dy = new int[] { 0, 1, 0, -1 };
        dx = new int[] { 1, 0, -1, 0 };

        // 배열값 세팅
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                canvas[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        // 시작!
        count = 0;
        area = 0;
        maxArea = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (canvas[i][j] == 0 || isVisited[i][j]) {
                    continue;
                } else {
                    count++; // 1이고, 방문을 하지 않았으므로 시작점이 되니까 +1
                    q.offer(new int[] { i, j }); // 큐에 좌표를 넣어준다.
                    isVisited[i][j] = true; // 방문처리!
                    area = 0; // 0이면 그림이 끊겼으므로 area = 0!
                    while (!q.isEmpty()) {
                        int[] p = q.poll();
                        area++; // 넓이 +1
                        for (int k = 0; k < 4; k++) {
                            int n_y = p[0] + dy[k];
                            int n_x = p[1] + dx[k];
                            if (n_y < 0 || n_y >= n || n_x < 0 || n_x >= m)
                                continue;

                            if (canvas[n_y][n_x] == 0 || isVisited[n_y][n_x])
                                continue;

                            q.offer(new int[] { n_y, n_x });
                            isVisited[n_y][n_x] = true;

                        }
                    }
                    if (area > maxArea) {
                        maxArea = area;
                    }
                }
            }
        }
        System.out.println(count);
        System.err.println(maxArea);
    }
}
