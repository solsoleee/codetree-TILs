import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static StringTokenizer tokens;
    static StringBuilder output = new StringBuilder();
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static int locate1[][][] = {{{0,0},{1,0},{1,1}}, {{0,0},{1,0},{0,1}}, {{0,0},{0,1},{1,1}}, {{0,0},{0,1},{-1,1}}};
    static int locate2[][][] ={ {{0,0}, {1,0}, {2,0}}, {{0,0}, {0,1}, {0,2} }};
    static int n,m;
    public static void main(String[] args) throws IOException {
        tokens = new StringTokenizer(input.readLine());
        n = Integer.parseInt(tokens.nextToken());
        m = Integer.parseInt(tokens.nextToken());
        int arr[][] = new int[n][m];

        for(int i=0; i<n; i++) {
            tokens = new StringTokenizer(input.readLine());
            for(int j=0; j<m; j++) {
                arr[i][j] = Integer.parseInt(tokens.nextToken());
            }
        }

        int maxVal=Integer.MIN_VALUE;
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {

                for(int l[][] : locate1) {
                    int cnt =0;
                    for(int a=0; a<3; a++){
                        int x =l[a][0];
                        int y = l[a][1];
                        if(i+x >=n || i+x<0 || j+y>=m || j+y<0 ) break;
                        cnt += arr[i+x][j+y];
                    }
                    maxVal = Math.max(maxVal, cnt);
                }

                for(int l[][] : locate2) {
                    int cnt =0;
                    for(int a=0; a<3; a++){
                        int x =l[a][0];
                        int y = l[a][1];
                        if(i+x >=n || i+x<0 || j+y>=m || j+y<0 ) break;
                        cnt += arr[i+x][j+y];
                    }
                    maxVal = Math.max(maxVal, cnt);
                }

            }
        }
        System.out.print(maxVal);

    }

}