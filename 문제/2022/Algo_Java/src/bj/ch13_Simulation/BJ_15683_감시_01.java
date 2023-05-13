package bj.ch13_Simulation;

import java.util.*;
import java.io.*;
import java.lang.reflect.Array;

public class BJ_15683_감시_01 {
    /*
     * 1. 유형파악: 시뮬
     * 2. 계산량 파악: O(NlgN)
     * 
     */
    static int[] dy = { 1, 0, -1, 0 };// 남동북서
    static int[] dx = { 0, 1, 0, -1 };// 남동북서
    static int N, M;
    static int[][] map1;
    static int[][] map2;
    static int result = 64;

    static List<int[]> cctvs = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map1 = new int[N][M];// 맵 기록
        map2 = new int[N][M];// 그림 그릴용

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                int v = Integer.parseInt(st.nextToken());
                if (v != 0 && v != 6)
                    cctvs.add(new int[] { i, j });

                map1[i][j] = v;
            }
        }
        for (int i = 0; i < N; i++) {
            map2[i] = map1[i].clone();
        }

        for (int i = 0; i < Math.pow(4, cctvs.size()); i++) {
            int[] cctv = new int[cctvs.size()]; // cctv들을 4진법으로 표현, 어떤 방향을 보는지, 방향은 4개
            int num = i;
            for (int j = 0; j < cctvs.size(); j++) {
                int m = num % 4; // 나머지
                int q = num / 4; // 몫
                cctv[j] = m;
                num = q;
            }
            for (int j = 0; j < cctv.length; j++) {
                int[] cameraLoc = cctvs.get(j);
                int camera = map1[cameraLoc[0]][cameraLoc[1]];
                switch (camera) {
                    case 1:
                        draw(cameraLoc[0], cameraLoc[1], cctv[j]);
                        break;
                    case 2:
                        draw(cameraLoc[0], cameraLoc[1], cctv[j]);
                        draw(cameraLoc[0], cameraLoc[1], (cctv[j] + 2) % 4);
                        break;
                    case 3:
                        draw(cameraLoc[0], cameraLoc[1], cctv[j]);
                        draw(cameraLoc[0], cameraLoc[1], (cctv[j] + 1) % 4);
                        break;
                    case 4:
                        draw(cameraLoc[0], cameraLoc[1], cctv[j]);
                        draw(cameraLoc[0], cameraLoc[1], (cctv[j] + 2) % 4);
                        draw(cameraLoc[0], cameraLoc[1], (cctv[j] + 1) % 4);
                        break;
                    case 5:
                        draw(cameraLoc[0], cameraLoc[1], cctv[j]);
                        draw(cameraLoc[0], cameraLoc[1], (cctv[j] + 3) % 4);
                        draw(cameraLoc[0], cameraLoc[1], (cctv[j] + 2) % 4);
                        draw(cameraLoc[0], cameraLoc[1], (cctv[j] + 1) % 4);
                        break;

                    default:
                        break;
                }
            }
            int sum = 0;
            for (int j = 0; j < N; j++) {
                for (int j2 = 0; j2 < M; j2++) {
                    if (map2[j][j2] == 0) {
                        sum += 1;
                    }
                }
            }
            result = Math.min(result, sum);

            for (int k = 0; k < N; k++) {
                map2[k] = map1[k].clone();
            }
        }
        System.out.println(result);
    }

    private static void draw(int y, int x, int dir) {
        int curY = y;
        int curX = x;
        while (true) {
            int nextY = curY + dy[dir];
            int nextX = curX + dx[dir];
            if (OOB(nextY, nextX) || map1[nextY][nextX] == 6) {// 범위 벗어남 or 기둥
                break;
            }
            map2[nextY][nextX] = -1;
            curY = nextY;
            curX = nextX;
        }
    }

    private static boolean OOB(int nextY, int nextX) {
        if (nextY < 0 || nextY >= N || nextX < 0 || nextX >= M) {
            return true;
        }
        return false;
    }
}
