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
            if(!check()) {
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
        //같은 숫자가 3번 이상 나오는 경우
    static boolean check() {
        int cnt=1;
        int temp = res[0];
        for(int i=1; i<n; i++) {
            if(cnt >=3) {
                return true; //연속하는거
            }
            if(res[i-1] == res[i]) {
                cnt++;
            }
            else  {
                cnt=1;
            }

    }
    if(cnt >=3) {
                return true; //연속하는거
            }
    return false;
}
}