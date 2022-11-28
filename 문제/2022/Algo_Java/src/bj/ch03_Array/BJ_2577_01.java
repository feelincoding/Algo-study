package bj.ch03_Array;

import java.util.*;
import java.io.*;

public class BJ_2577_01 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int result = 1;
        int[] numArr = new int[10];
        for (int i = 0; i < 3; i++) {
            st = new StringTokenizer(br.readLine());
            result *= Integer.parseInt(st.nextToken());
        }

        String tmp = String.valueOf(result);
        char[] tmpArr = tmp.toCharArray();
        for (int i = 0; i < tmpArr.length; i++) {
            numArr[tmpArr[i] - '0'] += 1;
        }
        for (int i = 0; i < numArr.length; i++) {
            System.out.println(numArr[i]);
        }
    }
}
