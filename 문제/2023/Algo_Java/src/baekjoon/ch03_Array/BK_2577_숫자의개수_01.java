package baekjoon.ch03_Array;

import java.util.*;
import java.io.*;

public class BK_2577_숫자의개수_01 {
    /*
     * 1. 문제 링크: https://www.acmicpc.net/problem/2577
     * 2. 시간제한: 1초 / 3~5억 연산 가능
     * 3. 메모리제한: 128MB / 0.3억개 정도의 int 배열 크기 가능
     * ---
     * 10^6<=A*B*C<=10^9
     * int 범위를 넘어 갈 수 있으므로 long으로 선언
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] numArr = new int[10];
        long num = 1;
        for (int i = 0; i < 3; i++) {
            num *= Integer.parseInt(br.readLine());
        }
        checkNum(numArr, num);
        for (int i = 0; i < 10; i++) {
            System.out.println(numArr[i]);
        }
    }

    private static void checkNum(int[] numArr, long num) {
        while (num > 0) {
            numArr[(int) (num % 10)]++;
            num /= 10;
        }
    }
}
