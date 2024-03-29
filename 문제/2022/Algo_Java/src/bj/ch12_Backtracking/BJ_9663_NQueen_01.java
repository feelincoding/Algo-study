package bj.ch12_Backtracking;

import java.io.*;
import java.util.*;

public class BJ_9663_NQueen_01 {
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

        queen(0, 0);

        System.out.println(result);
    }

    private static void queen(int count, int start) {
        if (count == N) { // 퀸 배치 완료
            result++;
            return;
        }
        for (int i = start; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (verific(i, j)) {// 이안에 들어오면 배치할 수 있는거
                    queens[i] = new int[] { i, j };
                    queen(count + 1, i + 1);
                    queens[i] = new int[] { -1, -1 };
                }
            }

        }
    }

    private static boolean verific(int y, int x) {// 
        for (int[] queen : queens) {
            if (queen[0] == -1 || queen[1] == -1) {
                break;
            }
            // 가로 세로 테스트
            if (queen[0] == y || queen[1] == x) {
                return false;
            }
            // 대각선 테스트
            if (Math.abs(queen[0] - y) == Math.abs(queen[1] - x)) {
                return false;
            }
        }

        return true;
    }
}
