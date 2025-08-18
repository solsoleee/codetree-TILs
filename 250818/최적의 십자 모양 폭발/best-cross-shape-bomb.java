import java.util.*;

public class Main {
    static int n;
    static int [][] grid;
    static int [][] deltas = {{0,1}, {1,0}, {-1,0}, {0,-1}};
    static int [][] temp;
    static int maxVal = Integer.MIN_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        grid = new int[n][n];
        temp = new int [n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                grid[i][j] = sc.nextInt();

        // 완탐
        for (int i = 0; i < n; i++ ) {
            for (int j = 0; j < n; j++) {
                init();         // 1) 초기화
                bomb(i, j);     // 2) 터짐
                gravity();      // 3) 중력
                int r = countPairs();  // 4) 인접 동일 쌍 개수
                maxVal = Math.max(maxVal, r);
            }
        }
        System.out.println(maxVal);
    }

    // 인접 동일 쌍 개수(오른쪽/아래만 봐서 중복 방지, 0 제외)
    static int countPairs() {
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int v = temp[i][j];
                if (v <= 0) continue;
                if (j + 1 < n && temp[i][j + 1] == v) cnt++;
                if (i + 1 < n && temp[i + 1][j] == v) cnt++;
            }
        }
        return cnt;
    }

    // 중력: 각 열을 아래로 꽉 채움
    static void gravity() {
        for (int col = 0; col < n; col++) {
            int write = n - 1; // 아래에서부터 채울 위치
            for (int row = n - 1; row >= 0; row--) {
                if (temp[row][col] != 0) {
                    temp[write][col] = temp[row][col];
                    if (write != row) temp[row][col] = 0;
                    write--;
                }
            }
            for (int row = write; row >= 0; row--) temp[row][col] = 0;
        }
    }

    // 초기화
    static void init() {
        for (int i = 0; i < n; i++) {
            temp[i] = Arrays.copyOf(grid[i], n);
        }
    }

    // 범위 체크
    static boolean check(int x, int y) {
        return x >= 0 && x < n && y >= 0 && y < n;
    }

    // 폭탄: 중심 값이 0이면 아무 것도 안 터짐
    static void bomb(int x, int y) {
        int num = grid[x][y];
        if (num <= 0) return;      // ★ fix: 0이면 아무 것도 안함
        temp[x][y] = 0;            // 중심 포함
        for (int[] d : deltas) {
            int nx = x, ny = y;
            for (int k = 1; k < num; k++) {
                nx += d[0];
                ny += d[1];
                if (!check(nx, ny)) break;   // ★ fix: 범위 벗어나면 중단
                temp[nx][ny] = 0;
            }
        }
    }
}
