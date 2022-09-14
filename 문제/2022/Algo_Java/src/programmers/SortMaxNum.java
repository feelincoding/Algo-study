package programmers;

import java.util.*;

public class SortMaxNum {
    // static int[] numbers = { 6, 10, 2 };
    // static int[] numbers = { 3, 5, 30, 34, 9 };
    static int[] numbers = { 0, 0, 0, 0 };

    public static void main(String[] args) {
        ArrayList<NAT> dNums = new ArrayList<>();
        for (int i = 0; i < numbers.length; i++) {
            dNums.add(new NAT(String.valueOf(numbers[i])));
        }
        Collections.sort(dNums);
        // Collections.reverse(dNums);
        System.out.println(dNums);
        String answer = "";
        for (NAT nat : dNums) {

            answer += nat.s;
        }
        System.out.println(answer);
        // if (answer[0].equals("0"))
        if (answer.split("0").length == 0) {
            answer = "0";
        }
        // answer = "0";
    }

    public static class NAT implements Comparable<NAT> {
        String s;

        public NAT(String s) {
            this.s = s;
        }

        @Override
        public int compareTo(NAT o) {
            return (o.s + s).compareTo(s + o.s);
        }

        @Override
        public String toString() {
            return "NAT [s=" + s + "]";
        }

    }
}
