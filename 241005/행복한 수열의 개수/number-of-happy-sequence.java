import java.io.*;
import java.util.*;

public class Main {

    static StringTokenizer tokens;
    static int n, m;
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        tokens = new StringTokenizer(input.readLine());
        n = Integer.parseInt(tokens.nextToken());
        m = Integer.parseInt(tokens.nextToken());
        int array[][] = new int[n][n];
        for (int i = 0; i < n; i++) {
            tokens = new StringTokenizer(input.readLine());
            for (int j = 0; j < n; j++) {
                array[i][j] = Integer.parseInt(tokens.nextToken());
            }
        }
        int row = rowCheck(array);
        int col = colCheck(array);

        System.out.println(row + col);
    }

    // 행을 체크하는 함수
    public static int rowCheck(int arr[][]) {
        int cnt;
        int res = 0;
        for (int i = 0; i < n; i++) {
            cnt = 1;
            for (int j = 1; j < n; j++) {
                if (arr[i][j] == arr[i][j - 1]) {
                    cnt++;
                } else {
                    cnt = 1;
                }
                // 연속된 숫자가 m 이상일 때만 카운트
                if (cnt >= m) {
                    res++;
                    break; // 한 번 찾으면 해당 행은 종료
                }
            }
            // n이 1인 경우도 처리: 행이 1개일 때도 행복한 수열로 간주
            if (n == 1) res++;
        }
        return res;
    }

    // 열을 체크하는 함수
    public static int colCheck(int arr[][]) {
        int cnt;
        int res = 0;
        for (int i = 0; i < n; i++) {
            cnt = 1;
            for (int j = 1; j < n; j++) {
                if (arr[j][i] == arr[j - 1][i]) {
                    cnt++;
                } else {
                    cnt = 1;
                }
                // 연속된 숫자가 m 이상일 때만 카운트
                if (cnt >= m) {
                    res++;
                    break; // 한 번 찾으면 해당 열은 종료
                }
            }
            // n이 1인 경우도 처리: 열이 1개일 때도 행복한 수열로 간주
            if (n == 1) res++;
        }
        return res;
    }
}