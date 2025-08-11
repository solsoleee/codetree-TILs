import java.util.Scanner;
public class Main {
    static int n;
    static int arr[];
    static int res[];
    static boolean visited[];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        arr = new int[n];
        res = new int[n];
        visited = new boolean[n];
        for(int i=n; i>0; i--) {
            arr[n-i] = i;
        }
        
        permu(0);
    }
    static void permu(int d) {
        if(d == n) {
            for(int i=0; i<n; i++) {
                System.out.print(res[i] +" ");
            }
            System.out.println();
            return;
        }
        for(int i=0; i<n; i++) {
            if(!visited[i]) {
                res[d] = arr[i];
                visited[i] = true;
                permu(d+1);
                visited[i] = false;
            }
        }
    }
}