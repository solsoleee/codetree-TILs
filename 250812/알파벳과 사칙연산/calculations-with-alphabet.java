import java.util.*;

public class Main {
    static String expression;
    static int len;                // 알파벳 개수
    static int[] res;               // 알파벳 자리 숫자 배치
    static List<Character> ops;     // 연산자 목록
    static int maxVal = Integer.MIN_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        expression = sc.next();
        sc.close();

        len = 0;
        ops = new ArrayList<>();
        // 알파벳 자리 세기 + 연산자 저장
        for (int i = 0; i < expression.length(); i++) {
            char ch = expression.charAt(i);
            if (ch >= 'a' && ch <= 'f') {
                len++;
            } else {
                ops.add(ch);
            }
        }

        res = new int[len];
        permu(0);
        System.out.println(maxVal);
    }

    // 1~4 중복순열
    static void permu(int depth) {
        if (depth == len) {
            int val = cal();
            maxVal = Math.max(maxVal, val);
            return;
        }
        for (int num = 1; num <= 4; num++) {
            res[depth] = num;
            permu(depth + 1);
        }
    }

    // 수식 계산
    static int cal() {
        int idx = 0; // res 인덱스
        int c = res[idx++]; // 첫 번째 숫자
        for (int i = 0; i < ops.size(); i++) {
            char op = ops.get(i);
            int next = res[idx++];
            if (op == '+') c = c + next;
            else if (op == '-') c = c - next;
            else c = c * next; // '*'
        }
        return c;
    }
}
