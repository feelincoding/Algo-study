package bj.ch12_Backtracking;

import java.io.*;
import java.util.*;

public class BJ_9663_NQueen_03 {
    /*
     * 체스 전체를 돌아다니면서 놓고 확인한다
     * 한줄에는 하나만 놓을 수 있다.
     * 가로 세로 대각선에서 만나면 안된다.
     * 대각은 절대값이 같으면 같은 대각선
     * 가로세로는 y나 x가 같으면 같은 줄
     */
    static int[][] map;
    static int[][] queens;
    static int result = 0;
    static int N;

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        map = new int[N][N];
        queens = new int[N][2];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < 2; j++) {
                queens[i][j] = -1;
            }
        }

        queen(0, map);

        System.out.println(result);
        // draw(2, 2, 1);
        // for (int i = 0; i < N; i++) {
        // System.out.println(Arrays.toString(map[i]));
        // }
    }

    private static void queen(int count, int[][] m) {
        int[][] localMap = m.clone();
        if (count == N) { // 퀸 배치 완료
            for (int i = 0; i < N; i++) {
                System.out.println(Arrays.toString(localMap[i]));
            }
            result++;
            return;
        }
        for (int i = 0; i < N; i++) {
            if (localMap[count][i] == 0) {
                draw(count, i, 1, localMap);
                queen(count + 1, localMap);
                draw(count, i, 0, localMap);
            }
        }
    }

    private static void draw(int y, int x, int v, int[][] m) {//
        for (int i = 0; i < N - x; i++) { // 가로
            m[y][x + i] = v;
        }
        for (int i = 0; i < N - y; i++) { // 세로
            m[y + i][x] = v;
        }
        for (int i = 0; i < ((N - y) > (N - x) ? (N - x) : (N - y)); i++) { // \
            m[y + i][x + i] = v;
        }
        for (int i = 0; i < (y < (N - x - 1) ? y + 1 : N - x); i++) { // / 의 위에
            m[y - i][x + i] = v;
        }
        for (int i = 0; i < ((N - y - 1) < x ? N - y : x + 1); i++) { // / 의 아래
            m[y + i][x - i] = v;
        }
    }
}
