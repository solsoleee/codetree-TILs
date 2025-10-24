import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] prices = new int[n];
        for (int i = 0; i < n; i++) prices[i] = sc.nextInt();

        int minSoFar = Integer.MAX_VALUE;
        int answer = 0; // 이익이 없으면 0
        for (int p : prices) {
            if (p < minSoFar) minSoFar = p;      // 최저가 갱신(살 타이밍)
            else answer = Math.max(answer, p - minSoFar); // 지금 판다면 이익
        }
        System.out.println(answer);
    }
}
