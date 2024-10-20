import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    static StringTokenizer tokens;
    static int n,k;

    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        Map<Long, Integer > map = new HashMap<>();
        tokens = new StringTokenizer(input.readLine());
        n = Integer.parseInt(tokens.nextToken());
        k = Integer.parseInt(tokens.nextToken());
        long arr[] = new long [n];
        tokens = new StringTokenizer(input.readLine());
        for(int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(tokens.nextToken());
        }

        int res =0;

        for(int i=0; i<n; i++) {
            long diff = k-arr[i];

            //diff가 들어있다면
            if(map.containsKey(diff)) {
                res += map.get(diff);
            }

            //arr[i]가 들어있지 않다면
            if(!map.containsKey(arr[i])) {
                //value를 1더하기
                map.put(arr[i], 1);
            }
            //들어있다면
            else {
                map.put(arr[i], map.get(arr[i]) +1);
            }
            //System.out.println(map);

        }
        System.out.print(res);


    }
}