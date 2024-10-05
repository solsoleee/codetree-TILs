import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static StringTokenizer tokens;
    static StringBuilder output = new StringBuilder();
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static int n,m;
    static int map[][];
    public static void main(String[] args) throws IOException {
        tokens = new StringTokenizer(input.readLine());
        n = Integer.parseInt(tokens.nextToken());
        m =Integer.parseInt(tokens.nextToken());
        map = new int [n][n];
        for(int i=0; i<n; i++) {
            tokens = new StringTokenizer(input.readLine());
            for(int j=0; j<n; j++) {
                map[i][j] = Integer.parseInt(tokens.nextToken());
            }
        }

        int count;
        int maxVal = Integer.MIN_VALUE;
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {


                for(int r=0; r<n; r++) {
                    count=0;
                    int bill = r*r + (r+1) *(r+1);//비용 계산
                    for(int row = 0; row<n; row++) {
                        for(int col=0; col<n; col++ ) {
                            if( Math.abs(i-row) + Math.abs(j-col) <= r){
                                if(map[row][col] == 1) count++;
                            }
                        }
                    }
                    if(count * m > bill) {
                        maxVal = Math.max(maxVal, count);
                    }
                }

            }
        }
        System.out.print(maxVal);
    }

}