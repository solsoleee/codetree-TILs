import java.util.Scanner;
import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] grid = new int[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                grid[i][j] = sc.nextInt();
        
        // Please write your code here.

        int ans = 0;
        //행 세기
        for(int i=0; i<n; i++) {
            int cnt =1;
            int maxVal = 1;
            for(int j=1; j<n; j++ ) {
                if(grid[i][j] == grid[i][j-1]) {
                    cnt ++;
                }
                else cnt = 1;
                maxVal = Math.max(cnt, maxVal);
            }
            if(maxVal >=m ) ans ++;
        }
        for(int i=0; i<n; i++) {
            int cnt =1;
            int maxVal = 1;
            for(int j=1; j<n; j++ ) {
                if(grid[j][i] == grid[j-1][i]) {
                    cnt ++;
                }
                else cnt = 1;
                maxVal = Math.max(cnt, maxVal);
            }
            if(maxVal >=m ) ans ++;
        }
        System.out.println(ans);
    }
}