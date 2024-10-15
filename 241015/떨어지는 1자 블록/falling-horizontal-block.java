import java.util.*;
import java.io.*;

public class Main {
    static StringTokenizer tokens;
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static int n,m,k;
    static int [][]map;
    public static void main(String[] args) throws IOException {
        tokens = new StringTokenizer(input.readLine());
        n = Integer.parseInt(tokens.nextToken());
        m = Integer.parseInt(tokens.nextToken());
        k = Integer.parseInt(tokens.nextToken());
        map = new int [n][n];
        for(int i=0; i<n; i++) {
            tokens = new StringTokenizer(input.readLine());
            for(int j=0; j<n; j++) {
                map[i][j] = Integer.parseInt(tokens.nextToken());
            }
        }
        //시작부터 끝열
        int start = k-1;
        int end = k+m-1;
        boolean flag = true;
        for(int i=0; i<n; i++) {
            for(int j = start; j<end; j++) {
                if(!check(i,start, end)) {

                    flag = false;
                    break;
                }
            }
            if(!flag) {
                for(int j = start; j<end; j++) {
                    map[i][j] =1;
                }
                break; 
            }
        }
        if(flag) {
            for(int j = start; j<end; j++) {
                    map[n-1][j] =1;
                }
        }
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }

    }
    static boolean check(int row,  int start, int end)
     {
        //단 한 곳이라도 이미 격자판 위에 놓여있던 블럭과 맞닿게 된다거나 혹은 바닥에

            //내려오는 중
            //왼쪽 체크
            //왼쪽start
            if(start -1 >=0 && map[row][start-1] == 1) 
            {
                //System.out.println("zz1");
                return false;
            }
            if(end + 1 < n && map[row][end+1] == 1){                
                //System.out.println("zz2");
                return false;
            }
            for(int j = start; j<end; j++) {
                //여기에 있는.. 아래만 체크하면 될듯
                if(map[row+1][j] ==1) {
                    //System.out.println("zz3" +" "+row +" " +j);
                    return false;
                }
            }
        return true;
     }
}