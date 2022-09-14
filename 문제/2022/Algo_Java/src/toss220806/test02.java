package toss220806;

import java.io.*;
import java.util.*;

public class test02 {
    public static void main(String[] args) {
        int answer = 0;
        // int[] levels = { 1, 2, 3, 4 };
        int[] levels = {1,2,3,4,5,6,7,8,9};
        if (levels.length < 4) {
            answer = -1;
        } else {
            int idx = levels.length / 4;
            Arrays.sort(levels);
            answer = levels[levels.length - idx];
        }

        // System.err.println(Arrays.toString(levels));
        System.err.println(answer);
    }
}
