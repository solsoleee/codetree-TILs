import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static StringTokenizer tokens;
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static int n,m,q,r1,r2,c1,c2;
    static int map[][];
    public static void main(String[] args) throws IOException {
        tokens = new StringTokenizer(input.readLine());
        n = Integer.parseInt(tokens.nextToken());
        m = Integer.parseInt(tokens.nextToken());
        q = Integer.parseInt(tokens.nextToken());

        map = new int [n][m];

        for(int i=0; i<n; i++) {
            tokens = new StringTokenizer(input.readLine());
            for(int j=0; j<m; j++) {
                map[i][j] = Integer.parseInt(tokens.nextToken());
            }
        }
        if(q>0){
            tokens = new StringTokenizer(input.readLine());
            r1 = Integer.parseInt(tokens.nextToken())-1;
            c1 = Integer.parseInt(tokens.nextToken())-1;
            r2 = Integer.parseInt(tokens.nextToken())-1;
            c2 = Integer.parseInt(tokens.nextToken())-1;
            for(int i=0; i<q; i++){
                change();
                average();
            }

        }
        for(int row = 0; row < n; row++) {
            for(int col = 0; col < m; col++)
                System.out.print(map[row][col] + " ");
            System.out.println();
        }

    }

    static void change() {
        //박스 체인지
        int temp = map[r1][c2];
        int temp2 = map[r2][c2];

        //첫줄
        for(int i = c2; i>c1; i--){
            map[r1][i] = map[r1][i-1];
        }

        //오른쪽 열
        for(int i=r2; i>r1; i-- ){
            map[i][c2] = map[i-1][c2];
        }
        map[r1+1][c2]= temp;

        int temp4 = map[r2][c2];
        map[r2][c2] = temp2;
        //맨 아래줄

        int temp3 = map[r2][c1];
        for(int i=c1; i<c2; i++) {
            map[r2][i] = map[r2][i+1];
        }
        map[r2][c2] = temp4;

        for(int i=r1; i<r2-1; i++) {
            map[i][c1] = map[i+1][c1];
        }
        map[r2-1][c1] = temp3;
    }
    static void average(){
        int[][]copyMap = new int[n][m];
        for(int i=0; i<n; i++) {
            copyMap[i] = map[i].clone();
        }
        int deltas[][] ={{0,1},{1,0},{-1,0},{0,-1}};
        int cnt;
        int sum;
        for(int i=r1; i<=r2; i++) {
            for(int j=c1; j<=c2; j++) {
                cnt =1;
                sum =map[i][j];
                for(int d[] : deltas) {
                    int nx = i + d[0];
                    int ny = j +d[1];
                    if(nx>=0 && nx<n && ny>=0 && ny<m) {
                        cnt++;
                        sum += map[nx][ny];
                    }
                }
                copyMap[i][j] = sum/cnt;
            }
        }
        for(int i=0; i<n; i++) {
            map[i] = copyMap[i].clone();
        }
    }
}