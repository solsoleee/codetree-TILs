import java.io.BufferedReader;
import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer tokens;

    public static void main(String[] args) throws IOException {
        Map<Long, Integer> map= new HashMap<>();
        tokens = new StringTokenizer(input.readLine());
        int n = Integer.parseInt(tokens.nextToken());
        int k = Integer.parseInt(tokens.nextToken());
        long arr[] = new long [n];
        tokens = new StringTokenizer(input.readLine());
        for(int  i =0; i<n; i++) {
            arr[i] = Integer.parseInt(tokens.nextToken());
            map.put(arr[i], map.getOrDefault(arr[i],0) +1);
        }

        int ans =0;

        for(int i=0; i<n; i++) {
           //이미 선택된건 빼줌

            map.put(arr[i], map.getOrDefault(arr[i], 0)-1);

            for(int j=0; j<i; j++) {
                if(map.containsKey(k-arr[i]-arr[j])) {
                    ans += map.get(k-arr[i]-arr[j]);
                }

            }

        }
        System.out.println(ans);


    }


}