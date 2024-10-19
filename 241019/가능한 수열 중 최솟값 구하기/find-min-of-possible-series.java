import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static boolean flag;   // 답을 찾았을 때 탐색 종료를 위한 플래그
    static int n;
    static int res[];      // 결과 수열을 저장할 배열
    static int arr[] = {4, 5, 6};   // 사용할 숫자 배열

    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(input.readLine());  // n값 입력 받음
        res = new int[n];  // 결과 수열 크기 n만큼 초기화
        permu(0);  // 중복 순열 생성 시작
    }

    // 중복 순열 만들기
    static void permu(int cnt) {
        if (cnt == n) {  // 수열의 길이가 n일 때
            if (check()) {  // 중복 부분 수열이 없는지 확인
                for (int r : res)  // 정답 출력
                    System.out.print(r);
                flag = true;  // 정답을 찾았으므로 탐색 종료
            }
            return;
        }
        for (int i = 0; i < 3; i++) {
            if (flag) break;  // 정답을 찾았으면 더 이상 탐색하지 않음
            res[cnt] = arr[i];  // 수열에 숫자 추가
            permu(cnt + 1);  // 다음 자리 재귀 호출
        }
    }

    // 중복된 연속 부분 수열이 있는지 확인하는 함수
    static boolean check() {
        // 연속 부분 수열을 확인하는 과정
        for (int len = 1; len <= n / 2; len++) {  // 가능한 부분 수열의 길이 범위 탐색
            for (int i = 0; i + len * 2 <= n; i++) {  // 인접한 두 수열 비교
                boolean isSame = true;
                for (int j = 0; j < len; j++) {
                    if (res[i + j] != res[i + j + len]) {  // 수열이 다르면 중복 아님
                        isSame = false;
                        break;
                    }
                }
                if (isSame) {  // 만약 중복된 수열이 발견되면
                    return false;  // 중복이므로 false 반환
                }
            }
        }
        return true;  // 중복이 없으면 true 반환
    }
}