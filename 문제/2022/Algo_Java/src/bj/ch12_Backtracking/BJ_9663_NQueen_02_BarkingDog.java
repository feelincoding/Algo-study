package bj.ch12_Backtracking;

import java.io.*;
import java.util.*;

public class BJ_9663_NQueen_02_BarkingDog {
    /*
     * 체스 전체를 돌아다니면서 놓고 확인한다
     * 한줄에는 하나만 놓을 수 있다.
     * 가로 세로 대각선에서 만나면 안된다.
     * 대각은 절대값이 같으면 같은 대각선
     * 가로세로는 y나 x가 같으면 같은 줄
     */
    static int[][] map;
    static int[] col;
    static int[] cross1; // /
    static int[] cross2; // \
    static int result = 0;
    static int N;

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        col = new int[N];
        cross1 = new int[2 * N - 1];
        cross2 = new int[2 * N - 1];
        queen(0);

        System.out.println(result);
    }

    private static void queen(int count) {
        if (count == N) { // 퀸 배치 완료
            result++;
            return;
        }
        for (int i = 0; i < N; i++) {
            if (col[i] == 1 || cross1[count + i] == 1 || cross2[count - i + N - 1] == 1) {
                continue; // 문제있으면 패스
            }

            col[i] = 1;
            cross1[count + i] = 1;
            cross2[count - i + N - 1] = 1;
            queen(count + 1);
            col[i] = 0;
            cross1[count + i] = 0;
            cross2[count - i + N - 1] = 0;
        }
    }
}
