import java.util.*;
public class Main {
    static int n,r1,c1,r2,c2;
    static int[][] grid;
    static int[][] deltas = {{-2,-1}, {-1,-2}, {-2,1},{-1,2},{1,-2},{2,-1},{2,1},{1,2}};
    static boolean[][] visited;
    static int ans;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        r1 = sc.nextInt();
        c1 = sc.nextInt();
        r2 = sc.nextInt();
        c2 = sc.nextInt();
        ans = -1;
        // Please write your code here.
        grid = new int[n][n];
        visited = new boolean[n][n];
        bfs(r1-1, c1-1);
        System.out.println(ans);
        
    }
    static boolean check(int x, int y) {
        return x>=0 && x<n && y>=0 && y<n;
    }
    static void bfs(int x, int y) {

        Queue<int[]> que = new ArrayDeque<>();
        que.offer(new int[] {x,y,0});
        visited[x][y] = true;
        while(!que.isEmpty()) {
            int temp[] = que.poll();
            int dx = temp[0];
            int dy = temp[1];
            int diff = temp[2];
            if(dx == r2-1 && dy == c2-1) {
                    ans = diff;
                    break;
            }

            for(int d[]:deltas) {
                int nx = d[0] + dx;
                int ny = d[1] + dy;
                if(check(nx,ny) && !visited[nx][ny]) {

                    que.offer(new int[] {nx,ny,diff+1});
                }
            }
        }
    }
}