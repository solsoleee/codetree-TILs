import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static StringTokenizer tokens;
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static int n,m,res;
    static int maxVal = Integer.MIN_VALUE;
    static int board[][];
    static boolean visited[][];
    static int deltas[][] = {{1,0},{0,1},{-1,0},{0,-1}};

    public static void main(String[] args) throws IOException {

        n = Integer.parseInt(input.readLine());
        board = new int[n][n];
        visited = new boolean[n][n];

        for(int i=0; i<n; i++) {
            tokens = new StringTokenizer(input.readLine());
            for(int j=0; j<n; j++) {
                board[i][j] = Integer.parseInt(tokens.nextToken());
            }
        }
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                if(!visited[i][j]) {
                    int v = dfs(i,j,board[i][j]);

                    if(v>=4) {
                        res++; //터진 개수
                        maxVal = Math.max(maxVal, v);
                    }
                }
            }
        }
        if(maxVal == Integer.MIN_VALUE) maxVal = 0;
        System.out.println(res +" " + maxVal);
    }
    static int dfs(int x, int y, int val) {

        visited[x][y] = true;
        int size=1;

        for(int d[] : deltas) {
            int nx = x+d[0];
            int ny = y+d[1];
            if(nx >=0 && nx<n && ny>=0 && ny<n) {
                if(val == board[nx][ny] && !visited[nx][ny]) {

                    size += dfs(nx, ny, board[nx][ny]);
                }
            }
        }
        return size;
    }

}