import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static StringTokenizer tokens;
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static int res[];
    static int arr[] ={1,2,3,4};
    static int n;
    static long maxVal = Integer.MIN_VALUE;
    static String str[];

    public static void main(String[] args) throws IOException {
        str = input.readLine().split("");
        n = str.length/2 +1;
        res = new int [n];
        permutation(0);
        System.out.print(maxVal);
    }
    static void permutation(int cnt) {
        if(cnt == n) {
            //res의 결과
            long c = calc();
            maxVal = Math.max(maxVal, c);
            return;
        }
        for(int i=0; i<4; i++) {
            res[cnt] = arr[i];
            permutation(cnt+1);
        }
    }

    static long calc() {
        int idx=0;
        for(int i=0; i< str.length; i+=2) { //짝수만
            str[i] = String.valueOf(res[idx]);
            idx++;
        }
        //str 가지고 계산하기
        long sum = Integer.parseInt(str[0]);
        for(int i=1; i<str.length-1; i++) {
            if(i%2==1) { //연산자일 때
                if(str[i].equals("-")) {
                    sum = sum - Integer.parseInt(str[i+1]);
                } else if (str[i].equals("+")) {
                    sum = sum + Integer.parseInt(str[i+1]);
                }
                else{
                    sum = sum * Integer.parseInt(str[i+1]);
                }
            }
        }
        return sum;
    }



}