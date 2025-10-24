import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] prices = new int[n];
        for(int i = 0; i < n; i++)
            prices[i] = sc.nextInt();
        
        int answer = 0;
        int temp = Integer.MAX_VALUE;
        //작은거 정해놓고 
        //int temp = p;
        for(int p:prices) {
            // 현재 작다면
            if(p < temp ) {
                temp=p;
                
            }
            else answer = Math.max(answer, p-temp);
        }
        System.out.println(answer);
    }
}