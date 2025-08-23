import java.util.*;

public class Main {
    static int n;
    static int k;
    static int [][] grid;
    static Queue<int[]> que;
    static int[][] deltas = {{0,1}, {1,0}, {-1,0}, {0,-1}};
    static boolean[][] visited;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        que = new ArrayDeque<>();
        n = sc.nextInt();
        k = sc.nextInt();
        grid = new int[n][n];
        visited = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = sc.nextInt();
                if(grid[i][j] == 2) { //상한 귤 넣음
                    que.offer(new int [] {i,j,0});
                    grid[i][j] = -3; //임시로 상한 귤, 나중에 0으로 변경
                    visited[i][j] = true;
                    
                }
                else if(grid[i][j] == 0) grid[i][j] = -1;
            }  
        }
        bfs();
        //System.out.println(Arrays.deepToString(grid));
                
        // Please write your code here.
        //1은 -2로
        //-3은 0으로
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                if(grid[i][j] ==1 &&!visited[i][j]) {
                    System.out.print(-2 +" ");
                }
                else if(grid[i][j] == -3) {
                    System.out.print(0 +" ");
                }
                else
                    System.out.print(grid[i][j] +" ");
            }
            System.out.println();
        }
        
    }

    static void bfs() {
        //int time = 0;
        while(!que.isEmpty()) {
            int t [] = que.poll();
            int dx = t[0];
            int dy = t[1];
            int time = t[2]; //현재 시간
            
            for(int d[]: deltas) {
                int nx = dx + d[0];
                int ny = dy + d[1];
                if(in(nx, ny) && !visited[nx][ny]) {
                    if(grid[nx][ny] == 1) {
                        //time ++;
                        grid[nx][ny] = time+1;
                        visited[nx][ny] = true;
                        que.offer(new int [] {nx,ny,time+1});
                    }
                }
                
            }
        }
    }

    static boolean in(int x, int y) {
        return x>=0 && x<n && y>=0 && y<n;
    }
}