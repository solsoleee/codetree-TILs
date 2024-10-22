import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer tokens;
    static int n,t,m;
    static int[][] map;
    static int[][] deltas= { {-1,0}, {1,0},{0,-1},{0,1} };
    static int [][] bead;

    public static void main(String[] args) throws IOException {
        tokens = new StringTokenizer(input.readLine());
        n = Integer.parseInt(tokens.nextToken());
        m = Integer.parseInt(tokens.nextToken());
        t = Integer.parseInt(tokens.nextToken());
        map = new int[n][n];
        bead = new int[m][3];

        for(int i=0; i<n; i++) {
            tokens = new StringTokenizer(input.readLine());
            for(int j=0; j<n; j++) {
                map[i][j] = Integer.parseInt(tokens.nextToken());
            }
        }

        for(int i=0; i<m; i++) {
            tokens = new StringTokenizer(input.readLine());
            bead[i][0] = Integer.parseInt(tokens.nextToken())-1;
            bead[i][1] = Integer.parseInt(tokens.nextToken())-1;
            bead[i][2] = 0; //기본은 0
        }
        while(t-- >0) {
            move();
            //System.out.println(Arrays.deepToString(bead));

        }
        System.out.println(m);



    }

    //상하좌우 큰거중에 움직이는거
    static void move() {
        int b=0;
        for(int be[]: bead) {
            if(be[2] == 1) continue;
            int max = 0; // 상하좌우 중에 큰거
            int i = 0; //델타인덱스
            int index=0; //결정
            for(int d[]: deltas) {
                int nx = be[0] + d[0];
                int ny = be[1] + d[1];
                if(check(nx,ny) && max < map[nx][ny]) {
                    //상하좌우 중에 가장 큰거 체크
                    index = i;
                    max = map[nx][ny];
                }
                i++;
            }
            //여기서 겹치는지 아닌지 확인
            be[0] = be[0] + deltas[index][0];
            be[1] = be[1] + deltas[index][1];
            for(int a=0; a<m; a++) {
                if(a == b) continue;
                if(bead[a][2] == 1 ) continue;
                if(bead[a][0] == be[0] && bead[a][1] == be[1]) {
                    m-=2;
                    bead[a][2]=1;
                    be[2]=1;
                }
            }
            b++;
        }
    }


    static boolean check(int x, int y) {
        return x>=0 && x<n && y>=0 && y<n;
    }
}