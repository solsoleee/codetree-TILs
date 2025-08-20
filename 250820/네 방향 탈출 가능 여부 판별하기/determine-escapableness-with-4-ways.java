import java.util.*;
public class Main {
    static int n;
    static int m;
    static int[][] grid;
    static int[][] deltas = {{0,1},{1,0}, {-1,0}, {0,-1}};
    static boolean visited[][];
    static int flag;
        public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        grid = new int[n][m];
        visited = new boolean[n][m];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                grid[i][j] = sc.nextInt();
        // Please write your code here.
        bfs(0,0);
        System.out.println(flag);
    }
    static boolean check(int x, int y) {
        return x>=0 && x<n && y>=0 && y<m;
    }
    static void bfs(int x, int y ) {
        visited[x][y] = true; //방문
        Queue<int[]> que = new ArrayDeque<>();
        que.offer(new int[]{x,y});
        while(!que.isEmpty()) {
            int t[] = que.poll();
            int dx = t[0];
            int dy = t[1];
            if(dx == n-1 && dy == m-1) {
                flag = 1;
                break;
            }
            for(int d[]:deltas) {
                int nx = dx + d[0];
                int ny = dy + d[1];
                if(check(nx, ny) && !visited[nx][ny]) {
                    if(grid[nx][ny] == 1) {
                        que.offer(new int[]{nx,ny});
                        visited[nx][ny] = true;
                        //System.out.println(nx +" " +ny);
                    }
                }
            }
        }
    }

}