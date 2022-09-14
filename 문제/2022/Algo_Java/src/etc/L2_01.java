package etc;

import java.util.*;

public class L2_01 {
    static int[] balls = { 1, 4, 3, 2, 5, 6 };
    // static int[] order = { 6, 1, 2, 5, 4, 3 };
    // static int[] order = { 4, 3, 2, 5, 6, 1 };
    // static int[] order = { 3, 2, 4, 5, 6, 1 };
    static int[] order = { 6, 3, 2, 1, 4, 5 };

    static LinkedList<Integer> oList = new LinkedList<>();
    static LinkedList<Integer> aList = new LinkedList<>();
    static LinkedList<Integer> bList = new LinkedList<>();

    public static void main(String[] args) {
        for (int i = 0; i < balls.length; i++) {
            bList.add(balls[i]);
        }
        for (int i = 0; i < order.length; i++) {
            int fball = bList.peekFirst();
            int lball = bList.peekLast();
            if (fball == order[i]) {
                bList.pollFirst();
                aList.add(fball);
            } else if (lball == order[i]) {
                bList.pollLast();
                aList.add(lball);
            } else {
                oList.add(order[i]);
            }
            stackOrder();
        }
        System.out.println(aList);
    }

    public static void stackOrder() {
        if (oList.isEmpty()) {
            return;
        } else {
            for (int i = 0; i < oList.size(); i++) {
                int fball = bList.peekFirst();
                int lball = bList.peekLast();

                if (fball == oList.get(i)) {
                    bList.pollFirst();
                    aList.add(fball);
                    oList.remove(i);

                    i = -1;
                } else if (lball == oList.get(i)) {
                    bList.pollLast();
                    aList.add(lball);
                    oList.remove(i);

                    i = -1;
                }
            }
        }
        return;
    }
}
