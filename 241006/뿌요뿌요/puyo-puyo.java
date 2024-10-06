import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int[][] board;
    static boolean[][] visited;
    static int[][] deltas = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};  // 상하좌우 방향
    static int blockCount, maxBlockSize;

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(input.readLine());
        board = new int[n][n];
        visited = new boolean[n][n];

        // 격자 입력 받기
        for (int i = 0; i < n; i++) {
            StringTokenizer tokens = new StringTokenizer(input.readLine());
            for (int j = 0; j < n; j++) {
                board[i][j] = Integer.parseInt(tokens.nextToken());
            }
        }

        // 터질 블럭의 수와 최대 블럭 크기 구하기
        blockCount = 0;
        maxBlockSize = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j]) {
                    int blockSize = dfs(i, j, board[i][j]);  // 현재 위치에서 DFS 탐색
                    if (blockSize >= 4) {
                        blockCount++;  // 블럭 크기가 4 이상일 때만 터뜨림
                    }
                    maxBlockSize = Math.max(maxBlockSize, blockSize);  // 최대 블럭 크기 갱신
                }
            }
        }

        // 결과 출력
        System.out.println(blockCount + " " + maxBlockSize);
    }

    // DFS 탐색: x, y에서 시작하여 같은 숫자들로 이루어진 블럭의 크기 계산
    static int dfs(int x, int y, int value) {
        visited[x][y] = true;  // 방문 처리
        int blockSize = 1;  // 시작점 포함이므로 크기 1부터 시작

        // 상하좌우로 탐색
        for (int[] delta : deltas) {
            int nx = x + delta[0];
            int ny = y + delta[1];

            // 범위 내에 있고, 같은 숫자이며, 아직 방문하지 않은 칸일 때만 탐색
            if (nx >= 0 && nx < n && ny >= 0 && ny < n && !visited[nx][ny] && board[nx][ny] == value) {
                blockSize += dfs(nx, ny, value);  // 재귀 호출로 블럭 크기 누적
            }
        }

        return blockSize;  // 최종 블럭 크기 반환
    }
}