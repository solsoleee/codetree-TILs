import java.util.*;

public class Main {
    static int n;
    static int [][] grid;
    static boolean visited[][];
    static int deltas[][] = {{1,0},{-1,0},{0,1},{0,-1}};
    static int cnt;
    static int total;
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        grid = new int[n][n];
        visited = new boolean [n][n];
        total = 0;
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                grid[i][j] = sc.nextInt();

        int ans =0;
        // Please write your code here.
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(!visited[i][j]) {
                    cnt = 0;
                    dfs(i, j);
                    if(cnt >=4) total ++;
                    ans = Math.max(cnt, ans);
                }
            }
        }
        System.out.println(total +" " ans);
        //System.out.println(ans);
    }

    static boolean check(int x, int y) {
        return x>=0 && x<n && y>=0 && y<n;
    }
    static void dfs(int x, int y) {
        visited[x][y] = true; //방문
        cnt ++; //1개 방문
        for(int d[]: deltas) {
            int nx = x + d[0];
            int ny = y + d[1];
            //범위, 방문 X, 같은 숫자
            if(check(nx,ny) && !visited[nx][ny]) {
                if(grid[x][y] == grid[nx][ny]) {
                    visited[nx][ny] = true;
                    dfs(nx,ny);

                }
            }
        }
        
    }
}