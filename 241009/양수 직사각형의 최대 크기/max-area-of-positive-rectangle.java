import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static StringTokenizer tokens;
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static int n, m;
    static int maxVal = -1;  // 초기값을 -1로 설정하여 양수 직사각형이 없을 때 대비
    static int map[][];

    public static void main(String[] args) throws IOException {
        tokens = new StringTokenizer(input.readLine());
        n = Integer.parseInt(tokens.nextToken());
        m = Integer.parseInt(tokens.nextToken());
        map = new int[n][m];
        
        // 배열 입력 받기
        for (int i = 0; i < n; i++) {
            tokens = new StringTokenizer(input.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(tokens.nextToken());
            }
        }

        // 최대 크기 양수 직사각형 탐색
        findMaxRectangle();
        
        // 양수 직사각형이 없을 경우 -1 출력
        System.out.println(maxVal);
    }

    static void findMaxRectangle() {
        // 왼쪽 상단 좌표 (i, j)
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                // 오른쪽 하단 좌표 (a, b)
                for (int a = i; a < n; a++) {
                    for (int b = j; b < m; b++) {

                        // 직사각형 내부가 모두 양수인지 확인
                        boolean allPositive = true;
                        for (int r = i; r <= a; r++) {
                            if (!allPositive) break; // 내부 확인 도중 음수를 발견하면 중단
                            for (int c = j; c <= b; c++) {
                                if (map[r][c] <= 0) {
                                    allPositive = false;
                                    break;
                                }
                            }
                        }

                        // 양수로만 이루어진 직사각형이면 크기 계산
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