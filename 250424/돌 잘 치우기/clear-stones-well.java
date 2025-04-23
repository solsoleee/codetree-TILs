import java.util.*;
public class Main {
    static int n,k,m;
    static int [][] grid;
    static int [][] startPoints;
    static int [][] copyGrid;
    static int [][] deltas = {{0,1},{1,0},{0,-1},{-1,0}};
    static boolean visited [][];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();
        m = sc.nextInt();
        grid = new int[n][n];
        copyGrid = new int[n][n];
        visited = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = sc.nextInt();
            }
        }
        
        //System.out.println(Arrays.deepToString(copyGrid));
        startPoints = new int[k][2];
        for (int i = 0; i < k; i++) {
            startPoints[i][0] = sc.nextInt()-1;
            startPoints[i][1] = sc.nextInt()-1;
        }
        int maxVal = Integer.MIN_VALUE;
        for(int s[]: startPoints) {
            int res = bfs(s[0],s[1], m);
            maxVal = Math.max(maxVal, res);
        }
        System.out.println(maxVal);
        
        // Please write your code here.
    }
    //초기화 함수
    static void init() {
        for(int i=0; i<n; i++) {
            copyGrid[i] = Arrays.copyOf(grid[i],n);
            Arrays.fill(visited[i], false);
        }
    }
    static boolean check(int x, int y) {
        return x>=0 && x<n && y>=0 && y<n;
    }
    static int bfs(int x, int y, int c) {
        init();
        int mCount = c;
        Queue<int []> que = new ArrayDeque<>();
        que.offer(new int [] {x,y});
        visited[x][y] = true;
        int cnt = 1;
        while(!que.isEmpty()) {
            int t[] = que.poll();
            int dx = t[0];
            int dy = t[1];
            for(int d[]: deltas) {
                int nx = dx+d[0];
                int ny = dy+d[1];
                if(check(nx,ny) && !visited[nx][ny]) {
                    //돌이 아니고,
                    if(copyGrid[nx][ny]==0) {
                        que.offer(new int[]{nx,ny});
                        visited[nx][ny] = true;
                        cnt++;
                    }
                    else{ //돌일 때, m이 남아 있으면..
                        if(mCount > 0) {
                            copyGrid[nx][ny] =0;
                            mCount--;
                            que.offer(new int[]{nx,ny});
                            visited[nx][ny] = true;
                            cnt++;
                        }
                    }
                }

            }
            

        }
        return cnt;
    }
}