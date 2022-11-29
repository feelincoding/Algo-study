package bj.ch03_Array;

import java.util.*;
import java.io.*;

public class BJ_3273_03 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        boolean[] occur = new boolean[2000001];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        int X = Integer.parseInt(st.nextToken());
        int result = 0;
        for (int i = 0; i < N; i++) {
            if (X - arr[i] > 0 && occur[X - arr[i]]) {
                result += 1;
            }
            occur[arr[i]] = true;
        }
        System.out.println(result);
    }
}
