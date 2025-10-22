import java.util.*;
public class Main {
    static int n;
    static int m;
    static int [][] grid;
    static boolean [][] visited;
    static int[][] deltas = {{0,1},{1,0},{-1,0},{0,-1}};
    static int maxK = Integer.MIN_VALUE;
    static int answer = Integer.MIN_VALUE;
    static int answerK;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        grid = new int[n][m];
        visited = new boolean[n][m];
        
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                grid[i][j] = sc.nextInt();
                maxK = Math.max(maxK, grid[i][j]);
            }       
        }
            
        // Please write your code here.
        
        for(int k=1; k<maxK; k++) {
            //방문초기화
            visited = new boolean[n][m];
            int cnt=0;
            for(int i=0; i<n; i++) {
                for(int j=0; j<m; j++) {
                    if(!visited[i][j] && grid[i][j] > k ) {
                        dfs(i,j,k); 
                        cnt++;
                    }
                }
            }
            if(answer <= cnt) {
                answer = cnt;
                answerK = k;
            }
            

        }

        System.out.println(answer +" " + answerK);
    }

    

    //안전영역 구하기
    static void dfs(int x, int y, int h) {
        visited[x][y] = true;
        
        for(int i=0; i<4; i++) {
            int nx = x + deltas[i][0];
            int ny = y + deltas[i][1];
            if(check(nx, ny)) {
                if(!visited[nx][ny] && grid[nx][ny] > h) {
                    // System.out.println(x +" " +y +" "+nx +" " +ny);
                    visited[nx][ny] = true;
                    dfs(nx,ny,h);
                
                }
            }
        }
    }
    static boolean check(int x, int y) {
        return x>=0 && x<n && y>=0 && y<m;
    }
}