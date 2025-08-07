import java.util.*;
public class Main {
    static int n;
    static int t;
    static int [] top;
    static int [] bottom;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        t = sc.nextInt();
        top = new int[n];
        bottom = new int[n];
        for (int i = 0; i < n; i++) {
            top[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            bottom[i] = sc.nextInt();
        }
        while(t>0) {
            int b[] = new int [n];
        for(int i=0; i<n; i++) {
            b[i] = bottom[i];
        }
        // Please write your code here.
        //System.out.println(Arrays.toString(bottom));
        //change(b);
        //System.out.println(Arrays.toString(bottom));
        //첫째줄은 오른쪽으로 가기
        int topT = top[n-1];
        for(int i=n-1; i>0; i--) {
            top[i] = top[i-1];
        }
        //좌우반전
        change(b);
        // 아래쪽은 왼쪽으로
        int bottomT = bottom[0];
        for(int i=0; i<n-1; i++) {
            bottom[i] = bottom[i+1];
        }
        top[0] = bottomT;
        bottom[n-1] = topT;
        //다시 좌우반전
        for(int i=0; i<n; i++) {
            b[i] = bottom[i];
        }
        change(b);

        t--;
        }
        //System.out.println(Arrays.toString(top));
        //System.out.println(Arrays.toString(bottom));
        for(int i=0; i<n; i++) {
            System.out.print(top[i] +" ");
        }
        System.out.println();
        for(int i=0; i<n; i++) {
            System.out.print(bottom[i] +" ");
        }
        
    }
    //좌우 반전
    static void change(int temp[]) {
        for(int i=0; i<n; i++) {
            bottom[i] = temp[n-i-1];
        }
    }
}