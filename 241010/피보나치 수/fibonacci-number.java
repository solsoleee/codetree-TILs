import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    private static StringTokenizer tokens;
    private static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    private static int n;

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(input.readLine());

        int dp[] = new int [46];
        Arrays.fill(dp, 0);
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 1;

        for(int i=2; i<46; i++){
            dp[i] = dp[i-2] + dp[i-1];
        }
        //System.out.println(Arrays.toString(dp));
        System.out.println(dp[n]);
    }
}