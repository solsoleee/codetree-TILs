import java.util.*;
import java.io.*;
public class Main {
    private static StringTokenizer tokens;
    private static StringBuilder output = new StringBuilder();
    private static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(input.readLine());
        int arr[][] = new int[n][2];
        for(int i=0; i<n; i++) {
            tokens  = new StringTokenizer(input.readLine());
            int s = Integer.parseInt(tokens.nextToken());
            int e = Integer.parseInt(tokens.nextToken());

            arr[i][0] = s;
            arr[i][1] = e;

        }
        Arrays.sort(arr, (o1,o2) -> Integer.compare(o1[1], o2[1]) );
        //System.out.println(Arrays.deepToString(arr));
        int res =0;
        int pre = 0;
        for(int a[]: arr) {

            if(a[0] >= pre ) {
                res++;
                pre = a[1];
            }
        }
        System.out.println(res);

    }
}