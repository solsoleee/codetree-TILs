import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<Long, Long> map = new HashMap<>();
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            long x = sc.nextInt();
            long y = sc.nextInt();

            if(!map.containsKey(x)) map.put(x,y);
            else {// 이미 있으면 더 작은거
                if(map.get(x) > y) map.put(x, y);
            }
        }
        
        long ans = 0;
        for(long k: map.keySet()) {
            ans += map.get(k);
        }
        System.out.println(ans);
    }
}