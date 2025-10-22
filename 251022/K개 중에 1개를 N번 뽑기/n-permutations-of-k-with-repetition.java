import java.util.*;

public class Main {
    static int k;
    static int n;
    static int arr[];
    static int res[];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        k = sc.nextInt();
        n = sc.nextInt();
        arr = new int[k];
        res = new int[n];
        // Please write your code here.
        for(int i=0; i<k; i++) {
            arr[i] = i+1;
        }
        combi(0);
    }
    static void combi(int cnt) {
        if(cnt == n) {
            for(int i=0; i<n; i++) {
                System.out.print(res[i] +" ");
            }
            System.out.println();
            
            return;
        }
        for(int i=0; i<k; i++) {
            res[cnt] = arr[i];
            combi(cnt+1);
        }
    }
}