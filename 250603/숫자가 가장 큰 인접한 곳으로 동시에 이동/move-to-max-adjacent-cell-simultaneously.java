import java.util.*;

public class Main {
    static int[][] deltas = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    static int[][] visited;
    static int n;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int m = sc.nextInt();
        int t = sc.nextInt();
        int[][] grid = new int[n][n];

        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                grid[i][j] = sc.nextInt();

        int[][] marbles = new int[m][2];
        for (int i = 0; i < m; i++) {
            marbles[i][0] = sc.nextInt() - 1;
            marbles[i][1] = sc.nextInt() - 1;
        }

        int ans = m;
        boolean[] m_check = new boolean[m];

        while (t-- > 0) {
            if (ans <= 0) break;

            visited = new int[n][n];
            List<Integer> aliveIndexList = new ArrayList<>();

            for (int i = 0; i < m; i++) {
                if (m_check[i]) continue;

                int max_value = Integer.MIN_VALUE;
                int dir = -1;

                for (int d = 0; d < 4; d++) {
                    int nx = marbles[i][0] + deltas[d][0];
                    int ny = marbles[i][1] + deltas[d][1];
                    if (check(nx, ny)) {
                        if (grid[nx][ny] > max_value) {
                            max_value = grid[nx][ny];
                            dir = d;
                        }
                    }
                }

                int dx = marbles[i][0] + deltas[dir][0];
                int dy = marbles[i][1] + deltas[dir][1];
                marbles[i][0] = dx;
                marbles[i][1] = dy;
                visited[dx][dy]++;
                aliveIndexList.add(i); // 살아있는 구슬만 저장
            }

            // 죽은 구슬 판단
            for (int i : aliveIndexList) {
                int x = marbles[i][0];
                int y = marbles[i][1];
                if (visited[x][y] >= 2) {
                    if (!m_check[i]) {
                        m_check[i] = true;
                        ans--;
                    }
                }
            }
        }

        System.out.println(ans);
    }

    static boolean check(int x, int y) {
        return x >= 0 && x < n && y >= 0 && y < n;
    }
}
