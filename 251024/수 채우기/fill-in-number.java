import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int answer=Integer.MAX_VALUE;
        for(int i=1; i<=n; i++) {
            int left = n - 5*i;
            if(left >=0 && left%2==0) {
                answer = Math.min(answer, i+left/2);
            }
        }
        if(answer==Integer.MAX_VALUE) System.out.println(-1);
        else System.out.println(answer);
        // 1. 5로 나누고 나머지만 2
        // n/5
        //dp? 1이면
        //dp[1] = -1
        //dp[2] = 1
        //dp[3] = -1
        //dp[4] = 2
        //dp[5] = 1
        //dp[6]= 3 dp[2] + dp[4]
        //dp[7] = dp[5] + dp[2] 
        //dp[8]= dp[2] + dp[6] = 4
    }
}