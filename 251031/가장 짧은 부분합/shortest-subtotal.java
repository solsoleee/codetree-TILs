import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) arr[i] = Integer.parseInt(st.nextToken());

        int ans = Integer.MAX_VALUE;
        int sum = 0, r = 0;

        for (int l = 0; l < n; l++) {
            // r를 가능한 데까지 늘려 합을 s 이상으로 만든다
            while (r < n && sum < s) {
                sum += arr[r++];
            }
            // 현재 l에서의 최소 길이 갱신
            if (sum >= s) ans = Math.min(ans, r - l);

            // l을 한 칸 밀면서 윈도우 축소
            sum -= arr[l];
        }

        System.out.println(ans == Integer.MAX_VALUE ? -1 : ans);
        // ※ 어떤 문제는 불가능하면 0을 출력하게 되어있음(BOJ 1806). 요구사항에 맞춰 -1/0 선택.
    }
}
