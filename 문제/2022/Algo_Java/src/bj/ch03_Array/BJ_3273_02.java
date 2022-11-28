package bj.ch03_Array;

import java.util.*;
import java.io.*;
import java.lang.reflect.Array;

public class BJ_3273_02 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int[] arr = new int[2000001];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[Integer.parseInt(st.nextToken())] = 1;
        }
        st = new StringTokenizer(br.readLine());
        int X = Integer.parseInt(st.nextToken());
        int result = 0;
        for (int i = 1; i < (X + 1) / 2; i++) {
            if (arr[i] == 1 && arr[X - i] == 1) {
                result += 1;
            }

        }
        System.out.println(result);

    }
}
