import java.util.*;

public class Main {
    static int n; static int m;
    static int A[];
    static int res[];
    static int ans = Integer.MIN_VALUE;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        A = new int[n];
        for (int i = 0; i < n; i++) {
            A[i] = sc.nextInt();
        }
        res = new int[m];
        // Please write your code here.
        combi(0,0);
        System.out.println(ans);
    }

    //조합
    static void combi(int start, int depth) {
        if(depth == m) {
            //res에 들어가 있음
            //XOR 되는 최대값 확인하기
            // 지금 res 의 최대값
            int temp =1;
            for(int r: res) {
                temp = temp ^ r;
            }    
            
            ans = Math.max(ans, temp);
            return;
        }
           for(int i=start; i<n; i++) {
            res[depth] = A[i];
            combi(i+1, depth+1);
        } 
        }
        

    }
