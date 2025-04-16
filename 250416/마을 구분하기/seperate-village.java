import java.util.*;

public class Main {
    static int n;
    static int [][] grid;
    static boolean [][] visited;
    static List<Integer>res;
    //상하좌우
    static int[][] deltas = {{-1,0},{1,0},{0,-1},{0,1}};
    static int cnt;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        grid = new int[n][n];
        visited = new boolean[n][n];
        res = new ArrayList<Integer>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = sc.nextInt();
            }       
        }
        int ans=0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(!visited[i][j] && grid[i][j] == 1) {
                    cnt = 1;
                    dfs(i,j);
                    res.add(cnt);
                    ans++;
                }
                
            }       
        }
        System.out.println(ans);
        Collections.sort(res);
        for(int i=0; i<ans; i++) {
            System.out.println(res.get(i));
        }
        
                
        // Please write your code here.
    }
    static void dfs(int x, int y) {
        //출발지 [x][y]
        visited[x][y] = true;
 
                
                for(int d[]: deltas) {
                    int nx = x+d[0];
                    int ny = y+d[1];
                    if(nx >=0 && nx<n && ny>=0 && ny<n) {
                        if(!visited[nx][ny] && grid[nx][ny] == 1) {
                            visited[nx][ny] = true; //방문
                            cnt++;
                            x = nx;
                            y = ny;
                            dfs(nx, ny);

                        }


            }
        }



    }
}