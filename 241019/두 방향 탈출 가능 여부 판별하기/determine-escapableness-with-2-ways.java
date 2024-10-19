import java.util.*;
import java.io.*;

public class Main {
    static StringTokenizer tokens;
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static int deltas[][] = {{1,0},{0,1}};
    static int n,m;
    static int[][] map;
    static boolean [][] visited;
    static boolean flag;
    public static void main(String[] args) throws IOException{
        //(0,0)에서 (n-1, m-1)까지 갈 수 있는지 여부
        tokens = new StringTokenizer(input.readLine());
        n = Integer.parseInt(tokens.nextToken());;
        m = Integer.parseInt(tokens.nextToken());
        map = new int [n][m];
        visited = new boolean[n][m];
        flag = false;
        for(int i=0; i<n; i++) {
            tokens = new StringTokenizer(input.readLine());
            for(int j=0; j<m; j++) {
                map[i][j] = Integer.parseInt(tokens.nextToken());
            }
        }
        bfs(0,0);
        //뱀이 없는 경우 1, 뱀이 있는 경우 0
        if(flag) System.out.print(1);
        else System.out.print(0);
    }


    static void bfs(int x, int y) {
        if(x == n-1 && y == m-1) {
            flag = true;
            return;
        }
        //System.out.println(x +" " + y);
        visited[x][y] = true;
        for(int d[]: deltas) {
            int nx = x+d[0];
            int ny = y+d[1];
            if(check(nx,ny) && !visited[nx][ny] && map[nx][ny]==1) {
                bfs(nx,ny);
            }
        }


    }
    static boolean check(int x, int y) {
        return x>=0 && x<n && y>=0 && y<m;
    }
}