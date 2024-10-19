import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static final int NUM_LEN = 3;
    
    public static int n;
    public static int[] series;  // 고정 크기의 배열
    public static int[] numbers = new int[]{4, 5, 6};
    
    // 시작과 끝 인덱스가 주어진 두 수열이 동일한지 여부를 판별합니다.
    public static boolean isEqual(int start1, int end1, int start2, int end2) {
        for(int i = 0; i <= end1 - start1; i++) {
            if(series[start1 + i] != series[start2 + i])
                return false;
        }
        return true;
    }
    
    // 가능한 수열인지 여부를 판별합니다.
    public static boolean isPossibleSeries() {
        // 수열의 가장 앞부터 각 인덱스가 시작점일 때
        // 인접한 연속 부분 수열이 동일한 경우가 있는지를 탐색합니다.
        for(int idx = 0; idx < n; idx++) {
            // 가능한 연속 부분 수열의 길이 범위를 탐색합니다.
            int len = 1;
            while(true) {
                // 연속 부분 수열의 시작과 끝 인덱스를 설정합니다.
                int start1 = idx, end1 = idx + len - 1;
                int start2 = end1 + 1, end2 = start2 + len - 1;
    
                // 두 번째 연속 부분 수열의 끝 인덱스가 범위를 넘어가면 탐색을 종료합니다.
                if(end2 >= n)
                    break;
    
                // 인접한 연속 부분 수열이 같은지 여부를 확인합니다.
                if(isEqual(start1, end1, start2, end2))
                    return false;
    
                len++;
            }
        }
        return true;
    }
    
    public static void findMinSeries(int cnt) {
        // n개의 숫자가 선택됐을 때 불가능한 수열인 경우 탐색을 종료합니다.
        // 가능한 수열인 경우 이를 출력하고 프로그램을 종료합니다.
        if(cnt == n) {
            if(!isPossibleSeries())
                return;
    
            for(int i = 0; i < n; i++)
                System.out.print(series[i]);
            System.exit(0);
        }
    
        // 사용 가능한 각 숫자가 뽑혔을 때의 경우를 탐색합니다.
        for(int i = 0; i < NUM_LEN; i++) {
            series[cnt] = numbers[i];  // 숫자를 배열에 추가
            findMinSeries(cnt + 1);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());  // 입력 받음
        series = new int[n];  // 크기 n의 배열 생성

        findMinSeries(0);  // 탐색 시작
    }
}