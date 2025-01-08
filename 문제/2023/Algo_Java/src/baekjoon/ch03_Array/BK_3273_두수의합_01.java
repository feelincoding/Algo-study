package baekjoon.ch03_Array;

import java.io.*;
import java.util.*;

public class BK_3273_두수의합_01 {
    /*
     * 1. 문제 링크: https://www.acmicpc.net/problem/3273
     * 2. 시간제한: 1초 / 3~5억 연산 가능
     * 3. 메모리제한: 128MB / 0.3억개 정도의 int 배열 크기 가능
     * ---
     * 1<=n<=100,000, 1<=x<=1,000,000
     * 최대 계산량: 100000*100000/2 = 5000000000 => 50억
     * 
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int[] nArr = new int[n];
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < nArr.length; i++) {
            nArr[i] = Integer.parseInt(st.nextToken());
        }

        int x = Integer.parseInt(br.readLine());
        int cnt = 0;

        Arrays.sort(nArr);

        for (int i = 0; i < nArr.length - 1; i++) {
            for (int j = i + 1; j < nArr.length; j++) {
                if (nArr[i] + nArr[j] == x) {
                    cnt++;
                }
            }
        }
        System.out.println(cnt);
        System.out.println(Arrays.toString(nArr));
    }
}
