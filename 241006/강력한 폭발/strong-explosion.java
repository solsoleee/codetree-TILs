import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static StringTokenizer tokens;
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static int n,m;
    static int map[][];
    static int arr[];
    static List<int []> list= new ArrayList<>();
    static int maxVal = Integer.MIN_VALUE;
    static int deltas [][][] = { {{-2,0},{-1,0},{1,0},{2,0}}, { {-1,0},{0,-1},{0,1},{1,0} }, {{-1,-1}, {1,1},{1,-1}, {-1,1} }};
    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(input.readLine());

        map = new int [n][n];
        for(int i=0; i<n; i++) {
            tokens = new StringTokenizer(input.readLine());
            for(int j=0; j<n; j++) {
                map[i][j] = Integer.parseInt(tokens.nextToken());
                if(map[i][j] ==1 ) {
                    m++;
                    list.add(new int [] {i,j});
                }
            }
        }
        arr = new int [m];
        permutation(0);
        System.out.print(maxVal);
    }

    static void permutation(int cnt){
        if(cnt == m) {
            int c = bomb();
            maxVal = Math.max(maxVal, c);
            return;
        }
        for(int i=1; i<=3; i++) {
            arr[cnt] = i;
            permutation(cnt+1);
        }

    }

    //map 복사해서..... 폭탄 터뜨리기
    static int bomb() {
        int bombMap[][] = new int[n][n];
        for(int i=0; i<n; i++) {
            bombMap[i] = map[i].clone();
        }
        for(int i=0; i<m; i++) {
            int t[] = list.get(i);
            int x = t[0];
            int y = t[1];
            if(arr[i] == 1) {
                for(int d=0; d<4; d++){
                    int nx = x + deltas[0][d][0];
                    int ny = y + deltas[0][d][1];
                    if(nx >=0 && nx<n && ny>=0 && ny<n) {
                        bombMap[nx][ny] = 1;
                    }
                }
            }
            if(arr[i] == 2) {
                for(int d=0; d<4; d++){
                    int nx = x + deltas[1][d][0];
                    int ny = y + deltas[1][d][1];
                    if(nx >=0 && nx<n && ny>=0 && ny<n) {
                        bombMap[nx][ny] = 1;
                    }
                }
            }
            if(arr[i] == 3) {
                for(int d=0; d<4; d++){
                    int nx = x + deltas[2][d][0];
                    int ny = y + deltas[2][d][1];
                    if(nx >=0 && nx<n && ny>=0 && ny<n) {
                        bombMap[nx][ny] = 1;
                    }
                }
            }
        }
        int cnt = check(bombMap);
        return cnt;

    }

    static int check(int checkMap[][]) {
        int cnt=0;
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                if(checkMap[i][j] == 1) cnt++;
            }
        }
        return cnt;
    }

}