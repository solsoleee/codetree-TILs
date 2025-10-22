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

        for(int i=0; i<k; i++) {
            arr[i] = i+1;
        }
        permu(0);
        
    }

    static void permu(int cnt) {
        if(cnt == n) {
            int a = res[0];
            boolean flag = false;
            for(int i=1; i<n; i++) {
                if(a != res[i]) flag = true;
            }
            if(flag || n==1) {
                for(int i=0; i<n; i++) {
                    System.out.print(res[i] +" ");
                }
                System.out.println();
            }
            return;
        }
        for(int i=0; i<k; i++) {
            res[cnt] = arr[i];
            permu(cnt+1);
        }
        
    }
}