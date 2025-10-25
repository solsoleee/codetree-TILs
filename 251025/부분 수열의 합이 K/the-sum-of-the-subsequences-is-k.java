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
        int [] prepixSum = new int[n+1];
        prepixSum[0] =0;
        int ans =0;
        for(int i=0; i<n; i++) {
            prepixSum[i+1] = prepixSum[i] + arr[i];
        }
        
        for(int i=0; i<=n; i++) {
            for(int j=i; j<=n; j++) {
                int t = prepixSum[j]-prepixSum[i];
                if(t == k) ans++;
            }
        }
        // System.out.println(Arrays.toString(prepixSum));
        System.out.println(ans);
    }
}