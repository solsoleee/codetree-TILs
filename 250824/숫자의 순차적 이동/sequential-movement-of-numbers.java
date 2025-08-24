import java.util.*;

public class Main {
    static int n, m;
    static int[][] grid;
    // 8방 (원하는 우선순서로 두면 tie-breaker가 됨)
    static int[][] D8 = {{-1,-1},{-1,0},{-1,1},{0,-1},{0,1},{1,-1},{1,0},{1,1}};

    static boolean in(int x,int y){ return 0<=x && x<n && 0<=y && y<n; }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        grid = new int[n][n];

        // 값이 1..n^2 라고 가정 (문제 조건)
        int maxV = n*n;
        int[] px = new int[maxV+1];
        int[] py = new int[maxV+1];

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                grid[i][j] = sc.nextInt();
                int v = grid[i][j];
                px[v] = i; py[v] = j;   // 값 v의 현재 위치 기록
            }
        }

        // m 턴 반복
        while(m-- > 0){
            for(int v=1; v<=maxV; v++){
                int x = px[v], y = py[v];

                // 8방 중 최댓값 칸 찾기
                int bx = x, by = y;
                int best = Integer.MIN_VALUE;
                for(int[] d : D8){
                    int nx = x + d[0], ny = y + d[1];
                    if(!in(nx,ny)) continue;
                    int w = grid[nx][ny];
                    if(w > best){
                        best = w; bx = nx; by = ny;
                    }
                }

                // 스왑
                int w = grid[bx][by];   // 이웃 칸의 값
                if (bx==x && by==y) continue; // (이웃이 없을 일은 없지만 안전하게)

                grid[bx][by] = v;
                grid[x][y]   = w;

                // 위치 갱신 (값 v와 값 w의 좌표를 서로 교환)
                px[v] = bx; py[v] = by;
                px[w] = x;  py[w] = y;
            }
        }

        // 출력 형식은 문제 요구대로
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }
    }
}
