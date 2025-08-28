import java.util.*;

public class Main {
    static int n, k;
    static int[][] grid;
    static int r1, c1, r2, c2;
    static final int[][] DIR = {{1,0},{0,1},{-1,0},{0,-1}};

    static boolean in(int x, int y){ return 0 <= x && x < n && 0 <= y && y < n; }

    static int bfsShortest() {
        // visited[x][y][b]: (x,y)에 벽 b개 부수고 도달했는가
        boolean[][][] visited = new boolean[n][n][k+1];
        ArrayDeque<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{r1, c1, 0, 0}); // x, y, used, dist
        visited[r1][c1][0] = true;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0], y = cur[1], used = cur[2], dist = cur[3];

            if (x == r2 && y == c2) return dist;

            for (int[] d : DIR) {
                int nx = x + d[0], ny = y + d[1];
                if (!in(nx, ny)) continue;

                // 빈 칸이면 그냥 이동
                if (grid[nx][ny] == 0) {
                    if (!visited[nx][ny][used]) {
                        visited[nx][ny][used] = true;
                        q.offer(new int[]{nx, ny, used, dist + 1});
                    }
                }
                // 벽이고 아직 더 부술 수 있으면 부수고 이동
                else if (grid[nx][ny] == 1 && used < k) {
                    if (!visited[nx][ny][used + 1]) {
                        visited[nx][ny][used + 1] = true;
                        q.offer(new int[]{nx, ny, used + 1, dist + 1});
                    }
                }
            }
        }
        return -1; // 도달 불가
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();
        grid = new int[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                grid[i][j] = sc.nextInt();
        r1 = sc.nextInt() - 1;
        c1 = sc.nextInt() - 1;
        r2 = sc.nextInt() - 1;
        c2 = sc.nextInt() - 1;

        int ans = bfsShortest();
        System.out.println(ans);
    }
}
