import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static StringTokenizer tokens;
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder output = new StringBuilder();
    static int n, c;
    static int[][] map, arr, dist;
    static int[][] res;
    static boolean[] visited;
    static int minVal = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(input.readLine());
        map = new int[n][n];
        dist = new int[2][2];
        // 맵을 입력받아 처리
        for (int i = 0; i < n; i++) {
            String str = input.readLine();
            for (int j = 0; j < n; j++) {
                if (str.charAt(j) == '.') map[i][j] = -1;
                else if (str.charAt(j) == 'S') {
                    map[i][j] = 0;
                    dist[0][0] = i;
                    dist[0][1] = j;
                }
                else if (str.charAt(j) == 'E') {
                    map[i][j] = 10;
                    dist[1][0] = i;
                    dist[1][1] = j;
                }
                else {
                    map[i][j] = str.charAt(j) - '0';
                    c++;
                }
            }
        }

        // 동전 개수가 3개 미만인 경우 처리
        if (c < 3) {
            System.out.print(-1);
            System.exit(0);
        }

        // 배열 초기화
        res = new int[3][3];
        arr = new int[c][3];
        visited = new boolean[c];

        // 동전을 오름차순으로 집어넣기
        // 동전 좌표 및 값을 arr에 저장
        int size = 0;
        for(int k=1; k<=9; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (map[i][j] == k) {
                        arr[size][0] = i;
                        arr[size][1] = j;
                        arr[size][2] = k;
                        size++;
                    }
                }
            }
        }

        // 동전 배열 확인
        //System.out.println("동전 배열: " + Arrays.deepToString(arr));

        // 조합 만들기
        combi(0, 0);
        System.out.print(minVal);
    }

    // 조합 만들기
    static void combi(int start, int cnt) {
        if (cnt == 3) {
            // 조합된 결과 확인
            //System.out.println(Arrays.deepToString(res));
            int c = cal();
            minVal = Math.min(c, minVal);
            return;
        }

        // 조합 생성
        for (int i = start; i < c; i++) {
            if (!visited[i]) {
                visited[i] = true;
                res[cnt][0] = arr[i][0]; // 행
                res[cnt][1] = arr[i][1]; // 열
                res[cnt][2] = arr[i][2]; // 동전 값
                combi(i + 1, cnt + 1);
                visited[i] = false;
            }
        }
    }

    static int cal() { //거리 계산
        int sum = 0;
        sum+=Math.abs(dist[0][0] - res[0][0]) + Math.abs(dist[0][1] - res[0][1]);
        for(int i=0; i<2; i++) {
            sum+=Math.abs(res[i][0] - res[i+1][0]) + Math.abs(res[i][1] - res[i+1][1]);
        }
        sum+=Math.abs(dist[1][0] - res[2][0]) + Math.abs(dist[1][1] - res[2][1]);

        return sum;
    }


}