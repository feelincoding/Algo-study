package bj.ch11_recursion;

import java.util.*;

public class BJ_2447_별찍기10_01 {
    /*
     * N * N 꼴 일 때
     * 시작 위치를 알아야해 그리는건 8개짜리로
     */
    static int[][] map;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        map = new int[N][N];

        drawStar(N, 0, 0);
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 1)
                    System.out.print("*");
                if (map[i][j] == 0)
                    System.out.print(" ");
            }
            System.out.println();
        }
    }

    private static void drawStar(int n, int y, int x) {
        if (n == 3) { // base condition
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    map[y + i][x + j] = 1;
                }
            }
            map[y + 1][x + 1] = 0; // 빈칸 뚫기
            return;
        }

        for (int i = 0; i < 3; i++) { // 8개 실행 해야지, 시작 포인트 8개 뽑는겨
            for (int j = 0; j < 3; j++) {
                if (i == 1 && j == 1)// 가운데는 뚫어야지
                    continue;

                drawStar(n / 3, y + (n / 3) * i, x + (n / 3) * j);
            }
        }
        return;
    }
}
