import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static StringTokenizer tokens;
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder output = new StringBuilder();
    static int n,res;
    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(input.readLine());
        int dp[] = new int[n+1];
        dp[0]=0;
        dp[1]=1;
        dp[2]=2;
        for(int i=3; i<=n; i++) {
            dp[i] = (dp[i-1] + dp[i-2]) % 10007  ;
        }
        System.out.print(dp[n] % 10007 );
    }
}