package bj.ch03_Array;

import java.util.*;
import java.io.*;

public class BJ_3273_01 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        int X = Integer.parseInt(st.nextToken());
        int result = 0;
        for (int i = 0; i < N - 1; i++) {
            if (arr[i] > X) {
                continue;
            }
            for (int j = i + 1; j < N; j++) {
                if ((arr[i] + arr[j]) == X) {
                    result += 1;
                }
            }
        }
        System.out.println(result);
    }
}
