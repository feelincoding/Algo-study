package bj.ch03_Array;

import java.util.*;
import java.io.*;

public class BJ_1475_01 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String num = br.readLine();
        char[] numArr = num.toCharArray();
        int[] numCount = new int[10];
        for (int i = 0; i < numArr.length; i++) {
            numCount[numArr[i] - '0'] += 1;
        }
        int tmp = (numCount[6] + numCount[9] + 1) / 2;
        numCount[6] = tmp;
        numCount[9] = tmp;
        int result = 0;
        for (int i = 0; i < numCount.length; i++) {
            result = result < numCount[i] ? numCount[i] : result;
        }
        System.out.println(result);
    }
}
