import java.util.Scanner;
public class Main {
    static int n;
    static int m;
    static int[][]grid;
    static int maxVal = Integer.MIN_VALUE;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        grid = new int[n][m];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                grid[i][j] = sc.nextInt();
        // Please write your code here.
        for(int i=0; i<n; i++) { //왼쪽 끝점
            for(int j=0; j<m; j++) {
                
                for(int a=i; a<n; a++) { //오른쪽 끝점
                    for(int b=j; b<m; b++) {
                        //System.out.println("IJ"+" "+i +" " +j);
                        
                        //System.out.println("AB"+" "+a +" " +b);
                        boolean flag = check(i,j,a,b);
                        if(flag){
                            //System.out.println("a"+a);
                            //System.out.println("IJ"+" "+i +" " +j);
                            //System.out.println("AB"+" "+a +" " +b);
                            int l = a-i+1;
                            int h = b-j+1;
                            maxVal = Math.max(maxVal,l*h);
                        }
                    }
                }

            }
        }
        System.out.println(maxVal);


    }
    static boolean check(int a, int b, int x, int y) {
        //직사각형 양수인지 체크
        //ab부터 xy까지
        for(int i=a; i<=x; i++) {
            for(int j=b; j<=y; j++) {
                if(grid[i][j] < 0) return false;
            }
        }
        return true;
    }
}