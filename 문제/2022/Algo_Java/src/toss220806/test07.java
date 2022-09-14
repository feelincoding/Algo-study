package toss220806;

import java.io.*;
import java.util.*;

public class test07 {
    static boolean[] isVisited;
    static long answer = 0;

    public static void main(String[] args) {
        int money = 10;
        long[][] stocks = { { 1, 1 }, { 3, 5 }, { 3, 5 }, { 4, 9 } };
        isVisited = new boolean[stocks.length];
        dfs(0, money, stocks);
        System.out.println(answer);
    }

    private static void dfs(int salary, int money, long[][] stocks) {
        for (int i = 0; i < stocks.length; i++) {
            if (!isVisited[i]) {
                if (stocks[i][1] <= money) {
                    isVisited[i] = true;
                    dfs(salary + (int) stocks[i][0], money - (int) stocks[i][1], stocks);
                    isVisited[i] = false;
                }
            }
        }
        if (salary > answer) {
            answer = salary;
        }
    }

}
