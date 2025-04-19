import java.util.*;

public class Main {
    static int n;
    static int[] res;
    static int[] arr = {4, 5, 6};
    static int[] answer;
    static boolean found = false;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        res = new int[n];
        permu(0);
        // 출력은 처음 만나는 것만!
    }

    // 반복되는 수열인지 확인
    static boolean isRepeated(int[] seq, int len) {
        for (int l = 1; l <= len / 2; l++) {
            boolean valid = true;
            for (int i = 0; i + l < len; i++) {
                if (seq[i] != seq[i + l]) {
                    valid = false;
                    break;
                }
            }
            if (valid) return true;
        }
        return false;
    }

    // 중복 순열
    static void permu(int depth) {
        if (found) return;

        if (depth == n) {
            if (!isRepeated(res, n)) {
                for (int i = 0; i < n; i++) {
                    System.out.print(res[i]);
                }
                System.out.println();
                found = true; // 사전순 첫 번째만 출력
            }
            return;
        }

        for (int i = 0; i < 3; i++) {
            res[depth] = arr[i];
            permu(depth + 1);
        }
    }
}
