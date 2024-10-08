import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static StringTokenizer tokens;
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder output = new StringBuilder();
    static int n,k,u,d;
    static int maxVal = Integer.MIN_VALUE;
    static int map[][];
    static boolean visited[][];
    static int res[][];
    static boolean visited2[][];
    static int deltas[][] = {{1,0}, {0,1}, {-1,0}, {0,-1}};
    public static void main(String[] args) throws IOException {
        tokens = new StringTokenizer(input.readLine());
        n = Integer.parseInt(tokens.nextToken());
        k = Integer.parseInt(tokens.nextToken());
        u = Integer.parseInt(tokens.nextToken());
        d = Integer.parseInt(tokens.nextToken());

        map = new int[n][n];

        visited2 = new boolean[n][n];
        res = new int[k][2];
        for(int i=0; i<n; i++) {
            tokens = new StringTokenizer(input.readLine());
            for(int j=0; j<n; j++) {
                map[i][j] = Integer.parseInt(tokens.nextToken());
            }
        }
        permutation(0,0);
        System.out.println(maxVal);
    }

    //k만큼 선정하기
    static void permutation(int start, int cnt) {
        if(cnt == k) {
            //res에 k만큼 저장해둠
            visited = new boolean[n][n];
            //한세트
            int val = 0;
            for(int r[]: res) {
                val += bfs(r[0], r[1]);
                maxVal = Math.max(val, maxVal);
            }
            return;
        }
        for(int i=start; i<n*n; i++) {
            int row = i/n;
            int col = i%n;
            if(!visited2[row][col]){
                visited2[row][col] = true;
                res[cnt][0] = row;
                res[cnt][1] = col;
                permutation(i+1, cnt+1);
                visited2[row][col] = false;
            }

        }
    }
    static int bfs(int x, int y) {
        int c=1;
        Queue<int[]> que =new ArrayDeque<>();
        que.offer(new int[] {x,y});
        visited[x][y] = true;
        while(!que.isEmpty()) {
            int t[] = que.poll();
            int dx = t[0];
            int dy = t[1];
            for(int d[]: deltas) {
                int nx = dx+d[0];
                int ny = dy+d[1];
                if(check(nx, ny) && !visited[nx][ny]) {
                    //높이차이 체크
                    if(height(map[dx][dy], map[nx][ny])) {
                        que.offer(new int[] {nx,ny});
                        visited[nx][ny]=true;
                        c++;
                    }
                }
            }
        }
        return c;
    }
    static boolean height(int a, int b) {
        return Math.abs(a-b) >=u  && Math.abs(a-b) <=d;
    }
    static boolean check(int x, int y) {
        return x>=0 && x<n && y>=0 && y<n;
    }

}