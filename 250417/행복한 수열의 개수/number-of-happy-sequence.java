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
        // 행 검사 m개 이상 나오는지
        int count = 1;
        int res = 0; //답
        for(int i=0; i<n; i++) {
            count =1;
            for(int j=1; j<n; j++) {
                if(grid[i][j] == grid[i][j-1]) {
                    count ++;
                    if(count >= m) {
                        res ++;
                        break; //해당 행은 이미 만족 해서 확인할 필요 X
                    }
                }
                else {
                    if(count >= m) {
                        res ++;
                        break; //해당 행은 이미 만족 해서 확인할 필요 X
                    }
                    count =1; //같지 않아서 초기화
                }
            }
        }

        for(int i=0; i<n; i++) {
            count =1;
            for(int j=1; j<n; j++) {
                if(grid[j][i] == grid[j-1][i]) {
                    count ++;
                    if(count >= m) {
                        res ++;
                        break; //해당 행은 이미 만족 해서 확인할 필요 X
                    }
                }
                else {
                    if(count >= m) {
                        res ++;
                        break; //해당 행은 이미 만족 해서 확인할 필요 X
                    }
                    count =1; //같지 않아서 초기화
                }
            }
        }
        if(n == 1) {
            System.out.println(2);
        }
        else{
            System.out.println(res);
        }
        



    }



}