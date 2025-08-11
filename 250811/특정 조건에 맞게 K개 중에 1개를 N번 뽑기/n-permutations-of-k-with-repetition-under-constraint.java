import java.util.Scanner;

//부분집합
public class Main {
    static int k;
    static int n;
    static int[] res;
    static int[] arr;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        k = sc.nextInt();
        n = sc.nextInt();
        arr = new int [k];
        res = new int [n];
        for(int i=0; i<k; i++) {
            arr[i] = i+1;
        }
        permu(0);
    }

    static void permu(int depth) {
        if(depth == n) {
            if(check()) {
                for(int i=0; i<n; i++) {
                System.out.print(res[i] +" ");
            }
            System.out.println();
            }
            
            return;
        }
        for(int i=0; i<k; i++) {
            res[depth] = arr[i];
            permu(depth+1);
        }
    }
        //같은건 골라내는
    static boolean check() {
        if(n==1) return true;
        int temp = res[0];
        for(int i=1; i<n; i++) {
            if(res[i] != temp) {
                return true; //하나라도 다르면 참
            }
            temp = res[i];
        }
        return false;
    }
}