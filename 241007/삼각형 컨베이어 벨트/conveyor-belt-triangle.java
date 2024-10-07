import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static StringTokenizer tokens;
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static int n,t;
    static int []u, m, d;

    public static void main(String[] args) throws IOException {
        tokens = new StringTokenizer(input.readLine());
        n = Integer.parseInt(tokens.nextToken());
        t = Integer.parseInt(tokens.nextToken());
        u = new int[n];
        m = new int[n];
        d = new int[n];

        tokens = new StringTokenizer(input.readLine());
        for(int i=0; i<n; i++) {
            u[i] = Integer.parseInt(tokens.nextToken());
        }
        tokens = new StringTokenizer(input.readLine());
        for(int i=0; i<n; i++) {
            m[i] = Integer.parseInt(tokens.nextToken());
        }
        tokens = new StringTokenizer(input.readLine());
        for(int i=0; i<n; i++) {
            d[i] = Integer.parseInt(tokens.nextToken());
        }
        while(t-- > 0 ) {
            int temp = u[n - 1];
            for (int i = n - 1; i >= 1; i--) {
                u[i] = u[i - 1];
            }
            u[0] = d[n - 1];


            int temp2 = m[n - 1];
            for (int i = n - 1; i >= 1; i--) {
                m[i] = m[i - 1];
            }
            m[0] = temp;

            for (int i = n - 1; i >= 1; i--) {
                d[i] = d[i - 1];
            }
            d[0] = temp2;
        }
        for(int i=0; i<n; i++) {
            System.out.print(u[i] +" ");
        }
        System.out.println();
        for(int i=0; i<n; i++) {
            System.out.print(m[i] +" ");
        }
        System.out.println();
        for(int i=0; i<n; i++) {
            System.out.print(d[i] +" ");
        }
    }

}