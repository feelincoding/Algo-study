package baekjoon.ch03_Array;

import java.util.*;
import java.io.*;

public class BK_1475_방번호_01 {
    /*
     * 1. 문제 링크: https://www.acmicpc.net/problem/1475
     * 2. 시간제한: 2초 / 6~10억 연산 가능
     * 3. 메모리제한: 128MB / 0.3억개 정도의 int 배열 크기 가능
     * ---
     * N<=1,000,000
     * 6, 9는 서로 공유가 가능함으로 더하고 나누기 2를 해준다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] numArr = new int[10];
        while (N > 0) {
            int num = N % 10;
            N /= 10;
            if (num == 6 || num == 9) {
                numArr[6]++;
            } else {
                numArr[num]++;
            }
        }
        numArr[6] = (numArr[6] + 1) / 2;
        int max = 0;
        for (int i = 0; i < 10; i++) {
            max = Math.max(max, numArr[i]);
        }
        System.out.println(max);
    }
}
