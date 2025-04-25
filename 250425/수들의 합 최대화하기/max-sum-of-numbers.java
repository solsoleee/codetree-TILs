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
        int n = sc.nextInt();
        grid = new int[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                grid[i][j] = sc.nextInt();
        // Please write your code here.
        idx = n*n; //총 수
        res = new int[n];
        arr = new int[idx];
        for(int i=0; i<idx; i++) {
            arr[i] = i+1;
        }
        combi(0,0);
        

    }
    static void combi(int start, int depth){
        if(depth == n) {
            System.out.println(Arrays.toString(res));
            return;
        }
        System.out.println(1);
        for(int i=start; i<idx; i++) {
            System.out.println(arr[i]);
            res[depth] = arr[i];
            
            combi(i+1, depth+1);
        }
    }
}