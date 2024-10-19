import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static int n;
    public static int[] res;     // 수열을 저장할 배열
    public static int[] numbers = new int[]{4, 5, 6}; // 사용할 숫자 배열

    // 두 수열이 동일한지 여부를 판별하는 함수
    public static boolean isEqual(int start1, int end1, int start2, int end2) {
        for (int i = 0; i <= end1 - start1; i++) {
            if (res[start1 + i] != res[start2 + i])  // 배열 값을 비교
                return false;
        }
        return true;
    }

    // 가능한 수열인지 여부를 판별하는 함수
    public static boolean isPossibleSeries() {
        // 수열의 가장 앞부터 각 인덱스가 시작점일 때
        // 인접한 연속 부분 수열이 동일한지 탐색
        for (int idx = 0; idx < n; idx++) {
            // 가능한 연속 부분 수열의 길이 범위를 탐색
            int len = 1;
            while (true) {
                // 연속 부분 수열의 시작과 끝 인덱스를 설정
                int start1 = idx, end1 = idx + len - 1;
                int start2 = end1 + 1, end2 = start2 + len - 1;

                // 두 번째 연속 부분 수열의 끝 인덱스가 범위를 넘어가면 탐색 종료
                if (end2 >= n)
                    break;

                // 인접한 연속 부분 수열이 같은지 여부를 확인
                if (isEqual(start1, end1, start2, end2))
                    return false;

                len++;
            }
        }
        return true;  // 중복된 부분 수열이 없으면 true 반환
    }

    public static void findMinSeries(int cnt) {
        if (cnt == n) {
            if (isPossibleSeries()) {
                // 결과 출력
                for (int i = 0; i < n; i++) {
                    System.out.print(res[i]);
                }
                System.exit(0);  // 정답을 찾으면 프로그램 종료
            }
            return;
        }

        // 각 숫자를 수열에 추가하면서 재귀적으로 탐색
        for (int i = 0; i < 3; i++) {
            res[cnt] = numbers[i];  // 수열에 숫자 추가
            findMinSeries(cnt + 1);  // 다음 자리로 재귀 호출
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(input.readLine());  // n값 입력 받음
        res = new int[n];  // 결과 수열 크기 n만큼 초기화
        findMinSeries(0);  // 중복 수열 없이 사전순으로 가장 작은 수열 찾기
    }
}