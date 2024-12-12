import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer tokens;
    public static void main(String[] args) throws IOException {
        // 여기에 코드를 작성해주세요.
        tokens = new StringTokenizer(input.readLine());
        int x = Integer.parseInt(tokens.nextToken());
        int y = Integer.parseInt(tokens.nextToken());
        int res=0;
        for(int i=x; i<=y; i++) {
            //각 숫자별로 배열에 저장
            int digit[] = new int [10];
            boolean flag = false;
            int num = i;
            int cnt=0;
            while(num > 0) {
                digit[num%10]++;
                num = num/10;
                cnt++;
            }
            //digit에 cnt-1만큼 1개, 1만큼 1개
            for(int j=0; j<10; j++) {
                if(digit[j] == cnt-1) flag = true;
            }
            if(flag) res++;
        }
        System.out.println(res);
    }
}