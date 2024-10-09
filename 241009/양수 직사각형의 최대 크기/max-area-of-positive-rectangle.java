import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static StringTokenizer tokens;
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static int n,m;
    static int maxVal = Integer.MIN_VALUE;
    static int map[][];

    public static void main(String[] args) throws IOException {
        tokens = new StringTokenizer(input.readLine());
        n = Integer.parseInt(tokens.nextToken());
        m = Integer.parseInt(tokens.nextToken());
        map = new int [n][m];
        for(int i =0 ; i<n; i++) {
            tokens = new StringTokenizer(input.readLine());
            for(int j=0; j<m; j++) {
                map[i][j] = Integer.parseInt(tokens.nextToken());
            }
        }

        rectangle();
        if(maxVal ==0 ) System.out.println(-1);
        else System.out.println(maxVal);

    }
    static void rectangle() {
        //왼쪽 끝점
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {

                //오른쪽 끝점
                for(int a=i; a<n; a++) {
                    for(int b=j; b<m; b++) {

                        boolean flag = true;
                        for(int r1=i; r1<=a; r1++) {
                            if(!flag) break;
                            for(int c1=j; c1<=b; c1++) {
                                if (map[r1][c1] < 0)  {
                                    flag = false;
                                    break;
                                }
                            }
                        }
                        int val=0;
                        if(flag) {
                            val= (a-i+1)*(b-j+1);
                        }
                        maxVal = Math.max(maxVal, val);
                    }
                }
            }
        }
    }

}