import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer tokens;
    static int n,t,m;
    static int[][] map;
    static int[][] deltas= { {-1,0}, {1,0},{0,-1},{0,1} };
    static int [][] bead, newBead;

    public static void main(String[] args) throws IOException {
        tokens = new StringTokenizer(input.readLine());
        n = Integer.parseInt(tokens.nextToken());
        m = Integer.parseInt(tokens.nextToken());
        t = Integer.parseInt(tokens.nextToken());
        map = new int[n][n];
        bead = new int[n][n];


        for(int i=0; i<n; i++) {
            tokens = new StringTokenizer(input.readLine());
            for(int j=0; j<n; j++) {
                map[i][j] = Integer.parseInt(tokens.nextToken());
            }
        }

        for(int i=0; i<m; i++) {
            tokens = new StringTokenizer(input.readLine());
            int a = Integer.parseInt(tokens.nextToken())-1;
            int b = Integer.parseInt(tokens.nextToken())-1;
            bead[a][b] =1;
        }


        while(t-- >0) {
            //움직이고 -> 제거하고 ->  다시 bead업데이트
            newBead = new int [n][n];
            move();
            remove();
        }
        System.out.println(count());
    }

    static int count() {
        int sum=0;
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                if(bead[i][j] == 1) {
                    sum ++;
                }
            }
        }
        return sum;
    }

    //2 이상인거 제거하기
    static void remove() {
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                if(newBead[i][j] > 1) { //자리
                    newBead[i][j] =0;
                }
            }
        }
        bead = newBead;
    }


    //움직이기
    static void move() {
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                if(bead[i][j] ==1) { //자리
                    int r[] = find(i,j);
                    int x = r[0];
                    int y = r[1];
                    newBead[x][y] +=1;
                }
            }
        }

    }


    //가장 큰 값 찾기 상하좌우 중
    static int[] find(int x, int y) {
        int max = 0;
        int res[] = new int[2];
        for(int d[]: deltas) {
            int nx = x+d[0];
            int ny = y+d[1];
            if( check(nx,ny)  && max < map[nx][ny]) {
                res[0] = nx;
                res[1] = ny;
                max = map[nx][ny];
            }
        }
        return res;
    }


    static boolean check(int x, int y) {
        return x>=0 && x<n && y>=0 && y<n;
    }
}