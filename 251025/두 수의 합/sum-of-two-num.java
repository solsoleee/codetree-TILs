import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] arr = new int[n];
        int ans = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        for(int i=0; i<n; i++) {
            int diff = k-arr[i];
            if(map.containsKey(diff)){
                ans += map.get(diff);
            }
            map.put(arr[i], map.getOrDefault(arr[i],0)+1 );
        }
        //System.out.println(map);
        System.out.println(ans);
    }
}