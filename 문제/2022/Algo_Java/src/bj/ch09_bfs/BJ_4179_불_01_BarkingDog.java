package bj.ch09_Bfs;

import java.util.*;
import java.io.*;

public class BJ_4179_불_01_BarkingDog {
    /*
     * r*c = 1000000 이므로 대략 NlogN안에 끝내야 한다.
     * 지훈, 불 각각의 큐를 사용한다.
     * 지훈이는 불이 난 곳으로 이동할 수 없기 때문에 불 먼저 돌린다.
     * 지훈이는 거리까지 알아야한다.
     * 4 4
     * ####
     * #JF#
     * #..#
     * #..#
     */
    static Queue<int[]> fQ = new LinkedList<>();
    static Queue<int[]> jQ = new LinkedList<>();
    static char[][] map;
    static int[][] distF;
    static int[][] distJ;
    static int R, C;

    static int[] dy = { -1, 1, 0, 0 }; // 상하좌우
    static int[] dx = { 0, 0, -1, 1 };

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new char[R][C];
        distF = new int[R][C];
        distJ = new int[R][C];

        for (int y = 0; y < R; y++) {
            String line = br.readLine();
            for (int x = 0; x < C; x++) {
                char c = line.charAt(x);
                map[y][x] = c;
                distF[y][x] = -1;
                distJ[y][x] = -1;
                if (c == 'J') {
                    jQ.offer(new int[] { y, x });
                    distJ[y][x] = 0;
                }
                if (c == 'F') {
                    fQ.offer(new int[] { y, x });
                    distJ[y][x] = 0;
                }
            }
        }

        while (!fQ.isEmpty()) {
            int[] curF = fQ.poll();
            for (int d = 0; d < 4; d++) {
                int nFy = curF[0] + dy[d];
                int nFx = curF[1] + dx[d];
                if (nIR(nFy, R) || nIR(nFx, C)) // 범위 초과
                    continue;
                if (map[nFy][nFx] == '#' || distF[nFy][nFx] >= 0) // 벽 이거나 불이 번졌거나
                    continue;
                distF[nFy][nFx] = distF[curF[0]][curF[1]] + 1;
                fQ.offer(new int[] { nFy, nFx });
            }
        }
        // 불 다 번졌고 얼마만에 번지는지도 계산이 끝난 상태
        // 즉, 지훈이는 불이 번지는 시간을 알고있다.
        // 지훈이는 불이 번지는 시간보다 빨리 도착해야한다.
        while (!jQ.isEmpty()) {
            int[] curJ = jQ.poll();
            for (int d = 0; d < 4; d++) {
                int nJy = curJ[0] + dy[d];
                int nJx = curJ[1] + dx[d];
                if (nIR(nJy, R) || nIR(nJx, C)) { // 범위 초과, 즉 탈출이다!
                    System.out.println(distJ[curJ[0]][curJ[1]] + 1);
                    return;
                }
                if (map[nJy][nJx] == '#' || distJ[nJy][nJx] >= 0) // 벽 이거나 이미 방문했거나
                    continue;
                if (distF[nJy][nJx] != -1 && distF[nJy][nJx] <= distJ[curJ[0]][curJ[1]] + 1) // 불이 번지는 시간이 지훈이가 도착하는
                                                                                             // 시간보다 빠르면
                    continue;
                distJ[nJy][nJx] = distJ[curJ[0]][curJ[1]] + 1;
                jQ.offer(new int[] { nJy, nJx });
            }
        }
        System.out.println("IMPOSSIBLE"); // 탈출 불가능
    }

    private static boolean nIR(int v, int range) {
        return (v < 0 || v >= range) ? true : false;
    }
}
