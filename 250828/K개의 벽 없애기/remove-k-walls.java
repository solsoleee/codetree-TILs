import java.util.*;

public class Main {
    static int n;
    static int k;
    static int [][] grid;
    static int r1;
    static int r2;
    static int c1;
    static int c2;
    static int cnt;
    static int res[]; //선택된거
    static List<int[]> list = new ArrayList<>();
    static int deltas[][] = {{1,0}, {0,1}, {-1,0}, {0,-1}};
    static boolean visited[][];
    static int[][] gridTest;
    static int ans=Integer.MAX_VALUE;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();
        grid = new int[n][n];
        gridTest = new int[n][n];
        res = new int[k];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = sc.nextInt();
                if(grid[i][j] == 1)  {
                    list.add(new int[]{i, j});
                    cnt++;
                }
                
            }
        }
        r1 = sc.nextInt()-1;
        c1 = sc.nextInt()-1;
        r2 = sc.nextInt()-1;
        c2 = sc.nextInt()-1;
        combi(0,0);
        if(Integer.MAX_VALUE == ans) System.out.println(-1);
        else System.out.println(ans);
        // Please write your code here.
    }

    //벽 초기화
    static void init() {
        for(int i=0; i<n; i++) {
            gridTest[i] = grid[i].clone();
        }
        //벽 부수기
        for(int i=0; i<k; i++) {
            gridTest[list.get(res[i])[0]][list.get(res[i])[1]] = 0;
        }
        visited = new boolean[n][n];
    }

    //벽을 부스고 도착할 때 최종 시간
    static int bfs(int x, int y) {
        int fTime=Integer.MAX_VALUE;
        visited[x][y] = true;
        Queue<int []> que = new ArrayDeque<>();
        que.offer(new int[] {x,y,1});

        while(!que.isEmpty()) {
            int t[] = que.poll();
            int dx = t[0];
            int dy = t[1];
            int time = t[2];
            for(int d[]: deltas) {
                int nx = dx + d[0];
                int ny = dy + d[1];
                
                if(check(nx, ny) && !visited[nx][ny]) {
                    if(gridTest[nx][ny] == 0) {
                        //System.out.println(nx+" "+ny +" "+time);
                        if(nx == r2 && ny == c2) {
                            visited[nx][ny] = true;
                            fTime = time;
                            break;
                        }
                        que.offer(new int[]{nx,ny,time+1});
                        visited[nx][ny] = true;
                    }
                }
            }

        }
        return fTime;
    }

    //k를 고를 조합
    static void combi(int start, int depth) {
        if(depth == k) {
            // for(int r: res) {
            //     System.out.print(Arrays.toString(list.get(r))+" ");
            // }
            init(); //초기화
            
            int b = bfs(r1, c1);
            if(visited[r2][c2]) {
                //System.out.println(Arrays.deepToString(gridTest));
                ans = Math.min(ans, b);
            }
            
            return;
        }
        for(int i=start; i<cnt; i++) {
            res[depth] = i;
            combi(i+1, depth+1);
        }
    }
    static boolean check(int x, int y) {
        return x>=0 && x<n && y>=0 && y<n;
    }
}