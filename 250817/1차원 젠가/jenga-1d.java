import java.util.*;

public class Main {
    static int n;
    static int[] blocks;
    static List<Integer> list = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        blocks = new int[n];
        for (int i = 0; i < n; i++) {
            blocks[i] = sc.nextInt();
            list.add(blocks[i]);
        }
        int s1 = sc.nextInt();
        int e1 = sc.nextInt();
        int s2 = sc.nextInt();
        int e2 = sc.nextInt();

        // 첫 번째 제거 (현재 리스트 기준)
        removeRange(list, s1, e1);

        // 두 번째 제거 (압축된 리스트 기준)
        removeRange(list, s2, e2);

        // 출력
        System.out.println(list.size());
        for (int v : list) System.out.println(v);
    }

    // [s, e] (1-based, inclusive) 구간을 뒤에서 앞으로 제거
    static void removeRange(List<Integer> lst, int s, int e) {
        // 경계 보정(안전장치, 문제 조건 맞으면 없어도 됨)
        s = Math.max(1, s);
        e = Math.min(e, lst.size());
        if (s > e) return;

        for (int i = e; i >= s; i--) {
            lst.remove(i - 1);
        }
    }
}
