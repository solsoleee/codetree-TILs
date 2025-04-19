import java.util.*;

public class Main {
    static final int MAX = 200;
    static int n, m;
    static int[][] grid = new int[MAX][MAX];
    static boolean[][] visited = new boolean[MAX][MAX];
    static int[][] deltas = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    static Queue<int[]> q = new LinkedList<>();
    static int elapsedTime = 0;
    static int lastMeltCount = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                grid[i][j] = sc.nextInt();

        while (true) {
            lastMeltCount = 0;
            bfsMarkOutsideWater();
            meltGlaciers();
            if (!hasGlacier()) break;
            elapsedTime++;
        }

        System.out.println((elapsedTime + 1) + " " + lastMeltCount);
    }

    static void bfsMarkOutsideWater() {
        visited = new boolean[n][m];
        q.clear();
        q.add(new int[]{0, 0});
        visited[0][0] = true;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0], y = cur[1];

            for (int[] d : deltas) {
                int nx = x + d[0], ny = y + d[1];
                if (inRange(nx, ny) && grid[nx][ny] == 0 && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    q.add(new int[]{nx, ny});
                }
            }
        }
    }

    static void meltGlaciers() {
        List<int[]> toMelt = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1 && hasOutsideWaterNeighbor(i, j)) {
                    toMelt.add(new int[]{i, j});
                }
            }
        }

        for (int[] cell : toMelt) {
            grid[cell[0]][cell[1]] = 0;
        }

        lastMeltCount = toMelt.size();
    }

    static boolean hasOutsideWaterNeighbor(int x, int y) {
        for (int[] d : deltas) {
            int nx = x + d[0], ny = y + d[1];
            if (inRange(nx, ny) && visited[nx][ny]) {
                return true;
            }
        }
        return false;
    }

    static boolean hasGlacier() {
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                if (grid[i][j] == 1)
                    return true;
        return false;
    }

    static boolean inRange(int x, int y) {
        return 0 <= x && x < n && 0 <= y && y < m;
    }
}
