package bj.ch11_recursion;

import java.io.*;
import java.util.*;

public class BJ_1629_01 {
    static int A, B, C;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        long result = pow(A, B, C);
        System.out.println(result);
    }

    private static long pow(int a, int b, int c) {
        if (b == 1) {
            return a % c;
        }
        long nextV = a * pow(a, b - 1, c);
        return nextV % c;
    }
}
