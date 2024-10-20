import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static StringTokenizer tokens;
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(input.readLine());
        int dp[] = new int[1001];
        dp[0] = 0;
        dp[1] = 0;
        dp[2] = 1;
        dp[3] = 1;
        for(int i=4; i<=n; i++) {
            dp[i] = ( dp[i-2] + dp[i-3] ) % 10007;
        }
        System.out.print(dp[n]% 10007);
    }
}