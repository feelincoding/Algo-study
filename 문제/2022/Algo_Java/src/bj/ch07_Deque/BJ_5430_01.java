package bj.ch07_Deque;

import java.io.*;
import java.util.*;

public class BJ_5430_01 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());
        Deque<Integer> dq = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();
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
                dq.add(Integer.parseInt(st.nextToken()));
            }
            System.out.println("dq: " + dq);

            for (int i = 0; i < commands.length; i++) {
                char command = commands[i];
                if (command == 'D') {
                    if (dq.isEmpty()) {
                        System.out.println("error");
                        break;
                    } else {
                        dq.poll();
                    }
                } else {
                    if (i < commands.length - 1) {
                        if (commands[i + 1] == command) {
                            i++;
                            continue;
                        } else{

                        }
                    }else{
                        
                    }
                }
            }
            dq.clear();
        }

    }
}
