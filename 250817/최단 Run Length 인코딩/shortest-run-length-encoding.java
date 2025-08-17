import java.util.*;

public class Main {
    static String A;
    static int minVal = Integer.MAX_VALUE;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        A = sc.next();
        int len = A.length()-1;
        
        while(len >= 0) {
            A = change(A); //n번 돌렸을 때
            String r = compress(A); //압축
            minVal = Math.min(count(r), minVal); //최소값
            len --;
        }
        System.out.println(minVal);
    }

    //오른쪽으로 shift함수
    //1부터 n-1까지
    static String change(String s){
        String res ="";
        int len = s.length();
        res += s.charAt(len-1);
        for(int i=0; i<len-1; i++) {
            res += s.charAt(i);
        }
        return res;
    }
    

    //길이세는 함수
    static int count(String s) {
        return s.length();
    }


    //압축하는 함수
    static String compress(String s) {
        char c = s.charAt(0);
        String res =""; //압축한 결과
        int cnt =1 ; //기본
        for(int i=1; i<s.length(); i++) {
            if(c == s.charAt(i)) { //같다면
                cnt++;
            }
            else{
                //값 저장
                res += String.valueOf(c);
                res += String.valueOf(cnt);
                cnt=1;
            }
            c = s.charAt(i);
        }
        res += String.valueOf(c);
        res += String.valueOf(cnt);
        return res;
    }
}