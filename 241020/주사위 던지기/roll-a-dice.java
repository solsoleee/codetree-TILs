import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static StringTokenizer tokens;
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static int n,m,r,c;
    static int [][]map;
    static String []command;
    static int [][] dice = { {0,1,0}, {4,5,3}, {0,6,0}, {0,2,0} };
    public static void main(String[] args) throws IOException {
        tokens = new StringTokenizer(input.readLine());
        n = Integer.parseInt(tokens.nextToken());
        m = Integer.parseInt(tokens.nextToken());
        r = Integer.parseInt(tokens.nextToken())-1;
        c = Integer.parseInt(tokens.nextToken())-1;
        map = new int [n][n];
        command = new String [m];
        tokens = new StringTokenizer(input.readLine());
        for(int i=0; i<m; i++) {
            command[i] = tokens.nextToken();
        }
        map[r][c] = dice[2][1]; //초기

        for(String s: command) {
            //왼쪽
            if(s.equals("L")) {
                left(); //주사위 돌리기
                int nx = r;
                int ny = c - 1;
                if (check(nx, ny)) {
                    map[nx][ny] = dice[2][1]; //아랫면 숫자
                    r = nx;
                    c = ny;
                }
            }
            else if(s.equals("R")) {
                    right();
                    int nx = r;
                    int ny = c+1;
                if (check(nx, ny)) {
                    map[nx][ny] = dice[2][1]; //아랫면 숫자
                    r = nx;
                    c = ny;
                }
            }
            else if(s.equals("U")) {
                up();
                int nx = r-1;
                int ny = c;
                if (check(nx, ny)) {
                    map[nx][ny] = dice[2][1]; //아랫면 숫자
                    r = nx;
                    c = ny;
                }
            }
            else {
                down();
                int nx = r+1;
                int ny = c;
                if (check(nx, ny)) {
                    map[nx][ny] = dice[2][1]; //아랫면 숫자
                    r = nx;
                    c = ny;
                }
            }

        }
        int res = totalSum();
        System.out.print(res);

    }

    static int totalSum() {
        int sum =0;
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                sum +=map[i][j];
            }
        }
        return sum;
    }
    static boolean check(int x, int y) {
        return x>=0 && x<n && y>=0 && y<n;
    }

    //D
    static void down() {
        int temp = dice[0][1];
        dice[0][1] = dice[1][1];
        dice[1][1] = dice[2][1];
        dice[2][1] = dice[3][1];
        dice[3][1] = temp;
    }


    //U
    static void up() {
        int temp = dice[3][1];
        dice[3][1] = dice[2][1];
        dice[2][1] = dice[1][1];
        dice[1][1] = dice[0][1];
        dice[0][1] = temp;
    }

    //L
    static void left() {
        int temp = dice[2][1];
        dice[2][1] = dice[1][0];
        dice[1][0] = dice[0][1];
        dice[0][1] = dice[1][2];
        dice[1][2] = temp;
    }
    //R
    static void right() {
        int temp = dice[2][1];
        dice[2][1] = dice[1][2];
        dice[1][2] = dice[0][1];
        dice[0][1] = dice[1][0];
        dice[1][0] = temp;
    }

}