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
    static int n,k;
    static int map[][];
    static int visited[][];
    static int deltas[][] = {{1,0}, {0,1}, {-1,0}, {0,-1}};
    static Queue<int[]> que;
    public static void main(String[] args) throws IOException {
        tokens = new StringTokenizer(input.readLine());
        n = Integer.parseInt(tokens.nextToken());
        k = Integer.parseInt(tokens.nextToken());
        que = new ArrayDeque<>();
        map = new int [n][n];
        visited = new int [n][n];
        for(int i=0; i<n; i++) {
            tokens = new StringTokenizer(input.readLine());
            for(int j=0; j<n; j++) {
                map[i][j] = Integer.parseInt(tokens.nextToken());
                if(map[i][j] == 2) {
                    que.offer(new int [] {i,j});
                    visited[i][j] = 3;
                } else if (map[i][j]==0) {
                    visited[i][j] = -1;
                }
            }
        }
        bfs();
        //3이면 0으로 바꾸고 0이면 -2로 바꾸기
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                if (visited[i][j] == 3) System.out.print(0 + " ");
                else if (visited[i][j] == 0) System.out.print(-2 +" ");
                else System.out.print(visited[i][j] +" ");
            }
            System.out.println();
        }
    }
    static void bfs() {

        while(!que.isEmpty()) {
            int t[] = que.poll();
            int x = t[0];
            int y = t[1];
            for(int d[]: deltas) {
                int nx = x+d[0];
                int ny = y+d[1];
                if(check(nx, ny) && map[nx][ny]==1) {
                    if(map[x][y] ==2) {
                        visited[nx][ny] +=1;
                    }
                    else {
                        visited[nx][ny] = visited[x][y]+1;
                    }
                    map[nx][ny]=-3;
                    que.offer(new int[] {nx,ny});
                }
            }
        }
    }
    static boolean check(int x, int y) {
        return x>=0 && x<n && y>=0 && y<n;
    }
}