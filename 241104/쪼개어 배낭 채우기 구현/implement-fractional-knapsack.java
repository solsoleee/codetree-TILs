import java.io.*;
import java.util.*;

public class Main {
    private static StringTokenizer tokens;
    private static StringBuilder output = new StringBuilder();
    private static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException{
        // 여기에 코드를 작성해주세요.

        tokens = new StringTokenizer(input.readLine());
        int n = Integer.parseInt(tokens.nextToken());
        int m = Integer.parseInt(tokens.nextToken());

        double arr[][] = new double[n][3];

        for(int i=0; i<n; i++) {
            tokens = new StringTokenizer(input.readLine());
            double w = Double.parseDouble(tokens.nextToken());
            double v = Double.parseDouble(tokens.nextToken());
            arr[i][0] = w;
            arr[i][1] = v;
            arr[i][2] = v/w;
        }
        Arrays.sort(arr, (o1, o2)-> Double.compare(o2[2], o1[2]) );


        double sum =0;
        for(double a[] : arr) {
            if(m == 0 ) break;

            if(m >= a[0]) {
                m-=a[0];
                sum+=a[1];
            }
            else {
                sum+=a[2]*m;
                m=0;
            }
        }
        System.out.print(String.format("%.3f", sum));
    }
}