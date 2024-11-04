import java.io.*;
import java.util.*;


public class Main {
    private static StringTokenizer tokens;
    private static StringBuilder output = new StringBuilder();
    private static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    

    public static void main(String[] args)throws IOException {
        // 여기에 코드를 작성해주세요.
        int n= Integer.parseInt(input.readLine());
        int arr[] = new int[n];
        tokens = new StringTokenizer(input.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(tokens.nextToken());
            pq.offer(arr[i]);
        }
        int sum =0;
        while(pq.size() != 1) {
            int a = pq.poll();
            int b = pq.poll();
            pq.offer(a+b);
            sum += a+b;
        }
        System.out.println(sum);
        
        
    }
}