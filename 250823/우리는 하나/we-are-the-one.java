import java.util.*;

public class Main {
    static int n, k, u, d;
    static int[][] grid;
    static boolean[][] seen;
    static final int[][] DIR = {{1,0},{-1,0},{0,1},{0,-1}};

    static boolean in(int x,int y){ return 0<=x && x<n && 0<=y && y<n; }

    static int bfsComp(int sx,int sy){
        int size = 0;
        Deque<int[]> q = new ArrayDeque<>();
        q.add(new int[]{sx,sy});
        seen[sx][sy] = true;
        while(!q.isEmpty()){
            int[] cur = q.poll();
            int x = cur[0], y = cur[1];
            size++;
            for(int[] dxy: DIR){
                int nx = x + dxy[0], ny = y + dxy[1];
                if(!in(nx,ny) || seen[nx][ny]) continue;
                int diff = Math.abs(grid[nx][ny] - grid[x][y]);
                if(u <= diff && diff <= d){
                    seen[nx][ny] = true;
                    q.add(new int[]{nx,ny});
                }
            }
        }
        return size;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt(); k = sc.nextInt(); u = sc.nextInt(); d = sc.nextInt();
        grid = new int[n][n];
        for(int i=0;i<n;i++) for(int j=0;j<n;j++) grid[i][j] = sc.nextInt();

        seen = new boolean[n][n];
        List<Integer> comps = new ArrayList<>();
        for(int i=0;i<n;i++)
            for(int j=0;j<n;j++)
                if(!seen[i][j]) comps.add(bfsComp(i,j));

        comps.sort(Collections.reverseOrder());
        long ans = 0;
        for(int i=0; i<Math.min(k, comps.size()); i++) ans += comps.get(i);
        System.out.println(ans);
    }
}
