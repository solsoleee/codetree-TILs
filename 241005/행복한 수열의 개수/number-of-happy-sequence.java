import java.io.*;
import java.util.*;

public class Main {

    static StringTokenizer tokens;
    static int n,m;
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException{
        // 여기에 코드를 작성해주세요.
        tokens = new StringTokenizer(input.readLine());
        n = Integer.parseInt(tokens.nextToken());
        m = Integer.parseInt(tokens.nextToken());
        int array[][] = new int [n][n];
        for(int i=0; i<n; i++) {
            tokens = new StringTokenizer(input.readLine());
            for(int j=0; j<n; j++) {
                array[i][j] =Integer.parseInt(tokens.nextToken());
            }
        }
        int row = rowCheck(array);
        int col = colCheck(array);

        System.out.println(row+col);
    }

    public static int rowCheck(int arr[][]){
        int pre;
        int cnt;
        int res=0;
        for(int i=0; i<n; i++) {
            cnt = 1;
            pre = arr[0][i];
            for(int j=1; j<n; j++) {
                if(arr[j][i] == pre) {
                    cnt ++;
                }
                else{
                    cnt = 1;
                }
                if(cnt >=m) {
                    res++;
                    break;
                }   
                pre = arr[j][i];
            }
        }
        return res;
    }
        public static int colCheck(int arr[][]){
        int pre;
        int cnt;
        int res=0;
        for(int i=0; i<n; i++) {
            cnt = 1;
            pre = arr[i][0];
            for(int j=1; j<n; j++) {
                if(arr[i][j] == pre) {
                    cnt ++;
                    //System.out.println(pre +" " + arr[i][j]);
                }
                else{
                    cnt = 1;
                }
                if(cnt >=m) {
                    res++;
                    break;
                }
                pre = arr[i][j];
            }
        }
        return res;
    }
}