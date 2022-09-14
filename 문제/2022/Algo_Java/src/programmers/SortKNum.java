package programmers;

import java.io.*;
import java.util.*;

public class SortKNum {
    static int[] array = { 1, 5, 2, 6, 3, 7, 4 };
    static int[][] commands = { { 2, 5, 3 }, { 4, 4, 1 }, { 1, 7, 3 }, { 5, 6, 3 } };

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        for (int index = 0; index < commands.length; index++) {
            int i = commands[index][0];
            int j = commands[index][1];
            int k = commands[index][2];
            int[] tmpArr = new int[j - i + 1];
            for (int l = 0; l < tmpArr.length; l++) {
                tmpArr[l] = array[i - 1 + l];
            }
            Arrays.sort(tmpArr);
            int ans = tmpArr[k - 1];
            list.add(ans);
        }
        int[] answer = new int[list.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = list.get(i);
        }
    }
}
