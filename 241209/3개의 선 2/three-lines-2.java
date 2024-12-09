import java.util.*;
import java.io.*;
public class Main {
    static StringTokenizer tokens;
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static boolean []visited;
    static int []res;
    static int n;
    static int x[];
    static int y[];
    static boolean flag;
    public static void main(String[] args) throws IOException {
        // 여기에 코드를 작성해주세요.
        visited = new boolean[22];
        res = new int[3];
        n = Integer.parseInt(input.readLine());
        x = new int [n];
        y = new int [n];
        for(int i=0; i<n; i++) {
            tokens = new StringTokenizer(input.readLine());
            int xi = Integer.parseInt(tokens.nextToken());
            int yi = Integer.parseInt(tokens.nextToken());
            x[i] = xi;
            y[i] = yi+11;
        }

        combi(0,0);
        if(flag) System.out.println(1);
        else System.out.println(0);
    }


    //조합, 직선 3개 고르기 11이 넘어가면 %11하고 y축임
    static void combi(int cnt, int start) {
        
        if(cnt == 3) {
            if(flag) return;
            //모든 점을 검사 
            if(check()) {
                //System.out.println(Arrays.toString(res));
                flag = true;
            }
            return;
        }
        for(int i=start; i<22; i++) {
            if(!visited[i] && !flag) {
                visited[i] = true;
                res[cnt] = i;
                combi(cnt+1, i+1);
                visited[i] = false;
            }
        }
    }
    static boolean check() {
        //직선에 대한 모든 점 확인
        for(int i=0; i<n; i++) {
            boolean sign = false;
            for(int r: res) {
                if(r == x[i] || r==y[i]) {
                    sign = true;
                    break;
                } 
            }
            if(!sign) return false; //직선 만족 못함
        }
        return true;
    }
}