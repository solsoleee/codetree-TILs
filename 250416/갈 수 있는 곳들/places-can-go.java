import java.util.*;

public class Main {
    static int n;
    static int k;
    static int [][] grid;
    static int [][] starts;
    static int cnt;
    static boolean visited[][];
    static int [][] deltas = {{1,0},{0,1},{-1,0},{0,-1}};
    
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();
        grid = new int[n][n];
        visited = new boolean[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                grid[i][j] = sc.nextInt();
        starts = new int[k][2];
        for (int i = 0; i < k; i++) {
            starts[i][0] = sc.nextInt();
            starts[i][1] = sc.nextInt();
        }
        // Please write your code here.
        cnt =0;
        for(int i=0; i<k; i++) {
            int sx = starts[i][0] -1;
            int sy = starts[i][1] -1;
            if(!visited[sx][sy]) {
                cnt ++; //시작점 포함
                bfs(sx, sy);
            }
            
        }
        System.out.println(cnt);

    }
    
    static boolean check(int x, int y) {
        return x>=0 && x<n && y>=0 && y<n;
    }
    static void bfs(int x, int y) {
        Queue<int []> que = new ArrayDeque<>();
        que.offer(new int[] {x,y});
        visited[x][y] = true;
        while(!que.isEmpty()) {
            int t[] = new int[2];
            t = que.poll();
            int dx = t[0];
            int dy = t[1];
            for(int d[] : deltas) {
                int nx = d[0] + dx;
                int ny = d[1] + dy;
                if(check(nx, ny) && !visited[nx][ny]) {
                    if(grid[nx][ny]==0) {
                        visited[nx][ny] = true;
                        cnt++;
                        que.offer(new int[]{nx, ny});
                    }
                }
            }
            
        }
        
    }
}