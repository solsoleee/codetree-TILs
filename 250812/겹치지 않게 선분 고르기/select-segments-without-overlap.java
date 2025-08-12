import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] a = new int[n][2];
        for (int i = 0; i < n; i++) {
            int L = sc.nextInt(), R = sc.nextInt();
            if (L > R) { int t = L; L = R; R = t; }
            a[i][0] = L; a[i][1] = R;
        }
        sc.close();

        boolean touchAllowed = false; // 닿음 허용 시 true

        Arrays.sort(a, (u, v) -> u[1] != v[1] ? Integer.compare(u[1], v[1])
                                              : Integer.compare(u[0], v[0]));

        int cnt = 0;
        int lastEnd = touchAllowed ? Integer.MIN_VALUE : Integer.MIN_VALUE;
        for (int[] s : a) {
            int L = s[0], R = s[1];
            boolean ok = touchAllowed ? (L >= lastEnd) : (L > lastEnd);
            if (ok) { cnt++; lastEnd = R; }
        }
        System.out.println(cnt);
    }
}
