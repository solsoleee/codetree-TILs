import java.util.Scanner;

public class Main {
    static int n;
    static int m;
    static int[] arr;
    static int[] res;
    static boolean[] visited;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        arr = new int[n];
        res = new int[m];
        visited = new boolean[n];
        for(int i=0; i<n; i++) {
            arr[i] = i+1;
        }
        combi(0,0);
    }
    static void combi(int depth, int start) {
        if(depth == m) {
            for(int i=0; i<m; i++) {
                System.out.print(res[i] +" ");
            }
            System.out.println();
            return;    
        }
        for(int i=start; i<n; i++) {
            
                res[depth] = arr[i];
                
                combi(depth+1,i+1);
                
        }
    }    

}