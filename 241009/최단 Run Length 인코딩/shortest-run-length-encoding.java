import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static StringTokenizer tokens;
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static int minVal = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {

        String str = input.readLine();
        String newS = "";
        int n = str.length();
        for(int i=0; i<n; i++) {
            newS = str.substring(n-1-i) + str.substring(0,n-1-i);
            //문자열 합축하기
            char pre = newS.charAt(0);
            int cnt=1;
            String newStr="";
            for(int s=1; s<n; s++) {
                if(pre == newS.charAt(s)) {
                    cnt+=1;
                }
                else{
                    //다른 순간
                    newStr += pre;
                    newStr += String.valueOf(cnt);
                    cnt=1;
                }
                pre = newS.charAt(s);
            }
            newStr += (pre + String.valueOf(cnt));
            minVal = Math.min(newStr.length(), minVal);

        }
        System.out.print(minVal);
        }
}