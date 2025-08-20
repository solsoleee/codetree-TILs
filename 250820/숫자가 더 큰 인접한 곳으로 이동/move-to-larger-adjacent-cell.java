import java.util.*;
public class Main {
    static int n;
    static int r;
    static int c;
    static int [][] grid;
    static List<Integer> list = new ArrayList<>();
    static int[][] delats = {{1,0},{0,1},{-1,0},{0,-1}};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        r = sc.nextInt();
        c = sc.nextInt();
        grid = new int[n+1][n+1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                grid[i][j] = sc.nextInt();
            }
        }
        
        int x = r;
        int y = c;
        list.add(grid[x][y]);
        // Please write your code here.
        
        while(true) {
            //상하좌우 탐색
            boolean flag = false;
            int num = grid[x][y]; //현재 위치
            int max = num;
            for(int d[]:delats) { //가장 큰 수 찾기
                int nx = x + d[0];
                int ny = y + d[1];
                if(check(nx, ny)) { //범위 만족하고
                    if(num < grid[nx][ny]) { //현재값보다 크고
                        max = grid[nx][ny]; //갱신
                        x = nx;
                        y = ny;
                        flag = true;
                        list.add(grid[nx][ny]);
                        break;
                    }
                } 
            }
            if(!flag) break;
        }
        //System.out.println(list);
        for(int l: list) {
            System.out.print(l +" ");
        }
    }
    static boolean check(int x, int y) { 
        return x>=0 && x<n && y>=0 && y<n;
    }
}