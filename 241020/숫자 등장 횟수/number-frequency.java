import java.util.*;
import java.io.*;

public class Main {

    static StringTokenizer tokens;
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException{
        
        Map<Integer,Integer> map = new HashMap<>();
        tokens = new StringTokenizer(input.readLine());
        int n = Integer.parseInt(tokens.nextToken());
        int m = Integer.parseInt(tokens.nextToken());
        tokens = new StringTokenizer(input.readLine());
        int mArr[] = new int[m];

        for(int i=0; i<n; i++) {
            int a = Integer.parseInt(tokens.nextToken());
            map.put(a, map.getOrDefault(a,0) +1);
        }
        //System.out.println(map);
        tokens = new StringTokenizer(input.readLine());
        for(int j=0; j<m; j++) {
            mArr[j] = Integer.parseInt(tokens.nextToken());
        }

        for(int a: mArr) {
            System.out.print(map.getOrDefault(a, 0) +" ");
        }
    }
}