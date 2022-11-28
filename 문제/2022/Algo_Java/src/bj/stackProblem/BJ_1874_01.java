package bj.stackProblem;

import java.io.*;
import java.util.*;

public class BJ_1874_01 {
    static int N;
    static Stack<Integer> stack = new Stack<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        int start = 0;

        // N 번 반복
        while (N-- > 0) {

            int value = Integer.parseInt(br.readLine());

            if (value > start) {
                // start + 1부터 입력받은 value 까지 push를 한다.
                for (int i = start + 1; i <= value; i++) {
                    stack.push(i);
                    sb.append('+').append('\n'); // + 를 저장한다.
                }
                start = value; // 다음 push 할 때의 오름차순을 유지하기 위한 변수 초기화
            }

            // top에 있는 원소가 입력받은 값과 같이 않은 경우
            else if (stack.peek() != value) {
                System.out.println("NO");
                return; // 또는 System.exit(0); 으로 대체해도 됨.
            }

            stack.pop();
            sb.append('-').append('\n');

        }

        System.out.println(sb);
    }
}
