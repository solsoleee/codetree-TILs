import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static StringTokenizer tokens;
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static int n, m;
    static int[][] arr;
    static int[][] res;
    static boolean[] visited;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        tokens = new StringTokenizer(input.readLine());
        n = Integer.parseInt(tokens.nextToken());
        m = Integer.parseInt(tokens.nextToken());
        arr = new int[n][2];
        res = new int[m][2];
        visited = new boolean[n];
        
        // 좌표 입력 받기
        for (int i = 0; i < n; i++) {
            tokens = new StringTokenizer(input.readLine());
            arr[i][0] = Integer.parseInt(tokens.nextToken());
            arr[i][1] = Integer.parseInt(tokens.nextToken());
        }
        
        // 조합 생성
        combi(0, 0);
        System.out.println(min);
    }

    // m개의 점 선택하기 위한 조합 생성
    static void combi(int start, int cnt) {
        if (cnt == m) {
            // 선택된 점들로 거리 계산
            int d = check();
            min = Math.min(min, d);
            return;
        }
        
        for (int i = start; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                res[cnt][0] = arr[i][0];
                res[cnt][1] = arr[i][1];
                combi(i + 1, cnt + 1);
                visited[i] = false;
            }
        }
    }

    // 선택된 m개의 점에서 가장 먼 두 점 사이의 거리 계산
    static int check() {
        int maxVal = Integer.MIN_VALUE;
        for (int i = 0; i < m - 1; i++) {
            for (int j = i + 1; j < m; j++) {
                int d = (int) Math.pow(res[i][0] - res[j][0], 2) + (int) Math.pow(res[i][1] - res[j][1], 2);
                maxVal = Math.max(d, maxVal);  // 가장 큰 거리값 추출
            }
        }
        return maxVal;  // 가장 먼 거리 반환
    }
}