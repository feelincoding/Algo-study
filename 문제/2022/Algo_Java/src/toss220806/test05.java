package toss220806;

import java.io.*;
import java.util.*;

public class test05 {
    static boolean[] isVisited;
    static int answer = 0;

    public static void main(String[] args) {
        // int[] tasks = { 1 };
        int[] tasks = { 1, 1, 2, 3, 3, 2, 2 };
        // int[] tasks = { 4, 1, 1, 1, 1, 2, 3 };
        // int[] tasks = { 1, 1, 2, 2 };

        Arrays.sort(tasks);
        int tmp = tasks[0];
        int nLength = 1;
        int idx = 1;
        System.out.println(Arrays.toString(tasks));
        if (tasks.length < 2) {
            answer = -1;
        } else {
            while (true) {
                if (idx == tasks.length) {
                    if (nLength == 1) {
                        answer = -1;
                        break;
                    }
                    int tmpLeng = nLength; // 전까지 길이 저장
                    nLength = 1; // 새로운 길이는 1
                    int cnt = (tmpLeng - 1) / 3 + 1;
                    answer += cnt;
                    System.err.println("끝 도달");
                    break;
                }
                int tmp2 = tasks[idx];
                if (tmp == tmp2) {// 같은 숫자면 어디까지 같나 가야지
                    nLength += 1; // 길이 늘어나고
                    idx += 1; // 인덱스 늘어나고
                    tmp = tmp2;// 값 교체하고
                    System.err.println("같은 숫자: " + tmp2);
                } else {// 안 같으면 계산 해야지, 값이랑 길이 둘다
                    if (nLength == 1) {
                        answer = -1;
                        System.err.println("길이 1: " + tmp2);
                        break;
                    } else {
                        int tmpLeng = nLength; // 전까지 길이 저장
                        nLength = 1; // 새로운 길이는 1
                        int cnt = (tmpLeng - 1) / 3 + 1;
                        answer += cnt;
                        idx += 1; // 인덱스 늘어나고
                        tmp = tmp2;// 값 교체하고
                        System.err.println("길이 1 X: " + tmp2);
                    }
                }
            }
        }
        System.out.println(answer);
    }

}
