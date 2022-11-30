package bj.ch04_LinkedList;

import java.util.*;
import java.io.*;

// 시간초과 떠버림
public class BJ_5397_03 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        for (int i = 0; i < n; i++) {
            Stack<Character> list = new Stack<>();
            String commands = br.readLine();
            int point = 0;
            for (int j = 0; j < commands.length(); j++) {
                char command = commands.charAt(j);
                if (command == '<') {
                    if (point > 0) {
                        point -= 1;
                    }
                } else if (command == '>') {
                    if (point < list.size()) {
                        point += 1;
                    }
                } else if (command == '-') {
                    if (point > 0) {
                        list.remove(point - 1);
                        point -= 1;
                    }
                } else {
                    list.add(point, command);
                    point += 1;
                }
            }
            for (int j = 0; j < list.size(); j++) {
                System.out.print(list.get(j));
            }
            System.out.println();
        }
    }

}
