import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static StringTokenizer tokens;
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static int n,res;
    static int arr[];
    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(input.readLine());
        arr = new int [n];

        permu(0);
        System.out.println(res);

    }

    static boolean check() {
        for(int i=0; i<n; i+=arr[i]) {

            if(i+arr[i]-1 >=n) { //범위를 벗어남
                return false;
            }
            for(int j=i; j<i+arr[i]; j++) {
                if(arr[i] != arr[j]) return false;
            }
        }
        return true;
    }
    static void permu(int cnt) {
        if(cnt == n) {
            //아름다운 수인지 아닌지 확인
            if(check()) res++;
            return;
        }

        for(int i=1; i<=4; i++) {
            arr[cnt] = i;
            permu(cnt+1);
        }
    }
}