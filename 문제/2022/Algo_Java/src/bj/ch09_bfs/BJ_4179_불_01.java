package bj.ch09_bfs;

import java.util.*;
import java.io.*;

public class BJ_4179_불_01 {
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
    static int[][] dist;
    static int R, C;

    static int[] dy = { -1, 1, 0, 0 }; // 상하좌우
    static int[] dx = { 0, 0, -1, 1 };

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new char[R][C];
        dist = new int[R][C];

        for (int y = 0; y < R; y++) {
            String line = br.readLine();
            for (int x = 0; x < C; x++) {
                char c = line.charAt(x);
                map[y][x] = c;
                dist[y][x] = -1;
                if (c == 'J') {
                    jQ.offer(new int[] { y, x });
                    dist[y][x] = 0;
                }
                if (c == 'F') {
                    fQ.offer(new int[] { y, x });
                }
            }
        }

        while (!jQ.isEmpty()) {
            // 불 먼저 돌린다.
            int fSize = fQ.size();
            for (int fs = 0; fs < fSize; fs++) {
                int[] curF = fQ.poll();
                for (int d = 0; d < 4; d++) {
                    int nFy = curF[0] + dy[d];
                    int nFx = curF[1] + dx[d];
                    if (nIR(nFy, R) || nIR(nFx, C)) // 범위 초과
                        continue;
                    if (map[nFy][nFx] == '#') // 벽
                        continue;
                    if (map[nFy][nFx] == 'F') // 이미 불
                        continue;
                    map[nFy][nFx] = 'F'; // 불이 번져
                    fQ.offer(new int[] { nFy, nFx });
                }
            }
            // 지훈이 차례
            int jSize = jQ.size();
            for (int js = 0; js < jSize; js++) {
                int[] curJ = jQ.poll();
                for (int d = 0; d < 4; d++) {
                    int nJy = curJ[0] + dy[d];
                    int nJx = curJ[1] + dx[d];
                    if (nIR(nJy, R) || nIR(nJx, C)) { // 범위 초과
                        System.out.println(dist[curJ[0]][curJ[1]] + 1);
                        return;
                    }
                    if (map[nJy][nJx] == '#') { // 벽
                        continue;
                    }
                    if (map[nJy][nJx] == 'F') { // 불
                        continue;
                    }
                    if (dist[nJy][nJx] >= 0) { // 이미 방문
                        continue;
                    }
                    dist[nJy][nJx] = dist[curJ[0]][curJ[1]] + 1;
                    jQ.offer(new int[] { nJy, nJx });
                }
            }
        }
        System.out.println("IMPOSSIBLE");
    }

    private static boolean nIR(int v, int range) {
        return (v < 0 || v >= range) ? true : false;
    }
}
