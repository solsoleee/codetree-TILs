import java.util.*;
public class Main {
    static int num[];
    static Set<Integer> list = new HashSet<>();
    static String expression;
    static int maxval = Integer.MIN_VALUE;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        expression = sc.next();
        // Please write your code here.
        num = new int[6];
        permu(0);
        System.out.println(maxval);
    }
    static int cal() {
        int n = expression.charAt(0) - 'a';
        int s = num[n];
        int sum =0;
        for(int i=1; i<expression.length(); i+=2) {
            char c = expression.charAt(i);
            int temp = expression.charAt(i+1) -'a';
            if(c == '-') {
                s= s-num[temp];
            }
            else if(c=='+') {
                s = s+num[temp];
            }
            else s = s*num[temp];
            
        }
        return s;
    }
    static void permu(int depth) {
        if(depth == 6) {
            //계산
            int t = cal();
            maxval = Math.max(t, maxval);
            return;
        }
        for(int i=0; i<4; i++) {
            num[depth] = i+1;
            permu(depth+1);
        }
    }
}