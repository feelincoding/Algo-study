package bj;
import java.io.*;
import java.util.*;

public class BJ_2577_01 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long A = Long.parseLong(st.nextToken());

        st = new StringTokenizer(br.readLine());
        long B = Long.parseLong(st.nextToken());

        st = new StringTokenizer(br.readLine());
        long C = Long.parseLong(st.nextToken());

        long sum = A * B * C;
        String stringSum = String.valueOf(sum);
        char[] arr = stringSum.toCharArray();
        int[] tempArr = new int[10];
        for (int i = 0; i < arr.length; i++) {
            tempArr[arr[i] - '0']++;
        }
        for (int i = 0; i < tempArr.length; i++) {
            System.out.println(tempArr[i]);
        }
    }
}