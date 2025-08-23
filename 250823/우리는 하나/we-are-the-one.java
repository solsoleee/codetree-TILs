import java.util.*;
public class Main {
    static int n;
    static int k;
    static int u;
    static int d;
    static int [][] grid;
    static int [][] deltas = {{0,1}, {1,0}, {-1,0}, {0,-1}};
    static boolean [][] visited;
    static int [] res;
    static int maxVal = 1;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();
        u = sc.nextInt();
        d = sc.nextInt();
        grid = new int[n][n];
        res = new int[n]; //k를 골라
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = sc.nextInt();
            }
        }
        //적절하게 골라서 반복,
        //visited = new boolean[n][n];

        //bfs(1,1);
        //System.out.println(count());
        combi(0,0);
        System.out.println(maxVal);
    }

    static void combi(int start, int depth) {
        if(depth == k) {
            //res에 들어있음
            visited = new boolean[n][n];
            for(int i=0; i<k; i++) {
                //System.out.print(res[i] +" ");
                // 7,8선택
                int x = res[i]/n;
                int y = res[i]%n;
                bfs(x,y);
            }
            
            maxVal=Math.max(maxVal, count());
            return;
        }
        for(int i=start; i<n*n; i++) {
            res[depth] = i;
            combi(i+1, depth+1);
        }
    }

    static boolean check(int x, int y) {
        return x>=0 && x<n && y>=0 && y<n;
    }

    //개수 세기
    static int count() {
        int cnt =0;
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                if(visited[i][j]) cnt++;
            }
        }
        return cnt;
    }


    static void bfs(int x, int y) {
        Queue<int []> que = new ArrayDeque<>();
        que.offer(new int [] {x,y});
        visited[x][y] = true;
        while(!que.isEmpty()) {
            int t[] = que.poll();
            int dx = t[0];
            int dy = t[1];
            for(int del[]: deltas) {
                int nx = dx + del[0];
                int ny = dy + del[1];
                if(check(nx,ny) && !visited[nx][ny]) {
                int num = Math.abs (grid[nx][ny] - grid[dx][dy]);
                if(num >= u && d>=num) {
                    que.offer(new int[] {nx,ny});
                    visited[nx][ny] = true;
                }
            }
            }
            

        }
    }
}