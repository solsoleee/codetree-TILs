import java.util.Scanner;

public class Main {
    public static int n;
    public static int ans;
    public static int[] seq; // 배열로 수열 저장
    
    public static boolean isBeautiful() {
        // 연달아 같은 숫자가 나오는 시작 위치를 잡습니다.
        for (int i = 0; i < n; i += seq[i]) {
            // 만약 연속하여 해당 숫자만큼 나올 수 없다면
            // 아름다운 수가 아닙니다.
            if (i + seq[i] - 1 >= n)
                return false;
            // 연속하여 해당 숫자만큼 같은 숫자가 있는지 확인합니다.
            // 하나라도 다른 숫자가 있다면 아름다운 수가 아닙니다.
            for (int j = i; j < i + seq[i]; j++)
                if (seq[j] != seq[i])
                    return false;
        }
        return true;
    }

    public static void countBeautifulSeq(int cnt) {
        if (cnt == n) {
            if (isBeautiful())
                ans++; // 아름다운 수라면 카운트 증가
            return;
        }

        // 1부터 4까지의 숫자를 순서대로 선택해 수열을 구성
        for (int i = 1; i <= 4; i++) {
            seq[cnt] = i;
            countBeautifulSeq(cnt + 1);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        seq = new int[n]; // 수열을 저장할 배열 초기화
        
        countBeautifulSeq(0); // 아름다운 수를 카운트하는 함수 호출
        
        System.out.print(ans); // 결과 출력
    }
}