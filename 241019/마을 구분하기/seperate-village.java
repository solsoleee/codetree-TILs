import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static StringTokenizer tokens;

    static boolean visited[][];
    static int deltas[][] ={{0,1}, {1,0},{-1,0},{0,-1}};
    static int n,sum;
    static int map[][];
    static List<Integer> list = new ArrayList<>();
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
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
        int res = 0;
        for(int i=0; i<n; i++) {
            for (int j = 0; j < n; j++) {
                if(map[i][j] == 1 &&!visited[i][j]) {
                    sum=1;
                    int c = dfs(i,j);
                    res++; //총 개수
                    list.add(c);
                }
            }
        }
        Collections.sort(list);
        System.out.println(res);
        for(int l:list){
            System.out.println(l);
        }
    }
    static int  dfs(int x, int y) {
        //벽 0, 사람 1
        visited[x][y] = true;
        for(int d[]:deltas) {
            int nx = x+d[0];
            int ny = y+d[1];
            if(check(nx,ny) && !visited[nx][ny] && map[nx][ny]==1) {
                sum ++;
                dfs(nx,ny);
            }
        }
        return sum;
    }
    static boolean check(int x, int y) {
        return x>=0 && x<n && y>=0 && y<n;
    }
}