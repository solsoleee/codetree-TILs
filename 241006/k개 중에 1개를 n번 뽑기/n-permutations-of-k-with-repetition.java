import java.util.*;
import java.io.*;

public class Main {
    static StringTokenizer tokens;
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static int n, m;
    static boolean[] visited;
    static int[] arr, result;

    public static void main(String[] args) throws IOException {
        tokens = new StringTokenizer(input.readLine());
        n = Integer.parseInt(tokens.nextToken());
        m = Integer.parseInt(tokens.nextToken());
        visited = new boolean[n];
        arr = new int[n];
        result = new int[m];
        for (int i = 0; i < n; i++) {
            arr[i] = i + 1; // 1부터 n까지의 배열 생성
        }
        permutation(0);
        
    }
    static void permutation(int cnt) {
        if(cnt == m ){
            for(int i=0; i<m; i++) {
                System.out.print(result[i] + " ");
            }
            System.out.println();
            return;
        }
        for(int i=0; i<n; i++) {
            result[cnt] = arr[i];
            permutation(cnt+1);
        }

    }

    
}