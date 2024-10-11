import java.util.*;
import java.io.*;

public class Main{
    
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer tokens;
    static int n;
    static int []arr;
   
    public static void main(String[] args) throws IOException{
        
        n = Integer.parseInt(input.readLine());
        arr = new int[n];
        for(int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(input.readLine());
        }
        

        for(int i=0; i<2; i++) {
            tokens = new StringTokenizer(input.readLine());
            int a = Integer.parseInt(tokens.nextToken());
            int b = Integer.parseInt(tokens.nextToken());
            block(a,b);
        }
        System.out.println(n);
        for(int i=0; i<n; i++) {
            System.out.println(arr[i]);
        }
        
    }

    static void block(int s, int e) {
        int [] temp = new int [n];
        int len = 0;

        for(int i=0; i<n; i++) {
            //구간을 제외하고 담아줌
            if(i< (s-1) || i> (e-1) ) {
                temp[len++] = arr[i];
            }
        }
        arr = temp;
        n=len;
        
    }
}