import java.util.*;
public class Main {
    static int n;
    static int [][]grid;
    static int maxVal = Integer.MIN_VALUE;
    static int deltas[][] = {{0,1},{1,0},{-1,0},{0,-1}};
    static int d;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        grid = new int[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                grid[i][j] = sc.nextInt();
        // Please write your code here.
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                if(j==0) {
                    d=0;
                    int c = go(i,j);
                    maxVal = Math.max(maxVal, c);
                    //System.out.println(go(i,j));
                }
                if(i==0) {
                    d=1;
                    int c = go(i,j);
                    maxVal = Math.max(maxVal, c);
                }
                if(j==n-1) {
                    d=3;
                    int c = go(i,j);
                    maxVal = Math.max(maxVal, c);
                }
                if(i==n-1){
                    d=2;
                    int c = go(i,j);
                    maxVal = Math.max(maxVal, c);
                }
            }
        }
        System.out.println(maxVal);
    }
    static boolean check(int x, int y) {
        return x>=0 && x<n && y>=0 && y<n;
    }
    static int  go(int x, int y) {
        //그 방향에서 움직이는
        int dx = x;
        int dy = y;
        int cnt = 1;
        while(true) { //범위 안에 있으면
            move(dx,dy);
            dx = dx + deltas[d][0];
            dy = dy + deltas[d][1];
            if(!check(dx, dy)) break;
            //System.out.println(dx +" " + dy);
            cnt++;
        }
        cnt++;
        return cnt;
    }

    static void move(int x, int y) {
        if(grid[x][y]== 1) {
            //현재 방향
            d=(d+2)%4;

        }
        else if(grid[x][y]== 2) {
            //현재 방향
            if(d==1) d=0;
            else if(d==2) d=3;
            else if(d==3) d=2;
            else if(d==0) d=1;

        }
        else {
            d=d;
        }
    }
}