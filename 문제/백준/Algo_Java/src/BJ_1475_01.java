import java.io.*;
import java.util.*;

public class BJ_1475_01 {
    static int[] arr = new int[10];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int count = 1;
        char[] charArr = st.nextToken().toCharArray();
        for (int i = 0; i < charArr.length; i++) {
            arr[charArr[i] - '0']++;
            if (charArr[i] - '0' == 6 || charArr[i] - '0' == 9) {
                continue;
            }
            count = Math.max(count, arr[charArr[i] - '0']);
        }
        System.out.println(Math.max(count, (arr[6] + arr[9] + 1) / 2));
    }
}
