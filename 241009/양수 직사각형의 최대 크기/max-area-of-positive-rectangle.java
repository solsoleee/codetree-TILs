import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static StringTokenizer tokens;
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static int n, m;
    static int maxVal = Integer.MIN_VALUE;
    static int map[][];

    public static void main(String[] args) throws IOException {
        tokens = new StringTokenizer(input.readLine());
        n = Integer.parseInt(tokens.nextToken());
        m = Integer.parseInt(tokens.nextToken());
        map = new int[n][m];
        
        // 입력 받기
        for (int i = 0; i < n; i++) {
            tokens = new StringTokenizer(input.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(tokens.nextToken());
            }
        }

        // 직사각형 계산
        findMaxRectangle();
        System.out.println(maxVal);
    }

    static void findMaxRectangle() {
        // 왼쪽 위 모서리
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                // 오른쪽 아래 모서리
                for (int a = i; a < n; a++) {
                    for (int b = j; b < m; b++) {
                        boolean allPositive = true;
                        // 내부 모든 요소가 양수인지 확인
                        for (int r = i; r <= a; r++) {
                            if (!allPositive) break;
                            for (int c = j; c <= b; c++) {
                                if (map[r][c] < 0) {
                                    allPositive = false;
                                    break;
                                }
                            }
                        }
                        // 모두 양수면 크기 계산
                        if (allPositive) {
                            int area = (a - i + 1) * (b - j + 1);
                            maxVal = Math.max(maxVal, area);
                        }
                    }
                }
            }
        }
    }
}