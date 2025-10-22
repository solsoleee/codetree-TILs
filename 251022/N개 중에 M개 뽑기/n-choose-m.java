import java.util.*;

public class Main {
    static int n;
    static int m;
    static int arr[];
    static int res[];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        arr = new int[n];
        res = new int[m];
        for(int i=0; i<n; i++) {
            arr[i] = i+1;
        }
        combi(0,0);
    }
    static void combi(int cnt, int start) {
        if(cnt == m) {
            for(int i=0; i<m; i++) {
                System.out.print(res[i]+" ");
                
            }
            System.out.println();
            
            return;
        }
        for(int i=start; i<n; i++) {
            res[cnt] = arr[i];
            combi(cnt+1, i+1);
        }
    }
}