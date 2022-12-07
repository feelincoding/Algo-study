package bj.ch07_Deque;

import java.io.*;
import java.util.*;

public class BJ_5430_01 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());
        for (int t = 0; t < T; t++) {
            char[] commands = br.readLine().toCharArray();
            // char[] commands = br.readLine().toCharArray();
            int n = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine()
                    .replaceAll(",", " ")
                    .replace("[", "")
                    .replace("]", ""));
            int[] nArr = new int[st.countTokens()];
            for (int i = 0; i < nArr.length; i++) {
                nArr[i] = Integer.parseInt(st.nextToken());
            }
        }
        
    }
}
