import java.util.*;
public class Main {
    static int n;
    static int[][] grid;
    static boolean[] visited;
    static int[] arr;
    static int[] res;
    static int max;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        arr = new int[n];
        grid = new int[n][n];
        visited = new boolean[n];
        max = Integer.MIN_VALUE;
        res = new int[n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                grid[i][j] = sc.nextInt();
        for(int i=0; i<n; i++) {
            arr[i] = i;
        }
        permu(0);
        System.out.println(max);
    }
    static void permu(int depth) {
        if(depth == n) {
            //System.out.println(Arrays.toString(res));
            int sum =0;
            for(int i=0; i<n; i++) {
                
                int r = res[i];
                sum += grid[i][r] ;
            }
            max = Math.max(max, sum);
            
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