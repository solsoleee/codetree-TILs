import java.util.Scanner;
import java.io.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] arr = new int[100001];
        for (int i = 0; i < n; i++) {
            int num = sc.nextInt();
            arr[num]++;
        }
        for (int i = 0; i < m; i++) {
            int x = sc.nextInt();
            System.out.println(arr[x]);
            // Please write your code here.
        }
    }
}