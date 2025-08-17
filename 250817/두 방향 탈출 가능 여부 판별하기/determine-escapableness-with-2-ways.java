import java.util.Scanner;
public class Main {
    static int n;
    static int m;
    static int grid [][];
    static boolean visited[][];
    //아래 오른쪽
    static int deltas[][] = {{0,1},{1,0}};
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
        visited[0][0] = true;
        dfs(0,0);
        
        System.out.println(flag);
    }
    static void dfs(int x, int y){
        if(x == n-1 && y == m-1) {
            flag = 1;
            return;
        }  
        
        for(int d[]:deltas) {
            int dx = x + d[0];
            int dy = y + d[1];
            if(check(dx,dy) && !visited[dx][dy]) {
                if(grid[dx][dy] == 1){ //뱀이 없는 경우
                    visited[x][y] = true; //방문
                    dfs(dx, dy);
                }
            }
        }

    }
    static boolean check(int x, int y){
        return x>=0 && x<n && y>=0 && y<m;
    }
}