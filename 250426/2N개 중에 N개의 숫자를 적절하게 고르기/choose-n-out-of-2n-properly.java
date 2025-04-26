import java.util.*;
public class Main {
    static int n;
    static int [] arr;
    static int [] res;
    static int [] index;
    static boolean visited[];
    static int minVal = Integer.MAX_VALUE;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        arr = new int[2 * n];
        res = new int [n];
        index = new int [2*n];
        visited = new boolean[2*n];
        for (int i = 0; i < 2 * n; i++) {
            arr[i] = sc.nextInt();
            index[i] = i;
        }

        combi(0,0);
        System.out.println(minVal);

    }
    //조합
    static void combi(int start, int depth) {
        if(depth == n) {
            //System.out.println(Arrays.toString(res));
            visited = new boolean[2*n];
            int A=0;
            int B=0;
            for(int i=0; i<n; i++) {
                visited[res[i]] = true;
            }
            for(int i=0; i<2*n; i++) {
                if(visited[i]) A+=arr[i];
                else B+=arr[i];
            }
            int ans = Math.abs(A-B);
            minVal = Math.min(ans, minVal);
            return;
        }
        for(int i=start; i<2*n; i++) {
            res[depth] = index[i];
            combi(i+1, depth+1);
            //visited[depth] = false;
        }

    }
}