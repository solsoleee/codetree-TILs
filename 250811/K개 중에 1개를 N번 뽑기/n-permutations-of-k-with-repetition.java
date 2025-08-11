import java.util.Scanner;

public class Main {
    static int k;
    static int n;
    static int[] arr; //k까지 저장
    static int[] res; //결과를 저장
    static boolean[] visited; //기록
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        k = sc.nextInt();
        n = sc.nextInt();
        arr = new int[k];
        res = new int[n];
        visited = new boolean[k];
        for(int i=0; i<k; i++) {
            arr[i] = i+1;
        }
        permu(0);
    }
    static void permu(int q) {
        if(q==n) {
            //개수만족
            for(int i=0; i<n; i++) {
                System.out.print(res[i] +" ");
            }
            System.out.println();
            return; 
        }
        for(int i=0; i<k; i++) {
            //if(!visited[i]) {
                //visited[i] = true;
                res[q] = arr[i];
                permu(q+1);
                //visited[i] = false;
                
            //} 

        }
    }
    //순열
}