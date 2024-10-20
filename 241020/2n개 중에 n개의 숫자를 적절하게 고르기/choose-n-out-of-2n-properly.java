import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static StringTokenizer tokens;
    static int n,sum;
    static boolean visited[];
    static int arr[];
    static int []one;
    static int minVa = Integer.MAX_VALUE;
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {

        n = Integer.parseInt(input.readLine());
        arr = new int [2*n];
        one = new int [n];

        visited = new boolean[2*n];
        tokens = new StringTokenizer(input.readLine());
        for(int i=0; i<2*n; i++) {
            arr[i] = Integer.parseInt(tokens.nextToken());
            sum+=arr[i];
        }
        combi(0,0);
        System.out.print(minVa);

    }

    static void combi(int start, int cnt) {
        if(cnt == n) {
            int c = cal();
            minVa = Math.min(minVa, c);
            return;
        }
        for(int i=start; i<2*n; i++) {
            visited[cnt] = true;
            one[cnt] = arr[i];
            combi(i+1, cnt+1);
            visited[cnt] = false;
        }
    }

    //두 그룹의 원소의 합의 차를 구함
    static int cal() {
        int sumOne = 0;
        int sumTwo = 0;
        for(int o: one) {
            sumOne+=o;
        }
        sumTwo = sum-sumOne;
        return Math.abs(sumTwo-sumOne);
    }
}