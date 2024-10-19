import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static final int NUM_LEN = 3;

    public static int n;
    public static int[] series;  // 수열을 저장할 배열
    public static int[] numbers = new int[]{4, 5, 6};

    public static void main(String[] args) throws IOException {
        // BufferedReader를 사용하여 입력 처리
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine().trim());
        series = new int[n];  // 길이 n의 배열 초기화

        findMinSeries(0);  // 수열 생성 시작
    }

    // 가능한 수열을 찾는 함수
    public static void findMinSeries(int cnt) {
        if (cnt == n) {
            // 수열이 완성되면 출력하고 프로그램 종료
            for (int i = 0; i < n; i++) {
                System.out.print(series[i]);
            }
            System.exit(0);
        }

        // 사용 가능한 숫자를 하나씩 추가하면서 재귀적으로 탐색
        for (int i = 0; i < NUM_LEN; i++) {
            series[cnt] = numbers[i];  // 현재 위치에 숫자 추가

            if (isPossibleSeries(cnt + 1)) {  // 중복된 부분 수열이 없을 때만 다음 재귀 호출
                findMinSeries(cnt + 1);
            }
        }
    }

    // 현재까지의 수열이 가능한지 여부를 판별하는 함수
    public static boolean isPossibleSeries(int length) {
        // 가장 최근에 추가한 숫자로 인해 중복이 발생하는지 검사
        for (int len = 1; len <= length / 2; len++) {
            boolean isSame = true;
            for (int i = 0; i < len; i++) {
                if (series[length - len + i] != series[length - 2 * len + i]) {
                    isSame = false;
                    break;
                }
            }
            if (isSame) {
                return false;  // 중복된 부분 수열 발견
            }
        }
        return true;  // 중복된 부분 수열이 없으면 true 반환
    }
}