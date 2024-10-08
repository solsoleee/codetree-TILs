import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static StringTokenizer tokens;
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static int n;
    static int maxVal = Integer.MIN_VALUE;
    static int map[][];
    static int arr[] = new int [4];
    static int deltas[][] ={{-1,1}, {-1,-1}, {1,-1}, {1,1}};
    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(input.readLine());
        map = new int[n][n];
        for(int i=0; i<n; i++) {
            tokens = new StringTokenizer(input.readLine());
            for(int j=0; j<n; j++) {
                map[i][j] = Integer.parseInt(tokens.nextToken());
            }
        }
        for(int i=2; i<n; i++) {
            for(int j=1; j<n; j++) {
                rectangle(i,j);
            }
        }
        System.out.println(maxVal);
    }
    //직사각형 모양 결정
    static void rectangle(int x1, int y1) {
        //arr대로 반복 개수를 정하기
        for(int k=1; k<n; k++ ) {
            for(int l=1; l<n; l++) {
                boolean flag = true;
                int sum=0;
                int x = x1;
                int y = y1;
                arr[0] = k;
                arr[1] = l;
                arr[2] = k;
                arr[3] = l;
                for(int d=0; d<4; d++) {
                    if(!flag) break;
                    for(int r=1; r<=arr[d]; r++) {
                        int nx = x+deltas[d][0];
                        int ny = y+deltas[d][1];
                        if(!check(nx,ny)) {
                            flag = false;
                            break;
                        }
                        sum += map[nx][ny];
                        x = nx;
                        y = ny;
                    }
                }
                maxVal = Math.max(sum,maxVal);
            }
        }
    }

    //범위를 판별
    static boolean check(int x, int y) {
        return (x >=0 && x<n && y>=0 && y<n);
    }
}