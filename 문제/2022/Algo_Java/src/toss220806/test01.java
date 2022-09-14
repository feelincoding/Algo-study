package toss220806;

import java.io.*;
import java.util.*;

public class test01 {
    public static void main(String[] args) {
        // String s = "12223";
        // String s = "111999333";
        String s = "123";
        int answer = 0;
        ArrayList<Integer> arr = new ArrayList<>();
        // 문자열 길이가 2 이하 일 때
        if (s.length() < 3) {
            answer = -1;
        } else {
            for (int i = 0; i < s.length() - 2; i++) {
                String tmp = s.substring(i, i + 3);
                if (tmp.charAt(0) == tmp.charAt(1) && tmp.charAt(0) == tmp.charAt(2)) {
                    arr.add(Integer.parseInt(tmp));
                }
            }
        }

        if (arr.size() == 0) {
            answer = -1;
        } else {
            answer = Collections.max(arr);
        }
        System.out.println(answer);
    }
}
