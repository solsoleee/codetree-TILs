import java.util.Scanner;

public class Main {
    public static int n;  // 자리 수
    public static int ans = 0;  // 아름다운 수의 개수
    public static int[] arr;  // 현재 만들어진 수를 저장하는 배열
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        arr = new int[n];
        
        // 아름다운 수를 만들기 위한 탐색 시작
        dfs(0);
        
        // 결과 출력
        System.out.println(ans);
    }
    
    // 아름다운 수를 만들기 위한 백트래킹 함수
    public static void dfs(int depth) {
        if (depth == n) {
            // 아름다운 수인지 확인
            if (isBeautiful()) {
                ans++;  // 아름다운 수이면 카운트 증가
            }
            return;
        }
        
        // 1부터 4까지의 숫자를 하나씩 선택하여 수를 만들어감
        for (int i = 1; i <= 4; i++) {
            arr[depth] = i;  // 현재 자리에 숫자 i를 넣음
            dfs(depth + 1);  // 다음 자리로 이동
        }
    }
    
    // 수가 아름다운 수인지 확인하는 함수
    public static boolean isBeautiful() {
        int i = 0;
        
        // 각 숫자가 자기 자신만큼 연속해서 나오는지 확인
        while (i < n) {
            int num = arr[i];  // 현재 숫자
            int count = 0;
            
            // 현재 숫자가 연속으로 몇 번 나오는지 카운트
            while (i < n && arr[i] == num) {
                count++;
                i++;
            }
            
            // 숫자가 자기 자신만큼 반복되지 않으면 아름다운 수가 아님
            if (count != num) {
                return false;
            }
        }
        return true;
    }
}