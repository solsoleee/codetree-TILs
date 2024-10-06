import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n, blockCount, maxBlockSize;
    static int[][] board;
    static boolean[][] visited;
    static int[][] deltas = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};  // 상하좌우 탐색

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(input.readLine());
        board = new int[n][n];
        visited = new boolean[n][n];

        // 입력 처리
        for (int i = 0; i < n; i++) {
            StringTokenizer tokens = new StringTokenizer(input.readLine());
            for (int j = 0; j < n; j++) {
                board[i][j] = Integer.parseInt(tokens.nextToken());
            }
        }

        // 블럭 개수와 최대 블럭 크기 구하기
        blockCount = 0;
        maxBlockSize = 0;

        // 모든 칸을 탐색하며 블럭 크기를 구함
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j]) {
                    int blockSize = dfs(i, j, board[i][j]);  // 블럭 크기 계산
                    if (blockSize >= 4) {
                        blockCount++;  // 4개 이상일 때만 블럭 카운트 증가
                        maxBlockSize = Math.max(maxBlockSize, blockSize);  // 최대 블럭 크기 갱신
                    }
                }
            }
        }

        // 결과 출력: 터질 블럭의 수와 최대 블럭 크기
        System.out.println(blockCount + " " + maxBlockSize);
    }

    // DFS 탐색을 통해 상하좌우로 같은 숫자 블럭의 크기를 계산
    static int dfs(int x, int y, int value) {
        visited[x][y] = true;  // 현재 칸 방문 처리
        int blockSize = 1;  // 현재 칸도 포함하므로 초기 크기는 1

        // 상하좌우로 탐색
        for (int[] delta : deltas) {
            int nx = x + delta[0];
            int ny = y + delta[1];

            // 범위 내에 있고, 방문하지 않았으며, 같은 값이면 재귀적으로 탐색
            if (nx >= 0 && nx < n && ny >= 0 && ny < n && !visited[nx][ny] && board[nx][ny] == value) {
                blockSize += dfs(nx, ny, value);  // 연결된 블럭 크기를 더함
            }
        }

        return blockSize;
    }
}