import java.util.*;

public class Main {
    static int n;
    static int[][] seg;
    static int best;
    static boolean touchAllowed = false; // 닿는 것 허용 여부

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        seg = new int[n][2];
        for (int i = 0; i < n; i++) {
            int a = sc.nextInt(), b = sc.nextInt();
            if (a > b) { int t = a; a = b; b = t; }
            seg[i][0] = a; seg[i][1] = b;
        }
        sc.close();

        Arrays.sort(seg, (u, v) -> u[1] != v[1] ? Integer.compare(u[1], v[1])
                                                : Integer.compare(u[0], v[0]));

        best = 0;
        dfs(0, Integer.MIN_VALUE, 0);
        System.out.println(best);
    }

    static void dfs(int idx, int lastEnd, int cnt) {
        if (cnt + (n - idx) <= best) return;

        if (idx == n) {
            best = Math.max(best, cnt);
            return;
        }

        // 현재 선분을 안 고르는 경우
        dfs(idx + 1, lastEnd, cnt);

        // 현재 선분을 고르는 경우
        int L = seg[idx][0], R = seg[idx][1];
        boolean ok = touchAllowed ? (L >= lastEnd) : (L > lastEnd);
        if (ok) dfs(idx + 1, R, cnt + 1);
    }
}
