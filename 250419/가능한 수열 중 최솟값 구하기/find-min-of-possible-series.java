import java.util.*;

public class Main {
    static int n;
    static int[] res;
    static int[] arr = {4, 5, 6};
    static boolean found = false;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        res = new int[n];
        permu(0);
    }

    static boolean isGood(int[] seq, int len) {
        for (int l = 1; l <= len / 2; l++) {
            boolean isSame = true;
            for (int i = 0; i < l; i++) {
                if (seq[len - 1 - i] != seq[len - 1 - l - i]) {
                    isSame = false;
                    break;
                }
            }
            if (isSame) return false; // 반복 있음
        }
        return true;
    }

    static void permu(int depth) {
        if (found) return;

        if (!isGood(res, depth)) return; // 백트래킹!

        if (depth == n) {
            for (int i = 0; i < n; i++) {
                System.out.print(res[i]);
            }
            System.out.println();
            found = true;
            return;
        }

        for (int i = 0; i < 3; i++) {
            res[depth] = arr[i];
            permu(depth + 1);
        }
    }
}
