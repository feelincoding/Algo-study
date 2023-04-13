package bj.ch09_bfs;

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
public class BJ_1926_그림_01 {
    static int[] di = { -1, 1, 0, 0 };// 상하좌우
    static int[] dj = { 0, 0, -1, 1 };// 상하좌우
    static int n, m;
    static int[][] map;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int count = 0;
        int area = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 0 || map[i][j] == -1) {// 그림이 아니거나 방문한 경우
                    continue;
                } else if (map[i][j] == 1) {// 방문하지 않은 그림인 경우
                    count++;
                    area = Math.max(area, bfs(i, j));
                }
            }
        }
        System.out.println(count);
        System.out.println(area);

    }

    private static int bfs(int i, int j) {
        Queue<int[]> q = new LinkedList<>();
        int curI = i;
        int curJ = j;
        int area = 0;

        area++;
        map[i][j] = -1;
        q.add(new int[] { curI, curJ });

        while (!q.isEmpty()) {
            int[] point = q.poll();
            for (int k = 0; k < 4; k++) {
                int nextI = point[0] + di[k];
                int nextJ = point[1] + dj[k];
                if (nextI < 0 || nextI >= n || nextJ < 0 || nextJ >= m) {// 범위를 넘으면
                    continue;
                } else {
                    if (map[nextI][nextJ] == 1) {
                        area++;
                        map[nextI][nextJ] = -1;
                        q.add(new int[] { nextI, nextJ });
                    }
                }
            }
        }

        return area;
    }
}
