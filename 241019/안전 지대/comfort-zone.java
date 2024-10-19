import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static StringTokenizer tokens;

    static boolean visited[][];
    static int deltas[][] ={{0,1}, {1,0},{-1,0},{0,-1}};
    static int n,m;
    static int maxVal = Integer.MIN_VALUE;
    static int min= Integer.MAX_VALUE;
    static int max = Integer.MIN_VALUE;
    static int map[][];
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        tokens = new StringTokenizer(input.readLine());
        n = Integer.parseInt(tokens.nextToken());
        m = Integer.parseInt(tokens.nextToken());
        map = new int[n][m];

        //k의 최소, 최대
        for (int i = 0; i < n; i++) {
            tokens = new StringTokenizer(input.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(tokens.nextToken());
                max = Math.max(max, map[i][j]);
                min = Math.min(min, map[i][j]);
            }
        }

        int res = Integer.MAX_VALUE; //그때의 k값
        for (int k = min; k <= max; k++) {

            //안전하지 않은 집이면 0으로 바꿈
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (map[i][j] <= k) {
                        map[i][j] = 0;
                    }
                }
            }
            //dfs..
            int home = 0;
            visited = new boolean[n][m];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (map[i][j] != 0 && !visited[i][j]) {
                        dfs(i, j);
                        home++; //집이 몇개인지
                    }
                }
            }

            if(maxVal < home) {
                maxVal = home;
                res = k;
            }
        }


            System.out.print(res +" " + maxVal);
        }

    //0이 아닌 것중 그룹을 구하면 됨
    static void dfs(int x, int y) {
        visited[x][y] = true;
        for(int d[]:deltas) {
            int nx = x+d[0];
            int ny = y+d[1];
            if(check(nx,ny) && map[nx][ny]!=0 && !visited[nx][ny]) {
                dfs(nx,ny);
            }
        }
    }



    static boolean check(int x, int y) {
        return x>=0 && x<n && y>=0 && y<m;
    }
}