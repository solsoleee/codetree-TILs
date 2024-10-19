import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main{
    static StringTokenizer tokens;
    static boolean flag;
    static int n;
    static int res[];
    static int arr[] ={4,5,6};

    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(input.readLine());
        res = new int [n];
        permu(0);
    }

    //중복순열만들기
    static void permu(int cnt) {
        if(cnt == n) {
            if(check()) {
                for(int r: res)
                System.out.print(r);
                flag = true;
            }
            return;
        }
        for(int i=0; i<3; i++) {
            if(flag) break;
            res[cnt] = arr[i];
            permu(cnt+1);
        }
    }
    static boolean check() {

        for(int i=1; i<=(n+1)/2; i++) {
            //간격은 i
            String pre ="";
            for(int j=0; j<n; j+=i) {
                String str="";
                for(int k=j; k<j+i; k++) {
                    if(k<n) str += Integer.toString(res[k]);
                }
                if(pre.equals(str)) {
                    return false;
                }
                pre = str;

            }
        }
        return true;
    }

}