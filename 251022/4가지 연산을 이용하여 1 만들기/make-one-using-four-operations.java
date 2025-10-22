import java.util.*;

public class Main {
    static int solve(int n) {
        int limit = Math.max(2 * n + 10, 10);    // 상태 상한 (무한 팽창 방지)
        boolean[] vis = new boolean[limit + 1];
        ArrayDeque<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{n, 0});
        vis[n] = true;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0], d = cur[1];
            if (x == 1) return d;

            // -1
            if (x - 1 >= 1 && !vis[x - 1]) { vis[x - 1] = true; q.offer(new int[]{x - 1, d + 1}); }
            // +1
            if (x + 1 <= limit && !vis[x + 1]) { vis[x + 1] = true; q.offer(new int[]{x + 1, d + 1}); }
            // /2
            if (x % 2 == 0 && !vis[x / 2]) { vis[x / 2] = true; q.offer(new int[]{x / 2, d + 1}); }
            // /3
            if (x % 3 == 0 && !vis[x / 3]) { vis[x / 3] = true; q.offer(new int[]{x / 3, d + 1}); }
        }
        return -1; // 도달 불가 케이스는 사실상 없음
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(solve(n));
    }
}
