import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        // 5개, k가 되어야함
        // 두 개의 수를 뽑아 더해야 함
        // 조합. 
        // 개수
        int cnt =0;
        for(int i=0; i<n; i++) {
            for(int j=i+1; j<n; j++) {
                if(arr[i] + arr[j] == k) {
                    cnt ++;
                    
                }
            }
        }
        System.out.println(cnt);
        // Please write your code here.
    }
    
}