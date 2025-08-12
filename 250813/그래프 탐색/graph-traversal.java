import java.util.*;
public class Main {
    static boolean visited[];
    static int n;
    static int m;
    static List<Integer> [] grid;
    static int cnt;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        grid = new ArrayList[n+1];
        visited = new boolean[n+1];
        //초기화
        for(int i=0; i<n+1; i++) {
            grid[i] = new ArrayList<>();
        }

        int[] u = new int[m];
        int[] v = new int[m];
        for (int i = 0; i < m; i++) {
            u[i] = sc.nextInt();
            v[i] = sc.nextInt();
            grid[u[i]].add(v[i]);
            grid[v[i]].add(u[i]);
        }
        //System.out.println(Arrays.toString(grid));
        visited[1] = true;
        dfs(1);
        System.out.println(cnt);
    }
    static void dfs(int start) {
        //System.out.println(start);
        for(int i=0; i<grid[start].size(); i++) {
            if(!visited[grid[start].get(i)]) {
                visited[grid[start].get(i)] = true;
                dfs(grid[start].get(i));
                cnt++;
            }
        }
    }
    
}