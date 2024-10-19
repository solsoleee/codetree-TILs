import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static StringTokenizer tokens;
    static boolean flag;
    static int n;
    static int res[];
    static int arr[] ={4,5,6};

    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(input.readLine());
        res = new int[n];
        permu(0);
    }

    //중복 순열 만들기
    static void permu(int cnt) {
        if (cnt == n) {
            if (check()) {
                // 정답을 찾았으면 출력
                for (int r : res) {
                    System.out.print(r);
                }
                flag = true;  // 출력 후 멈추기
            }
            return;
        }
        
        for (int i = 0; i < 3; i++) {
            if (flag) break;  // 정답을 찾았으면 더 이상 수행하지 않음
            res[cnt] = arr[i];
            permu(cnt + 1);
        }
    }

    static boolean check() {
        // 길이 n에 대해 가능한 모든 연속 부분 수열이 같은지 체크
        for (int len = 1; len <= n / 2; len++) {
            for (int i = 0; i + len * 2 <= n; i++) {
                boolean isSame = true;
                for (int j = 0; j < len; j++) {
                    if (res[i + j] != res[i + j + len]) {
                        isSame = false;
                        break;
                    }
                }
                if (isSame) {
                    return false; // 중복된 부분 수열 발견
                }
            }
        }
        return true; // 중복된 부분 수열이 없으면 true
    }
}