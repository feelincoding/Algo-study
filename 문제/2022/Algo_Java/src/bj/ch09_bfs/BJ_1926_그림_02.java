package bj.ch09_Bfs;

import java.util.*;
import java.io.*;

/*
 * 그림의 개수, 가장 넓은 그림의 넓이 출력
 * bfs문제이다.
 * 1. 모든 칸을 돌면서 bfs를 돌릴지 말지 결정
 * 2. 돌린다면 개수 추가, 넓이 비교하여 저장
 * 3. 안돌린다면 패스
 * 4. 1~3 반복 후 마지막 결과 출력
 */
public class BJ_1926_그림_02 {
    static int[] dx = { -1, 1, 0, 0 };// 상하좌우
    static int[] dy = { 0, 0, -1, 1 };// 상하좌우
    static int n, m;
    static int[][] map;
    static boolean[][] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int count = 0;
        int maxArea = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 0 || visited[i][j]) {// 그림이 아니거나 방문한 경우
                    continue;
                }
                Queue<int[]> q = new LinkedList<>();
                count++;
                visited[i][j] = true;
                q.add(new int[] { i, j });
                int area = 0;
                while (!q.isEmpty()) {
                    area++;
                    int[] curPoint = q.poll();
                    int curI = curPoint[0];
                    int curJ = curPoint[1];

                    for (int k = 0; k < 4; k++) {
                        int nextI = curI + dx[k];
                        int nextJ = curJ + dy[k];

                        if (nextI < 0 || nextI >= n || nextJ < 0 || nextJ >= m) {
                            continue;
                        }
                        if (visited[nextI][nextJ] || map[nextI][nextJ] != 1) {
                            continue;
                        }

                        visited[nextI][nextJ] = true;
                        q.add(new int[] { nextI, nextJ });
                    }
                }
                maxArea = Math.max(maxArea, area);
            }
        }
        System.out.println(count);
        System.out.println(maxArea);
    }
}
