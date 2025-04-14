import java.util.Scanner;

public class Main {
    static int n, m;
    static int[][] grid;
    static int maxGold = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt(); // 격자 크기
        m = sc.nextInt(); // 금 하나당 가격
        grid = new int[n][n];

        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                grid[i][j] = sc.nextInt();

        for (int x = 0; x < n; x++) {
            for (int y = 0; y < n; y++) {
                // (x, y)를 중심으로
                for (int k = 1; k <= 2 * n; k++) { // k를 1부터 2n까지
                    int gold = countGold(x, y, k); // k 크기 안에서 금 몇 개?
                    int cost = k * k + (k - 1) * (k - 1); // 비용 계산
                    if (gold * m >= cost) { // 수익이 비용보다 크거나 같으면
                        maxGold = Math.max(maxGold, gold); // 최대 금 개수 갱신
                    }
                }
            }
        }

        System.out.println(maxGold);
    }

    static int countGold(int x, int y, int k) {
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (Math.abs(x - i) + Math.abs(y - j) < k) { // 맨해튼 거리 < k
                    if (grid[i][j] == 1) { // 금이 있으면
                        cnt++;
                    }
                }
            }
        }
        return cnt;
    }
}
