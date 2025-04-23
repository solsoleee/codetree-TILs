import java.util.*;
public class Main {
    static int n,k,m;
    static int [][] grid;
    static int [][] res;
    static int [][] startPoints;
    static int [][] copyGrid;
    static int [][] deltas = {{0,1},{1,0},{0,-1},{-1,0}};
    static boolean visited [][];
    static List<int[]> stone;
    static int maxVal = Integer.MIN_VALUE;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();
        m = sc.nextInt();
        grid = new int[n][n];
        copyGrid = new int[n][n];
        visited = new boolean[n][n];
        stone = new ArrayList<>();
        res = new int[m][2];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = sc.nextInt();
                if(grid[i][j] == 1) {
                    stone.add(new int[]{i,j});
                }
            }
        }

        
        //System.out.println(Arrays.toString(stone.get(0)));
        startPoints = new int[k][2];
        for (int i = 0; i < k; i++) {
            startPoints[i][0] = sc.nextInt()-1;
            startPoints[i][1] = sc.nextInt()-1;
        }

        
        // Please write your code here.
        permu(0,0);
        System.out.println(maxVal);
    }
    //돌 중에서 m개를 조합으로 고름
    static void permu(int start, int depth) {
        if(depth == m ) {
            //여기서 bfs를 고름
            //System.out.println(Arrays.deepToString(res));
            //여기서 copyGrid의 위치가 1->0
            init(); //초기화
            for(int r[]: res) {
                copyGrid[r[0]][r[1]] = 0;
            }
            //bfs를 돌려서 최대값.
            

            int ans = bfs();
            maxVal = Math.max(maxVal, ans);
            

            return;
            
        }
        for(int i=start; i<stone.size(); i++) {
            int t[] = stone.get(i);
            res[depth][0] = t[0];
            res[depth][1] = t[1];
            permu(i+1, depth+1);
        }
    }


    //초기화 함수
    static void init() {
        for(int i=0; i<n; i++) {
            copyGrid[i] = Arrays.copyOf(grid[i],n);
        }
    }

    static boolean check(int x, int y) {
        return x>=0 && x<n && y>=0 && y<n;
    }

    static int bfs() {
        int cnt=0;
        Queue<int []> que = new ArrayDeque<>();
        for(int s[]:startPoints) {
            que.offer(new int[]{s[0],s[1]});
            visited[s[0]][s[1]] = true;
            cnt++;
        }

        
        while(!que.isEmpty()) {
            int t[] = que.poll();
            int dx = t[0];
            int dy = t[1];
            for(int d[]: deltas) {
                int nx = dx+d[0];
                int ny = dy+d[1];
                if(check(nx,ny) && !visited[nx][ny]) {
                    //돌이 아니고,
                    if(copyGrid[nx][ny]==0) {
                        que.offer(new int[]{nx,ny});
                        visited[nx][ny] = true;
                        cnt++;
                    }
  
                }

            }
        }
        return cnt;
    }
}