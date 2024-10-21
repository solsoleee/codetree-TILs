import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static StringTokenizer tokens;
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {

        tokens = new StringTokenizer(input.readLine());
        int n = Integer.parseInt(tokens.nextToken());
        int k = Integer.parseInt(tokens.nextToken());
        int []arr = new int[n];
        for(int i=n-1; i>=0; i--) {
            arr[i] = Integer.parseInt(input.readLine());
        }
        int res=0;
        for(int i=0; i<n; i++) {
            if(k==0) break;
            res += (k/arr[i]);
            k = k%arr[i];
        }
        System.out.println(res);

    }
}