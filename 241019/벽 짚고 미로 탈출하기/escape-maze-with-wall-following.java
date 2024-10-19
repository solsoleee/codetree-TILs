import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer tokens;
    static int n, r, c;
    static int[][] map;
    static boolean[][][] visited;
    static int[][] deltas = {{0, 1}, {-1, 0}, {0, -1}, {1, 0}}; // 우, 상, 좌, 하 (오른쪽부터 시계 방향)
    
    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(input.readLine());
        tokens = new StringTokenizer(input.readLine());
        r = Integer.parseInt(tokens.nextToken()) - 1;
        c = Integer.parseInt(tokens.nextToken()) - 1;
        
        map = new int[n][n];
        visited = new boolean[n][n][4];  // 각 칸에 대해 4방향 모두 방문 여부 체크
        
        for (int i = 0; i < n; i++) {
            String str = input.readLine();
            for (int j = 0; j < n; j++) {
                if (str.charAt(j) == '#') {
                    map[i][j] = 1;  // 벽
                } else {
                    map[i][j] = 0;  // 빈 공간
                }
            }
        }

        int time = 0;
        int d = 0; // 초기 방향: 오른쪽(0)
        boolean flag = true;

        while (true) {
            if (visited[r][c][d]) { // 이미 같은 방향으로 방문했으면 탈출 불가
                flag = false;
                break;
            }
            visited[r][c][d] = true;  // 방문 처리

            int nx = r + deltas[d][0];
            int ny = c + deltas[d][1];

            // 바라보고 있는 방향으로 이동할 수 없으면 반 시계 방향 회전
            if (!check(nx, ny)) {
                d = turnLeft(d);  // 반 시계 방향으로 회전
            }
            // 바라보는 방향으로 이동 가능하고 탈출 가능한 경우
            else if (escape(nx, ny)) {
                time++;  // 이동 시간 증가
                break;   // 탈출 성공
            }
            // 바라보는 방향으로 이동 가능하지만 탈출 불가한 경우
            else {
                r = nx;
                c = ny;
                time++;  // 이동 시간 증가
                // 오른쪽 벽이 있으면 계속 이동
                int rightDir = turnRight(d);
                int rx = r + deltas[rightDir][0];
                int ry = c + deltas[rightDir][1];
                
                // 오른쪽에 벽이 있다면 그대로 이동, 없으면 90도 시계 방향 회전 후 계속 진행
                if (!check(rx, ry)) {
                    d = turnRight(d);  // 시계 방향으로 회전
                }
            }
        }

        if (flag) {
            System.out.println(time);
        } else {
            System.out.println(-1);
        }
    }

    // 벽 또는 범위를 벗어나는지 체크
    static boolean check(int x, int y) {
        return (x >= 0 && x < n && y >= 0 && y < n && map[x][y] != 1);
    }

    // 반 시계 방향으로 90도 회전
    static int turnLeft(int d) {
        return (d + 3) % 4;
    }

    // 시계 방향으로 90도 회전
    static int turnRight(int d) {
        return (d + 1) % 4;
    }

    // 탈출 가능한지 확인 (격자 밖으로 나가는지 확인)
    static boolean escape(int x, int y) {
        return (x < 0 || x >= n || y < 0 || y >= n);
    }
}