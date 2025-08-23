import java.util.*;

public class Main {
    static int[][] deltas = {{-1,0},{1,0},{0,-1},{0,1}}; // 상하좌우 (동률 타이브레이커)
    static int n, m, t;
    static int[][] grid;
    static List<int[]> list = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt(); m = sc.nextInt(); t = sc.nextInt();

        grid = new int[n][n];
        for (int i=0;i<n;i++) for (int j=0;j<n;j++) grid[i][j] = sc.nextInt();

        for (int i=0;i<m;i++) {
            int r = sc.nextInt()-1, c = sc.nextInt()-1;
            list.add(new int[]{r, c});
        }

        while (t-- > 0 && !list.isEmpty()) {
            int sz = list.size();

            // 1) 전부 목적지 계산
            List<int[]> next = new ArrayList<>(sz);
            Map<Integer, Integer> freq = new HashMap<>(); // 목적지별 개수
            for (int i=0;i<sz;i++) {
                int[] cur = list.get(i);
                int[] dest = move(cur[0], cur[1]);
                next.add(dest);
                int key = encode(dest[0], dest[1]);
                freq.put(key, freq.getOrDefault(key, 0) + 1);
            }

            // 2) 충돌 처리: 같은 칸에 2개 이상이면 모두 제거
            List<int[]> filtered = new ArrayList<>();
            for (int i=0;i<next.size();i++) {
                int[] d = next.get(i);
                if (freq.get(encode(d[0], d[1])) == 1) filtered.add(d);
            }

            list = filtered;
        }

        // 최종 남은 구슬 수
        System.out.println(list.size());
    }

    static int encode(int x, int y) { return x * n + y; }
    static boolean in(int x, int y) { return 0 <= x && x < n && 0 <= y && y < n; }

    // 인접 4칸 중 "값이 가장 큰" 칸으로 이동 (동률이면 deltas 순서: 상,하,좌,우)
    static int[] move(int x, int y) {
        int bestVal = Integer.MIN_VALUE, nx = x, ny = y;
        for (int[] d : deltas) {
            int tx = x + d[0], ty = y + d[1];
            if (!in(tx, ty)) continue;
            int v = grid[tx][ty];
            if (v > bestVal) { bestVal = v; nx = tx; ny = ty; }
        }
        return new int[]{nx, ny};
    }
}
