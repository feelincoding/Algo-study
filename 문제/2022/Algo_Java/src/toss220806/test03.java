package toss220806;

import java.io.*;
import java.util.*;

public class test03 {
    static boolean[] isVisited;
    static int answer = 0;

    public static void main(String[] args) {
        int k = 80;
        int[][] dungeons = { { 80, 20 }, { 50, 40 }, { 30, 10 } };
        isVisited = new boolean[dungeons.length];
        dfs(0, k, dungeons);
        System.out.println(answer);
    }

    private static void dfs(int cnt, int k, int[][] dungeons) {
        for (int i = 0; i < dungeons.length; i++) {
            if (!isVisited[i]) {
                if (dungeons[i][0] <= k) {
                    isVisited[i] = true;
                    dfs(cnt + 1, k - dungeons[i][1], dungeons);
                    isVisited[i] = false;
                }
            }
        }
        if (cnt > answer) {
            answer = cnt;
        }
    }

}
