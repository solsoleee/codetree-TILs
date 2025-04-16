import java.util.*;
public class Main {
    static int n;
    static int arr[];
    static int res[];
    static boolean visited[];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        arr = new int[n];
        res = new int [n];
        visited = new boolean[n];
        for(int i=n; i>0; i--) {
            arr[n-i] = i;
        }
        permu(0);
        // Please write your code here.
    }
    //Collection.sort.reverse??
    //거꾸로 정렬하는 방법
    //순열
    static void permu(int depth) {
        if(depth == n) {
            for(int i=0; i<n; i++) {
                System.out.print(res[i] +" ");
            }
            System.out.println();
            return;
        }
        for(int i=0; i<n; i++) {
            if(!visited[i]) {
                res[depth] = arr[i];
                visited[i] = true;
                permu(depth+1);
                visited[i] = false;
            }
        }

    }
}