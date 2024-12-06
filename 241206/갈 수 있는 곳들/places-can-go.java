import java.util.*;
import java.io.*;

public class Main {
    static StringTokenizer tokens;
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static int [][] map;
    static int n,k;
    static int [][] location;
    static boolean [][] visited;
    static int[][] deltas = {{0,1},{1,0},{-1,0},{0,-1}};
    public static void main(String[] args) throws IOException{
        // 여기에 코드를 작성해주세요.
        tokens = new StringTokenizer(input.readLine());
        n = Integer.parseInt(tokens.nextToken());
        k = Integer.parseInt(tokens.nextToken());
        map = new int[n][n];
        location = new int[k][2];
        visited = new boolean[n][n];
        for(int i=0; i<n; i++) {
            tokens = new StringTokenizer(input.readLine());
            for(int j=0; j<n; j++) {
                map[i][j] = Integer.parseInt(tokens.nextToken());
            }
        }
        for(int i=0; i<k; i++) {
            tokens = new StringTokenizer(input.readLine());
            for(int j=0; j<2; j++) {
                location[i][j] = Integer.parseInt(tokens.nextToken());
            }
        }
        int res = 0;
        //시작점부터
        for(int i=0; i<k; i++) {
            int r = location[i][0]-1;
            int c = location[i][1]-1;
            if(!visited[r][c]) {
                res += bfs(r,c);
            }
        }
        System.out.println(res);
    }
    static int bfs(int x, int y){
        Queue<int[]> que = new ArrayDeque<>();
        que.offer(new int[]{x,y});
        visited[x][y] = true;
        int cnt = 1;
        while(!que.isEmpty()) {
            int t[] = que.poll();
            int nx = t[0];
            int ny = t[1];
            //상하좌우
            for(int d[]: deltas) {
                int dx = d[0] + nx;
                int dy = d[1] + ny;
                if(check(dx, dy) && !visited[dx][dy] && map[dx][dy] == 0) {
                    que.offer(new int [] {dx,dy});
                    visited[dx][dy] = true;
                    cnt++;
                }
            }
        }
        return cnt;
    }
    static boolean check(int x, int y) {
        return (x>=0 && x<n && y>=0 && y<n);
    }
}