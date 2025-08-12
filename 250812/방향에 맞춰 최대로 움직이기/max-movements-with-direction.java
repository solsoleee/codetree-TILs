import java.util.Scanner;

public class Main {
    public static final int DIR_NUM = 8;
    public static final int MAX_N = 4;
    
    public static int n;
    public static int[][] num = new int[MAX_N][MAX_N];
    public static int[][] moveDir = new int[MAX_N][MAX_N];
    public static int ans;
    
    public static boolean inRange(int x, int y) {
        return 0 <= x && x < n && 0 <= y && y < n;
    }
    
    public static boolean canGo(int x, int y, int prevNum) {
        return inRange(x, y) && num[x][y] > prevNum;
    }
    
    public static void findMax(int x, int y, int cnt) {
        // 언제 끝날지 모르기 때문에
        // 항상 최댓값을 갱신해줍니다.
        ans = Math.max(ans, cnt);
        
        int[] dx = new int[]{-1, -1, 0, 1, 1, 1, 0, -1};
        int[] dy = new int[]{0, 1, 1, 1, 0, -1, -1, -1};
        int d = moveDir[x][y] - 1;
        
        for(int i = 1; i < n; i++) {
            int nx = x + dx[d] * i, ny = y + dy[d] * i;
            if(canGo(nx, ny, num[x][y]))
                findMax(nx, ny, cnt + 1);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        
        for(int i = 0; i < n; i++)
            for(int j = 0; j < n; j++)
                num[i][j] = sc.nextInt();
        
        for(int i = 0; i < n; i++)
            for(int j = 0; j < n; j++)
                moveDir[i][j] = sc.nextInt();
        
        int r = sc.nextInt();
        int c = sc.nextInt();
        
        findMax(r - 1, c - 1, 0);
        System.out.print(ans);
    }
}
