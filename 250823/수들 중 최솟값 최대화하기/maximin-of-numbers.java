import java.util.*;

public class Main {
    static int n;
    static int[][] grid;
    static int [] res;
    static boolean visited[];
    static int maxVal = Integer.MIN_VALUE;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        grid = new int[n][n];
        res = new int[n];
        visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = sc.nextInt();
            }
        }
        permu(0);
        System.out.println(maxVal);
    }
    //순열
    static void permu(int depth) {
        int minVal = Integer.MAX_VALUE;
        if(depth == n) {
            //System.out.println(Arrays.toString(res));
            for(int i =0; i<n; i++) {
                minVal = Math.min(grid[i][res[i]], minVal); 
            }
            //3중 최소값
            maxVal = Math.max(minVal, maxVal);
            return;
        }
        for(int i=0; i<n; i++) {
            if(!visited[i]) {
                res[depth] = i;
                visited[i] = true;
                permu(depth+1);
                visited[i] = false;
            }
            
            
        }
    }
}