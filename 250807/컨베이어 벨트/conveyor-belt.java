import java.util.*;

public class Main {
    static int n, t;
    static int[] top, bottom;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        t = sc.nextInt();
        top = new int[n];
        bottom = new int[n];

        for (int i = 0; i < n; i++) {
            top[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            bottom[i] = sc.nextInt();
        }

        for (int k = 0; k < t; k++) {
            // 1. top 한 칸 오른쪽 회전
            int lastTop = top[n - 1];
            for (int i = n - 1; i > 0; i--) {
                top[i] = top[i - 1];
            }

            // 2. bottom 좌우 반전
            reverse(bottom);

            // 3. bottom 한 칸 왼쪽 회전
            int firstBottom = bottom[0];
            for (int i = 0; i < n - 1; i++) {
                bottom[i] = bottom[i + 1];
            }

            // 4. top과 bottom 연결
            top[0] = firstBottom;
            bottom[n - 1] = lastTop;

            // 5. bottom 다시 좌우 반전
            reverse(bottom);
        }

        // 출력
        printArray(top);
        printArray(bottom);
    }

    // 배열 좌우 반전
    static void reverse(int[] arr) {
        for (int i = 0; i < n / 2; i++) {
            int tmp = arr[i];
            arr[i] = arr[n - 1 - i];
            arr[n - 1 - i] = tmp;
        }
    }

    // 배열 출력 함수
    static void printArray(int[] arr) {
        for (int x : arr) System.out.print(x + " ");
        System.out.println();
    }
}
