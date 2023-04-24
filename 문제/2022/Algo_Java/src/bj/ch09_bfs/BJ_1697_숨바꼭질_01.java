package bj.ch09_bfs;

import java.util.*;
import java.io.*;

public class BJ_1697_숨바꼭질_01 {
    /*
     * 1차원도 BFS로 풀 수 있다. 사실 이건 생각도 못했다.
     * 
     */
    static int[] road = new int[100001];
    static int S, D;
    static Queue<Integer> q = new LinkedList<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        S = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());
        q.offer(S);
        while (!q.isEmpty()) {
            int now = q.poll();
            if (now == D) {
                break;
            }
            if (now - 1 >= 0 && road[now - 1] == 0) {
                q.offer(now - 1);
                road[now - 1] = road[now] + 1;
            }
            if (now + 1 <= 100000 && road[now + 1] == 0) {
                q.offer(now + 1);
                road[now + 1] = road[now] + 1;
            }
            if (now * 2 <= 100000 && road[now * 2] == 0) {
                q.offer(now * 2);
                road[now * 2] = road[now] + 1;
            }
        }
        System.out.println(road[D]);
    }
}
