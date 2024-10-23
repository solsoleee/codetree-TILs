import java.io.*;
import java.util.*;

public class Main {
    static StringTokenizer tokens;
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder output = new StringBuilder();
    static int n,res;
    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(input.readLine());

        //1로 만드는데 최소 연산 횟수
        bfs();
        System.out.println(res);

    }
    static void bfs() {
        Queue<int []> que = new ArrayDeque<>();
        que.offer(new int[] {n, 0});
        while(!que.isEmpty()) {
            int t[] = que.poll();
            int x = t[0];
            int cnt = t[1];
            //System.out.println(x);
            if(x == 1){
                res = cnt;
                break;
            }
            que.offer(new int[] {x+1, cnt+1});
            que.offer(new int[] {x-1, cnt+1});
            if(x%2==0) que.offer(new int[] {x/2, cnt+1});
            if(x%3==0) que.offer(new int[] {x/3, cnt+1});
        }

    }
}