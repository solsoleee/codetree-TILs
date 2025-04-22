import java.util.*;

public class Main {
    static int N;
    static char[][] grid;
    static int[] start = new int[2];
    static int[] end = new int[2];
    static List<int[]> coinList = new ArrayList<>();
    static int minVal = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        grid = new char[N][N];

        for (int i = 0; i < N; i++) {
            String row = sc.next();
            for (int j = 0; j < N; j++) {
                grid[i][j] = row.charAt(j);
                if (grid[i][j] == 'S') {
                    start[0] = i;
                    start[1] = j;
                } else if (grid[i][j] == 'E') {
                    end[0] = i;
                    end[1] = j;
                } else if (Character.isDigit(grid[i][j])) {
                    int num = grid[i][j] - '0';
                    coinList.add(new int[]{num, i, j});
                }
            }
        }

        if (coinList.size() < 3) {
            System.out.println(-1);
            return;
        }

        // 숫자 기준 오름차순 정렬
        coinList.sort(Comparator.comparingInt(a -> a[0]));

        // 앞 3개 동전 고정 순서 방문
        int[] c1 = coinList.get(0);
        int[] c2 = coinList.get(1);
        int[] c3 = coinList.get(2);

        int dist = 0;
        dist += distance(start[0], start[1], c1[1], c1[2]);
        dist += distance(c1[1], c1[2], c2[1], c2[2]);
        dist += distance(c2[1], c2[2], c3[1], c3[2]);
        dist += distance(c3[1], c3[2], end[0], end[1]);

        System.out.println(dist);
    }

    static int distance(int x1, int y1, int x2, int y2) {
        return Math.abs(x1 - x2) + Math.abs(y1 - y2);
    }
}
