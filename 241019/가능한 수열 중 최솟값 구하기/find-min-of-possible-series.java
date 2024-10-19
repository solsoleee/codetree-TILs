import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
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
                for(int r: res) {
                    System.out.print(r);
                }
                System.exit(0);
            }


        for(int i=0; i<3; i++) {
            res[cnt] = arr[i];
            if(check(cnt+1)) { //가능할 때만
                permu(cnt+1);
            }
        }
    }
    static boolean check(int length) {
        //가장 최근에 추가한 숫자로 인해 중복이 발생하는지
        for(int len =1; len<=length/2; len++) {
            boolean flag = true;
            for(int i=0; i<len; i++) {
                if(res[length-len+i] != res[length-2*len+i]) {
                    flag = false;
                    break;
                }
            }
            if(flag) return false; //중복 발견
        }
        return true;
    }

}