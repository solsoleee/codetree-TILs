import java.util.Scanner;
  
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] grid = new int[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                grid[i][j] = sc.nextInt();
        
        int answer = 0;
        
        // 행 탐색
        for (int i = 0; i < n; i++) {
            int count = 1;
            boolean found = false; // 한 행에서 하나만 세기
            for (int j = 1; j < n; j++) {
                if (grid[i][j] == grid[i][j-1]) {
                    count++;
                } else {
                    count = 1;
                }
                
                if (count >= m && !found) {
                    answer++;
                    found = true;
                }
            }
        }
        
        // 열 탐색
        for (int i = 0; i < n; i++) {
            int count = 1;
            boolean found = false;
            for (int j = 1; j < n; j++) {
                if (grid[j][i] == grid[j-1][i]) {
                    count++;
                } else {
                    count = 1;
                }
                
                if (count >= m && !found) {
                    answer++;
                    found = true;
                }
            }
        }
        
        System.out.println(answer);
    }
}
