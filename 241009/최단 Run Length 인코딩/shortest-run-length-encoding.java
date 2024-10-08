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

        String str[] = input.readLine().split("");
        int len = str.length;
        String temp[] = new String[len];

        //System.out.println(len);
        //길이 완전 탐색
        for(int i=0; i<len; i++) {
            //배열 바뀜
            for(int a=0; a< len-i; a++) {
                temp[a+i] = str[a];
            }

            String temp2[] = new String[i];
            for(int b=0; b<i; b++) {
                temp2[b] = str[len-i+b];
            }for(int c=0; c<i; c++) {
                String t = temp2[c];
                temp2[c] = temp2[i-c-1];
                temp2[i-c-1] = t;
            }
            for(int j=0; j<i; j++) {
                temp[j] = temp2[j];
            }

            //최종으로 만들어짐
            //System.out.println(Arrays.toString(temp));

            //문자열 합축하기
            String pre = temp[0];
            int cnt=1;
            String newStr="";
            for(int s=1; s<len; s++) {
                if(pre.equals(temp[s])) {
                    cnt+=1;
                }
                else{
                    //다른 순간
                    newStr += pre;
                    newStr += String.valueOf(cnt);
                    cnt=1;
                }
                pre = temp[s];
            }
            newStr += (pre + String.valueOf(cnt));
            minVal = Math.min(newStr.length(), minVal);

        }
        System.out.print(minVal);
    }
}