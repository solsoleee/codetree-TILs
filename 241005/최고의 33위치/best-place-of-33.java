import java.util.*;
import java.io.*;

public class Main {
    static StringTokenizer tokens;

    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        // 여기에 코드를 작성해주세요.
        int n = Integer.parseInt(input.readLine());
        int arr[][] = new int[n][n];
        for(int i=0; i<n; i++) {
            tokens = new StringTokenizer(input.readLine());
            for(int j=0; j<n; j++) {
                arr[i][j] = Integer.parseInt(tokens.nextToken());
            }
        }
        int count;
        int maxVal = Integer.MIN_VALUE;
        for(int a=0; a<n-2; a++) {
            for(int b=0; b<n-2; b++) {
                count = 0;
                for(int i=0; i<3; i++) {
                    for(int j=0; j<3; j++) {
                        if(arr[i+a][j+b] == 1) count++;
                    }
                 }
                 maxVal = Math.max(count, maxVal);

            }

        }
        System.out.println(maxVal);


    }   
}