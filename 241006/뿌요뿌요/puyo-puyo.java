import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static StringTokenizer tokens;
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static int n, res;
    static int maxVal = 0;  // maxVal을 0으로 초기화
    static int board[][];
    static boolean visited[][];
    static int deltas[][] = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};  // 상하좌우

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(input.readLine());
        board = new int[n][n];
        visited = new boolean[n][n];

        // 입력 처리
        for (int i = 0; i < n; i++) {
            tokens = new StringTokenizer(input.readLine());
            for (int j = 0; j < n; j++) {
                board[i][j] = Integer.parseInt(tokens.nextToken());
            }
        }

        // 터질 블럭의 수와 최대 블럭 크기 계산
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j]) {
                    int blockSize = dfs(i, j, board[i][j]);

                    // 4개 이상인 블럭만 터지므로 개수 증가
                    if (blockSize >= 4) {
                        res++;  // 터진 블럭의 수
                        maxVal = Math.max(maxVal, blockSize);  // 최대 블럭 크기 갱신
                    }
                }
            }
        }

        // 결과 출력
        System.out.println(res + " " + maxVal);
    }

    // DFS 탐색: x, y에서 시작하여 같은 숫자 블럭 크기 계산
    static int dfs(int x, int y, int val) {
        visited[x][y] = true;  // 방문 처리
        int size = 1;  // 시작점을 포함하므로 크기 1

        // 상하좌우로 탐색
        for (int[] delta : deltas) {
            int nx = x + delta[0];
            int ny = y + delta[1];
            // 범위 내에서 같은 숫자이고 방문하지 않은 경우에만 탐색
            if (nx >= 0 && nx < n && ny >= 0 && ny < n && board[nx][ny] == val && !visited[nx][ny]) {
                size += dfs(nx, ny, val);  // 재귀적으로 크기 누적
            }
        }

        return size;  // 블럭의 총 크기 반환
    }
}