import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static final int NUM_LEN = 3;
    
    public static int n;
    public static int[] res;  // 수열을 저장할 배열
    public static int[] numbers = new int[]{4, 5, 6};
    public static boolean found = false;  // 정답을 찾았는지 여부
    
    // 중복된 연속 부분 수열이 있는지 여부를 확인하는 함수
    public static boolean hasDuplicate() {
        int len = res.length;
        for (int l = 1; l <= len / 2; l++) {  // 연속 부분 수열의 길이 l 탐색
            boolean isSame = true;
            for (int i = 0; i < l; i++) {
                if (res[len - 1 - i] != res[len - 1 - l - i]) {
                    isSame = false;
                    break;
                }
            }
            if (isSame) {  // 중복된 부분 수열이 발견되면
                return true;
            }
        }
        return false;
    }
    
    // 가능한 수열을 찾는 함수
    public static void findMinSeries(int cnt) {
        if (found) return;  // 정답을 찾았으면 탐색 종료
        
        if (cnt == n) {  // 수열의 길이가 n이 되었을 때
            // 수열이 가능하다면 출력하고 프로그램 종료
            for (int i = 0; i < n; i++) {
                System.out.print(res[i]);
            }
            found = true;
            return;
        }
    
        // 각 숫자를 추가하면서 가능한 수열을 탐색
        for (int i = 0; i < NUM_LEN; i++) {
            res[cnt] = numbers[i];  // 현재 수열에 숫자를 추가
            
            // 중복된 부분 수열이 없다면 다음 자리 탐색
            if (!hasDuplicate()) {
                findMinSeries(cnt + 1);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(input.readLine().trim());  // 입력을 BufferedReader로 받음
        res = new int[n];  // 결과 수열 크기 n만큼 초기화

        findMinSeries(0);  // 가능한 수열 탐색 시작
    }
}