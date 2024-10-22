import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{


    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer tokens;

    public static void main(String[] args) throws IOException {

        int n = Integer.parseInt(input.readLine());
        int arr[] = new int[n];
        tokens = new StringTokenizer(input.readLine());
        for(int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(tokens.nextToken());
        }

        int max = Integer.MIN_VALUE;
        int sum=0;
        for(int i=0; i<n; i++) {
            if(sum < 0 ) sum = arr[i];
            else sum+=arr[i];

            max = Math.max(max, sum);

        }


        System.out.println(max);
    }
}