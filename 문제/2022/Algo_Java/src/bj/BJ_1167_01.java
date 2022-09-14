package bj;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_1167_01 {
    static int N;
    static int[][] treeArr;
    static int[][] isVisited;
    static int result = 0;
    

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        treeArr = new int[N + 1][N + 1];
        isVisited = new int[N + 1][N + 1];

        for (int i = 1; i < N + 1; i++) {
            st = new StringTokenizer(br.readLine());
            int node = Integer.parseInt(st.nextToken());
            while (true) {
                int nodeNum = Integer.parseInt(st.nextToken());
                if (nodeNum == -1)
                    break;
                int cost = Integer.parseInt(st.nextToken());
                treeArr[node][nodeNum] = cost;
            }
        }

        for (int i = 1; i < N + 1; i++) {
            dfs(i, 0);
        }

        System.out.println(result);
    }

    public static void dfs(int row, int tmpResult) {
        for (int i = row; i < N + 1; i++) {
            if (isVisited[row][i] == 1)
                continue;
            isVisited[row][i] = 1;
            if (treeArr[row][i] != 0) {
                dfs(i, tmpResult + treeArr[row][i]);
            } else {
                result = Math.max(result, tmpResult);
            }
            // if (treeArr[row][i] == 0) {
            // result = Math.max(result, tmpResult + treeArr[i][0]);
            // } else {
            // dfs(i, tmpResult + treeArr[row][i]);
            // }
        }
    }

    public class Node {
        int node;
        int cost;

        public Node(int node, int cost){
            this.node = node;
            this.cost = cost;
        }
    }
}