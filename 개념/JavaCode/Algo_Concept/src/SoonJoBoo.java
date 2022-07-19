import java.util.*;
public class SoonJoBoo {
    static int[] n = {1,2,3,4,5};
    static int r = 3;
    static int count = 0;
    static int[] numberSet = new int[r];
    static boolean[] isSelected = new boolean[n.length];

    public static void main(String args[]) {
        // nPr(0);
        // nPir(0);
        nCr(0, 0);
        // nHr(0, 0);
        System.out.println(count);
    }

    /*
     * 연습공간
     */
    private static void testnPr(int cnt) {
        if (cnt == r) {
            System.out.println(Arrays.toString(numberSet));
        }

        for (int i = 0; i < n.length; i++) {
            if (isSelected[i])
                continue;
            numberSet[cnt] = i;

        }
    }

    private static void nPr(int cnt) {
        if (cnt == r) {
            count++;
            System.out.println(Arrays.toString(numberSet));
            return;
        }
        for (int i = 0; i < n.length; i++) {
            if (isSelected[i] == true) {
                continue;
            } else {
                numberSet[cnt] = n[i];
                isSelected[i] = true;
                nPr(cnt + 1);
                isSelected[i] = false;
            }
        }
    }

    private static void nPir(int cnt) {
        if (cnt == r) {
            System.out.println(Arrays.toString(numberSet));
            count++;
            return;
        }
        for (int i = 0; i < n.length; i++) {
            numberSet[cnt] = i;
            nPir(cnt + 1);
        }
    }
    private static void nCr2(int cnt, int start) {
        if (cnt == r) {
            count++;
            System.out.println(Arrays.toString(numberSet));
            return;
        }
        for (int i = start; i < n.length; i++) {
            numberSet[cnt] = i;
            nCr2(cnt + 1, i + 1);
        }
    }

    private static void nCr(int cnt, int start) {
        if (cnt == r) {
            count++;
            System.out.println(Arrays.toString(numberSet));
            return;
        }
        for (int i = start; i < n.length; i++) {
            if (isSelected[i] == true) {
                continue;
            } else {
                numberSet[cnt] = n[i];
                isSelected[i] = true;
                nCr(cnt + 1, i + 1);
                isSelected[i] = false;
            }
        }
    }

    private static void nHr(int cnt, int start) {
        if (cnt == r) {
            count++;
            System.out.println(Arrays.toString(numberSet));
            return;
        }
        for (int i = start; i < n.length; i++) {
            numberSet[cnt] = i;
            nHr(cnt + 1, i);
        }
    }




    private static void nCr3(int cnt, int start) {
        if (cnt == r) {
            count++;
            System.out.println(Arrays.toString(numberSet));
            return;
        }
        if (start == n.length) {
            return;
        }
        isSelected[start] = true;
        nCr(cnt + 1, start + 1);
        isSelected[start] = false;
        nCr(cnt, start + 1);
    }
}
