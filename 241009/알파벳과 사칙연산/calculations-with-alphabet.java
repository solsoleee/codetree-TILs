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
    static long maxVal = Long.MIN_VALUE;
    static String str[];

    public static void main(String[] args) throws IOException {
        str = input.readLine().split("");
        n = str.length/2 +1;
        res = new int [6];
        permutation(0);
        System.out.print(maxVal);
    }
    static void permutation(int cnt) {
        if(cnt == 6) {
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
        int sum = res[alpa(str[0].charAt(0))];
        for(int i=0; i<str.length; i++) {
            if(i%2==1) { //연산자일 때
                if(str[i].equals("-")) {
                    sum = sum - res[alpa(str[i+1].charAt(0))];
                } else if (str[i].equals("+")) {
                    sum = sum + res[alpa(str[i+1].charAt(0))];
                }
                else{
                    sum = sum * res[alpa(str[i+1].charAt(0))];
                }
            }
        }
        return sum;
    }

    static int alpa(char c) {
        if(c == 'a') return 0;
        else if (c=='b') {
            return 1;
        } else if (c=='c') {
            return 2;
        } else if (c=='d') {
            return 3;
        } else if (c=='e') {
            return 4;
        } else {
            return 5;
        }
    }

}