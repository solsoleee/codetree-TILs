import java.util.Scanner;
public class Main {
    static int n;
    static int max;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        max = 0;
        n = sc.nextInt();
        int[][] grid = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = sc.nextInt();
            }
        }
        // Please write your code here.
        
        for(int i=0; i<=n-3; i++) {
            for(int j=0; j<=n-3; j++) {
                int count = 0;
                for(int a=0; a<3; a++) {
                    for(int b=0; b<3; b++) {
                        if(grid[a+i][b+j] == 1) {
                            count ++;
                        }
                    }
                }
                if(max < count) {
                    max = count;
                }

            }
        }
        System.out.println(max);
    }
}