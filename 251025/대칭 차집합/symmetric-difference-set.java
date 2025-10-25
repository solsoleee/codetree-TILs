import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] A = new int[n];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            A[i] = sc.nextInt();
            map.put(A[i], map.getOrDefault(A[i], 0) + 1);
        }
        int[] B = new int[m];
        for (int i = 0; i < m; i++) {
            B[i] = sc.nextInt();
            map.put(B[i], map.getOrDefault(B[i], 0) + 1);
        }
        
        int ans = 0;
        for(int k: map.keySet()) {
            if(map.get(k) == 1) ans++;
        }
        System.out.println(ans);
    }
}