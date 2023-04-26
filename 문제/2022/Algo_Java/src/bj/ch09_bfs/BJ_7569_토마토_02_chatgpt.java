package bj.ch09_Bfs;

import java.util.*;

public class BJ_7569_토마토_02_chatgpt {
    static int[][][] boxes;
    static int[] dx = { 0, 0, 0, 0, -1, 1 };
    static int[] dy = { 0, 0, -1, 1, 0, 0 };
    static int[] dz = { -1, 1, 0, 0, 0, 0 };

    static int M, N, H;

    static Queue<int[]> queue = new LinkedList<>();

    static int bfs() {
        int day = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                int[] current = queue.poll();
                for (int i = 0; i < 6; i++) {
                    int nz = current[0] + dz[i];
                    int nx = current[1] + dx[i];
                    int ny = current[2] + dy[i];
                    if (nx < 0 || nx >= N || ny < 0 || ny >= M || nz < 0 || nz >= H) {
                        continue;
                    }
                    if (boxes[nz][nx][ny] == 0) {
                        boxes[nz][nx][ny] = 1;
                        queue.offer(new int[] { nz, nx, ny });
                    }
                }
            }
            day++;
        }
        return day - 1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        M = sc.nextInt();
        N = sc.nextInt();
        H = sc.nextInt();
        boxes = new int[H][N][M];
        for (int k = 0; k < H; k++) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    boxes[k][i][j] = sc.nextInt();
                    if (boxes[k][i][j] == 1) {
                        queue.offer(new int[] { k, i, j });
                    }
                }
            }
        }

        int result = bfs();
        for (int k = 0; k < H; k++) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (boxes[k][i][j] == 0) {
                        System.out.println(-1);
                        return;
                    }
                }
            }
        }
        System.out.println(result);
    }
}