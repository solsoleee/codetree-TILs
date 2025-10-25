import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] arr = new int[n];
        boolean[] visited = new boolean[n];
        int answer = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
            map.put(arr[i],i);
        }
        // Please write your code here.
        for(int i=0; i<n; i++) {
            int temp = k-arr[i];
            if(visited[i]) continue;
            
            if(map.containsKey(temp)) {
                    visited[map.get(temp)] = true;
                    visited[i] = true;
                    answer++;
            }


        }
        System.out.println(answer);
        
        //System.out.println(answer/2);
    }
}