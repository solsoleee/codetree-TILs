import java.util.*;

public class Main {
    static int n, k;
    static int[][] grid;
    static int[][] deltas = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();
        grid = new int[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                grid[i][j] = sc.nextInt();

        int x = sc.nextInt() - 1;
        int y = sc.nextInt() - 1;

        for (int step = 0; step < k; step++) {
            int[] next = bfs(x, y);
            if (next == null) break;
            x = next[0];
            y = next[1];
        }

        System.out.println((x + 1) + " " + (y + 1));
    }

    static boolean inRange(int x, int y) {
        return 0 <= x && x < n && 0 <= y && y < n;
    }

    static int[] bfs(int sx, int sy) {
        boolean[][] visited = new boolean[n][n];
        Queue<int[]> que = new ArrayDeque<>();
        List<int[]> candidates = new ArrayList<>();

        que.offer(new int[]{sx, sy});
        visited[sx][sy] = true;

        while (!que.isEmpty()) {
            int[] cur = que.poll();
            int x = cur[0], y = cur[1];

            for (int[] d : deltas) {
                int nx = x + d[0];
                int ny = y + d[1];

                if (inRange(nx, ny) && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    if (grid[nx][ny] < grid[sx][sy]) {
                        candidates.add(new int[]{nx, ny});
                        que.offer(new int[]{nx, ny});
                    }
                }
            }
        }

        if (candidates.isEmpty()) return null;

// candidates 리스트 정렬 시
candidates.sort((a, b) -> {
    if (grid[a[0]][a[1]] != grid[b[0]][b[1]])
        return grid[b[0]][b[1]] - grid[a[0]][a[1]]; // 큰 값 먼저
    if (a[0] != b[0])
        return a[0] - b[0]; // 행 작은 것 먼저
    return a[1] - b[1];     // 열 작은 것 먼저
});


        return candidates.get(0); // 가장 우선순위 높은 칸
    }
}
