import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        long[] arr = new long[N];
        PriorityQueue<Long> que = new PriorityQueue<>();
        
        for (int i = 0; i < N; i++) {
            long ans = 1;
            long [] temp = new long[3];
            arr[i] = sc.nextLong();
            que.offer(arr[i]);
            if(i<2) System.out.println(-1);
            else {
                for(int j=0; j<3; j++) {
                    temp[j] = que.poll();
                    ans *=temp[j];
                    
                }
                System.out.println(ans);
                for(int j=0; j<3; j++) {
                    que.offer(temp[j]);
                }
            }
        }
        

    }
}