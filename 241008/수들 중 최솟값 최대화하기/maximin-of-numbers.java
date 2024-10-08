import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    
    static StringTokenizer tokens;
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static int n;
    static int arr[][];
    static boolean visitedRow[];
    static boolean visitedCol[];
    static int maxVal = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(input.readLine());
        arr = new int[n][n];
        visitedRow = new boolean[n];
        visitedCol = new boolean[n];

        for (int i = 0; i < n; i++) {
            tokens = new StringTokenizer(input.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(tokens.nextToken());
            }
        }
        dfs(0, Integer.MAX_VALUE);
        System.out.println(maxVal);
    }

    static void dfs(int cnt, int currentMin) {
        if (cnt == n) {
            maxVal = Math.max(maxVal, currentMin);
            return;
        }

        for (int i = 0; i < n; i++) {
            if (!visitedRow[cnt] && !visitedCol[i]) {
                visitedRow[cnt] = true;
                visitedCol[i] = true;
                dfs(cnt + 1, Math.min(currentMin, arr[cnt][i]));
                visitedRow[cnt] = false;
                visitedCol[i] = false;
            }
        }
    }
}