import java.io.*;
import java.util.*;

public class BJ_1158_01 {
    static ArrayList<Integer> arr = new ArrayList<>();
    static ArrayList<Integer> result = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= N; i++) {
            arr.add(i);
        }
        System.out.println(arr.toString());
        int count = 0;
        // int check = 2;
        while (!arr.isEmpty()) {
            count %= arr.size();
            if (count % K == (K-1)) {
                
                result.add(arr.get(count));
                arr.remove(count);
                count++;
                System.out.println(result.toString());
            }
            count++;
        }
        System.out.println(result.toString());
    }
    public class Node {
        int data;
        Node link;

        public Node() {
        }

        public Node(int data, Node link) {
            this.data = data;
            this.link = link;
        }
    }
}
