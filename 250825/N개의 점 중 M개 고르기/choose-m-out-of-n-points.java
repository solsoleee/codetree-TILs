import java.util.*;

public class Main {
    static int n;
    static int m;
    static int [][] points;
    static int res[][];
    static int minVal = Integer.MAX_VALUE;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        points = new int[n][2];
        res = new int [m][2];
        for (int i = 0; i < n; i++) {
            points[i][0] = sc.nextInt();
            points[i][1] = sc.nextInt();
        }
        combi(0,0);
        System.out.println(minVal);
    }
    static void combi(int start, int depth) {
        if(depth == m) {
            
            for(int i=0; i<m-1; i++) {
                for(int j=i+1; j<m; j++) {
                    int a = (int)Math.pow(res[i][0]-res[j][0],2);
                    int b = (int)Math.pow(res[i][1]-res[j][1],2);
                    //System.out.println(Arrays.deepToString(res));
                    //System.out.println(a+" " + b);
                    minVal = Math.min(minVal, a+b);
                    
                }
            }
            return;
        }
        for(int i=start; i<n; i++) {
            res[depth][0] = points[i][0];
            res[depth][1] = points[i][1];
            combi(i+1, depth+1);
        }
    }
}