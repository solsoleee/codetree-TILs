import java.io.*;
import java.util.*;

public class Main {
    static StringTokenizer tokens;
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder output = new StringBuilder();
    static long n,res;
    static boolean visited[];
    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(input.readLine());
        visited = new boolean[1000001];
        //1로 만드는데 최소 연산 횟수
        bfs();
        System.out.println(res);

    }
    static void bfs() {
        Queue<long []> que = new ArrayDeque<>();
        que.offer(new long[] {n, 0});
        visited[(int)n] = true;
        while(!que.isEmpty()) {
            long t[] = que.poll();
            long x = t[0];
            long cnt = t[1];
            //System.out.println(x);
            if(x == 1) {
                res = cnt;
                break;
            }

            if(!visited[(int)x+1]) {
                que.offer(new long[] {x+1, cnt+1});
                visited[(int)x+1] = true;
            }
            if(!visited[(int)x-1]) {
                que.offer(new long[] {x-1, cnt+1});
                visited[(int)x-1] = true;
            }
            if(!visited[(int)x/2] && x%2==0) {
                que.offer(new long[] {x/2, cnt+1});
                visited[(int)x/2] = true;
            }
            if(!visited[(int)x/3] && x%3==0) {
                que.offer(new long[] {x/3, cnt+1});
                visited[(int)x/3] = true;
            }
        }

    }
}