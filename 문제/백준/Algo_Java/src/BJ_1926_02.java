import java.util.*;
import java.io.*;

public class BJ_1926_02 {
    static int n, m;
    static int[][] arr;
    static boolean[][] visit;
    static int[] dx;
    static int[] dy;
    static Queue<int[]> qu;

    public static void main(String args[]) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        
        arr = new int[n][m];
        visit = new boolean[n][m];
        qu = new LinkedList<>();
        
        dx = new int[]{1, 0, -1, 0};
        dy = new int[]{0, 1, 0, -1};
        
        // 배열값 세팅
        for(int i=0; i<n; i++){
            st = new StringTokenizer(bf.readLine());
            for(int j=0; j<m; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        // 시작!
        int count = 0;
        int area = 0;
        int max = 0;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                // 0이거나 방문한적이 있으면 생략.
                if(arr[i][j] == 0 || visit[i][j]){
                    continue;
                }
                count++;    // 1이고, 방문을 하지 않았으므로 시작점이 되니까 +1
                qu.offer(new int[]{i, j});   // 큐에 좌표를 넣어준다.
                visit[i][j] = true;     // 방문처리!
                area = 0;    // 0이면 그림이 끊겼으므로 area = 0!
                while(!qu.isEmpty()){
                    int[] p = qu.poll();
                    area++; // 넓이 +1
                    for(int k = 0; k < 4; k++){
                        int n_x = p[0] + dx[k];
                        int n_y = p[1] + dy[k];
                        if(n_x < 0 || n_x >= n || n_y < 0 || n_y >= m){
                            continue;
                        }
                        if(arr[n_x][n_y] == 1 && !visit[n_x][n_y]){
                            qu.offer(new int[]{n_x, n_y});
                            visit[n_x][n_y] = true;
                        }
                    }
                }
                if(area > max){
                    max = area;
                }
            }
            
        }
        System.out.println(count);
        System.out.println(max);
    }
}