package bj.ch04_LinkedList;

import java.util.*;
import java.io.*;

public class BJ_5397_01 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        for (int i = 0; i < n; i++) {
            LinkedList<Character> list = new LinkedList<>();
            st = new StringTokenizer(br.readLine());
            int point = 0;
            while (st.countTokens() > 0) {
                String command = st.nextToken();
                if (command.equals("<")) {

                } else if (command.equals(">")) {
        
                } else if (command.equals("-")) {
        
                }
            }
        }
    }

}
