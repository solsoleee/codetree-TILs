import java.io.*;
import java.util.*;
public class Main {
    static StringTokenizer tokens;
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static int n,res,sum;
    static int maxVal = Integer.MIN_VALUE;
    static int map[][];
    static boolean visited[][];
    static int deltas[][] ={{0,1}, {1,0}, {-1,0}, {0,-1}};
    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(input.readLine());
        map = new int [n][n];
        visited = new boolean[n][n];

        for(int i=0; i<n; i++) {
            tokens = new StringTokenizer(input.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(tokens.nextToken());
            }
        }
        // 한 점씩 돌아가면서 찾기
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                if(!visited[i][j]) {
                    sum=1;
                    dfs(i,j);
                    if(sum >=4) res++;
                    maxVal = Math.max(sum, maxVal);
                }
            }
        }
        System.out.println(res +" " +maxVal);

    }
    static void dfs(int x, int y) {
        visited[x][y] =true;
        for(int d[]: deltas) {
            int nx = x+d[0];
            int ny = y+d[1];
            if(check(nx,ny) && !visited[nx][ny]) { //같은 숫자로 이루어져야함
                if(map[x][y] == map[nx][ny]) {
                    sum++;
                    dfs(nx,ny);
                }
            }
        }
    }
    static boolean check(int x, int y) {
        return x>=0 && x<n && y>=0 && y<n;
    }
}