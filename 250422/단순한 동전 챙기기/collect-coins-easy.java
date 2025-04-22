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
                    coinList.add(new int[]{i, j});
                }
            }
        }

        comb(0, 0, new ArrayList<>());
        System.out.println(minVal == Integer.MAX_VALUE ? -1 : minVal);
    }

    static void comb(int idx, int cnt, List<int[]> selected) {
        if (cnt == 3) {
            calcMinPath(selected);
            return;
        }
        if (idx == coinList.size()) return;

        // 선택하지 않는 경우
        comb(idx + 1, cnt, selected);

        // 선택하는 경우
        selected.add(coinList.get(idx));
        comb(idx + 1, cnt + 1, selected);
        selected.remove(selected.size() - 1);
    }

    static void calcMinPath(List<int[]> coins) {
        boolean[] used = new boolean[3];
        permute(coins, new ArrayList<>(), used);
    }

    static void permute(List<int[]> coins, List<int[]> path, boolean[] used) {
        if (path.size() == 3) {
            int dist = distance(start, path.get(0)) +
                       distance(path.get(0), path.get(1)) +
                       distance(path.get(1), path.get(2)) +
                       distance(path.get(2), end);
            minVal = Math.min(minVal, dist);
            return;
        }

        for (int i = 0; i < 3; i++) {
            if (!used[i]) {
                used[i] = true;
                path.add(coins.get(i));
                permute(coins, path, used);
                path.remove(path.size() - 1);
                used[i] = false;
            }
        }
    }

    static int distance(int[] a, int[] b) {
        return Math.abs(a[0] - b[0]) + Math.abs(a[1] - b[1]);
    }
}