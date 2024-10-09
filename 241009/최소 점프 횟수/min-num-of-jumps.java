import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static StringTokenizer tokens;
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static int n;
    static int minVal=Integer.MAX_VALUE;
    static int arr[], temp[];
    static boolean visited[];
    public static void main(String[] args) throws IOException {

        n = Integer.parseInt(input.readLine());
        arr = new int [n];
        visited = new boolean[n];
        tokens = new StringTokenizer(input.readLine());
        for(int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(tokens.nextToken());
        }
        temp = new int[n-2];
        for(int i=1; i<n-1; i++){
            temp[i-1] = arr[i];
        }
        subSet(0);
        if(minVal == Integer.MAX_VALUE) {
            System.out.println(-1);
        }
        else{
            System.out.println(minVal);
        }
    }
    static void subSet(int cnt) {
        if(cnt == n-2) {
            int c = check();
            if(c != -1) {
                minVal = Math.min(minVal, c);
            }
            return;
        }
        visited[cnt] = true;
        subSet(cnt+1);
        visited[cnt] = false;
        subSet(cnt+1);
    }
    //  범위 안에 맞는지 확인
    static int check() {
        int pre = arr[0] + 0;
        int sum = 2;
        for(int i=0; i<n-2; i++) {
            if(visited[i]){
                //여기서 범위 확인
                if(pre < i+1) {
                    return -1;
                }
                pre = i+1 + arr[i+1];
                sum++;
            }
        }
        //마지막것만 확인
        if(pre < n-1) return -1;
        return sum-1;
    }
}