import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] prices = new int[n];
        for(int i = 0; i < n; i++)
            prices[i] = sc.nextInt();
        // Please write your code here.
        int answer = 0;
        //조합으로 풀어도 되고..
        for(int i=0; i<n; i++) {
            for(int j=i; j<n; j++) {
                int profit = prices[j] - prices[i];
                if(profit > 0) answer = Math.max(profit, answer);
            }
        }
        System.out.println(answer);
    }
}