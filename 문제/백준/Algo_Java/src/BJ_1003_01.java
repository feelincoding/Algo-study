import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class BJ_1003_01 {
    static ArrayList<int[]> arr = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        arr.add(new int[] { 1, 0 });// 0
        arr.add(new int[] { 0, 1 });// 1

        int T = Integer.parseInt(st.nextToken());
        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int[] temp = fibonacci(N);
            System.out.println(temp[0] + " " + temp[1]);
            // if (arr.size() > N) {
            //     int[] temp = arr.get(N);
            //     System.out.println(temp[0] + " " + temp[1]);
            // } else {
            //     int[] temp = fibonacci(N);
            //     System.out.println(temp[0] + " " + temp[1]);
            // }
        }
    }

    public static int[] fibonacci(int N) {
        if (arr.size() > N) {
            return arr.get(N);
        } else {
            int[] temp1 = fibonacci(N - 1);
            int[] temp2 = fibonacci(N - 2);
            int[] temp3 = new int[] { temp1[0] + temp2[0], temp1[1] + temp2[1] };
            arr.add(N, temp3);
            return temp3;
        }
    }
}
