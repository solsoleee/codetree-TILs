import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer tokens;

    public static void main(String[] args) throws IOException {
        Map<Integer,String> map1 = new HashMap<>();
        Map<String,Integer> map2 = new HashMap<>(); //알파벳
        tokens = new StringTokenizer(input.readLine());
        int n = Integer.parseInt(tokens.nextToken());
        int m = Integer.parseInt(tokens.nextToken());

        for(int i=1; i<=n; i++) {
            String str = input.readLine();
            map1.put(i, str);
            map2.put(str, i);
        }

        for(int j = 0; j<m; j++) {
            String str = input.readLine();
            //알파벳이면
            if(97<= str.charAt(0) - 0 && str.charAt(0) - 0<= 122)  {
                System.out.println(map2.get(str));
            }
            else{
                System.out.println(map1.get(Integer.parseInt(str)));
            }
        }
    }
}