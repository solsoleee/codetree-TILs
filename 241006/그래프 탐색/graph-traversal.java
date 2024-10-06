import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static StringTokenizer tokens;
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static int n,m;
    static boolean visited[];
    static List<Integer> [] graph;
    static HashSet<Integer> res;


    public static void main(String[] args) throws IOException {
        tokens = new StringTokenizer(input.readLine());
        n = Integer.parseInt(tokens.nextToken());
        m = Integer.parseInt(tokens.nextToken());
        graph = new ArrayList[n+1];
        res = new HashSet<>();
        visited = new boolean[n+1];

        for(int i=0; i<=n; i++) {
            graph[i] = new ArrayList<>();
        }

        for(int i=0; i<m; i++) {
            tokens = new StringTokenizer(input.readLine());
            int a = Integer.parseInt(tokens.nextToken());
            int b = Integer.parseInt(tokens.nextToken());
            graph[a].add(b);
            graph[b].add(a);
        }
        res.add(1); //1번부터 시작
        visited[1] = true;
        dfs(1, 1);
        System.out.print(res.size()-1);
    }
    static void dfs(int start, int cnt) {
        if(cnt == n) {
            return;
        }

        for(int next: graph[start]) {
            if(!visited[next]){
                visited[next] = true;
                res.add(next);
                dfs(next, cnt+1);
            }
        }
    }


}