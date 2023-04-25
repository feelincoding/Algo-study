package bj.ch11_recursion;

import java.io.*;
import java.util.*;

public class BJ_1629_02_BarkingDog {
    static int A, B, C;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        System.out.println(pow(A, B, C));
    }

    private static long pow(int a, int b, int c) { // a^b mod c = (a^(b/2) mod c * a^(b/2) mod c) mod c
        if (b == 1) {
            return a % c;
        }
        long val = pow(a, b / 2, c);
        val = val * val % c; // a^b mod c = (a^(b/2) mod c * a^(b/2) mod c) mod c
        if (b % 2 == 0) { // 짝수면 그대로
            return val;
        }
        return val * a % c; // 홀수면 한번 더 a, mod c 해줘야지
    }
}
