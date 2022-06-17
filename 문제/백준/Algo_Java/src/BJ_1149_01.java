
import java.io.*;
import java.util.*;

public class BJ_1149_01 {
    static int N;
    static int[][] arr;
    static int result = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        arr = new int[N + 1][3];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 3; i++) {
            int cost = Integer.parseInt(st.nextToken());
            arr[1][i] = cost;
        }

        for (int i = 2; i < N + 1; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken())
                    + (arr[i - 1][1] > arr[i - 1][2] ? arr[i - 1][2] : arr[i - 1][1]);
            arr[i][1] = Integer.parseInt(st.nextToken())
                    + (arr[i - 1][2] > arr[i - 1][0] ? arr[i - 1][0] : arr[i - 1][2]);
            arr[i][2] = Integer.parseInt(st.nextToken())
                    + (arr[i - 1][0] > arr[i - 1][1] ? arr[i - 1][1] : arr[i - 1][0]);
        }
        System.out.println(Math.min(arr[N][0], Math.min(arr[N][1], arr[N][2])));
    }
}
