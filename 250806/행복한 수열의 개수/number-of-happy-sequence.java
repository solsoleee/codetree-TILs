import java.util.Scanner;
  
public class Main {
    static int n;
    static int m;
    static int grid[][];
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        
        n = sc.nextInt();
        m = sc.nextInt();
        grid = new int[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                grid[i][j] = sc.nextInt();
        
        // Please write your code here.
        int r = garo()+sero();

            System.out.println(r);

        
    }
    //세로 검색하는 로직
static int sero() {
    int res = 0;
    for(int i = 0; i < n; i++) {
        int cnt = 1;
        for(int j = 1; j < n; j++) {
            if(grid[j][i] == grid[j-1][i]) {
                cnt++;
            } else {
                cnt = 1;
            }
            if(cnt >= m) {
                res++;
                break;
            }
        }
    }
    return res;
}

static int garo() {
    int res = 0;
    for(int i = 0; i < n; i++) {
        int cnt = 1;
        for(int j = 1; j < n; j++) {
            if(grid[i][j] == grid[i][j-1]) {
                cnt++;
            } else {
                cnt = 1;
            }
            if(cnt >= m) {
                res++;
                break;
            }
        }
    }
    return res;
}


}