import java.util.*;
public class Main {
    static int n;
    static int[][] grid;
    static int idx;
    static int [] arr;
    static int [] res;
    static int maxValue = Integer.MIN_VALUE;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        grid = new int[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                grid[i][j] = sc.nextInt();
        // Please write your code here.
        idx = n*n; //총 수
        res = new int[n];
        arr = new int[idx];
        for(int i=0; i<idx; i++) {
            arr[i] = i;
        }
        combi(0,0);
        System.out.println(maxValue);

    }
    static void combi(int start, int depth){
        if(depth == n) {

            boolean flag = true;
            for(int i=0; i<n; i++) {
                int r1 = res[i]/n;
                int c1 = res[i]%n;
                for(int j=i+1; j<n; j++) {
                    int r2 = res[j]/n;
                    int c2 = res[j]%n;
                    if(r1 == r2 || c1 == c2) {
                        flag = false;
                        break;
                    }
                }
            }
            // 선택된 n개중에 가장 큰 값
            int ans =0;

            if(flag) {
                //System.out.println(Arrays.toString(res));
                for(int i=0; i<n; i++) {
                    //각 행과 열에 정확히 1개의 칸.......
                    int r = res[i]/n;
                    int c = res[i]%n;
                    ans += grid[r][c];
                }
            }

            maxValue = Math.max(ans, maxValue);
            
            return;
        }
        for(int i=start; i<idx; i++) {
            
            res[depth] = arr[i];
            
            combi(i+1, depth+1);
        }
    }
}