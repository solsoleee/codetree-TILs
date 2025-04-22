import java.util.*;

public class Main {
    static int N;
    static String[] grid;
    static int[] start;
    static int[] end;
    static int[][] coin;
    static List<Integer> coinNums;
    static int count;
    static int minVal = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        start = new int[2];
        end = new int[2];
        grid = new String[N];
        coin = new int[10][2];
        coinNums = new ArrayList<>();
        count = 0;

        for (int i = 0; i < N; i++) {
            grid[i] = sc.next();
            for (int j = 0; j < grid[i].length(); j++) {
                char ch = grid[i].charAt(j);
                if (ch == 'S') {
                    start[0] = i;
                    start[1] = j;
                } else if (ch == 'E') {
                    end[0] = i;
                    end[1] = j;
                } else if (Character.isDigit(ch)) {
                    int c = ch - '0';
                    coin[c][0] = i;
                    coin[c][1] = j;
                    coinNums.add(c);
                    count++;
                }
            }
        }

        Collections.sort(coinNums);
        subset(0, new ArrayList<>());

        if (minVal != Integer.MAX_VALUE)
            System.out.println(minVal);
        else System.out.println(-1);
    }

    // 부분집합 만들기
    static void subset(int idx, List<Integer> selected) {
        if (idx == coinNums.size()) {
            if (selected.size() >= 3) {
                permute(selected, new boolean[selected.size()], new ArrayList<>());
            }
            return;
        }

        // 선택 안함
        subset(idx + 1, selected);

        // 선택 함
        selected.add(coinNums.get(idx));
        subset(idx + 1, selected);
        selected.remove(selected.size() - 1);
    }

    // 순열 만들기
    static void permute(List<Integer> selected, boolean[] used, List<Integer> path) {
        if (path.size() == selected.size()) {
            calculate(path);
            return;
        }

        for (int i = 0; i < selected.size(); i++) {
            if (!used[i]) {
                used[i] = true;
                path.add(selected.get(i));
                permute(selected, used, path);
                path.remove(path.size() - 1);
                used[i] = false;
            }
        }
    }

    // 거리 계산
    static void calculate(List<Integer> path) {
        int dist = 0;

        // 시작점 -> 첫 번째 동전
        int first = path.get(0);
        dist += Math.abs(start[0] - coin[first][0]) + Math.abs(start[1] - coin[first][1]);

        // 동전들 사이 거리
        for (int i = 0; i < path.size() - 1; i++) {
            int cur = path.get(i);
            int next = path.get(i + 1);
            dist += Math.abs(coin[cur][0] - coin[next][0]) + Math.abs(coin[cur][1] - coin[next][1]);
        }

        // 마지막 동전 -> 도착점
        int last = path.get(path.size() - 1);
        dist += Math.abs(coin[last][0] - end[0]) + Math.abs(coin[last][1] - end[1]);

        minVal = Math.min(minVal, dist);
    }
}