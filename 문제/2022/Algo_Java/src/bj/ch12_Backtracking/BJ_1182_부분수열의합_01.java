package bj.ch12_Backtracking;

import java.io.*;
import java.util.*;

public class BJ_1182_부분수열의합_01 {
    /*
     * 컴비네이션으로 접근
     * 1개~N개가 원소인 C들
     */
    static int N, S;
    static int[] nums;
    static int[] subArr;
    static int result = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        nums = new int[N];
        subArr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i <= N; i++) {
            nCr(i, 0, 0);
        }

        System.out.println(result);
    }

    private static void nCr(int r, int count, int start) {
        if (count == r) {
            int sum = 0;
            for (int i = 0; i < r; i++) {
                sum += subArr[i];
            }
            if (sum == S) {
                result++;
            }
            return;
        }
        for (int i = start; i < N; i++) {
            subArr[count] = nums[i];
            nCr(r, count + 1, i + 1);
        }
    }
}
