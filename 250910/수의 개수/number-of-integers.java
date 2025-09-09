import java.util.Scanner;
public class Main {
    static int n;
    static int []arr;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int m = sc.nextInt();
        arr = new int[100001];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        for (int i = 0; i < m; i++) {
            int x = sc.nextInt();
            int c = upper(x)-lower(x);
            System.out.println(c);
        }
    }

    static int lower(int target) {
        int left = 0;
        int right = n-1;
        int minVal = n;
        while(left <= right) {
            int mid = (left+right) /2;
            if(arr[mid] >= target) {
                right = mid-1;
                minVal = Math.min(minVal, mid);
            }
            else left = mid+1;

        }
        return minVal;
    }



    //x에 초과되는거
    static int upper(int target) {
        int left = 0;
        int right = n-1;
        int maxVal = n;
        while(right >= left) {
            int mid = (right + left) / 2;
            if(arr[mid] > target) {
                // 더 값을 낮 춰야함
                right = mid-1;
                //초과한거니까 일단 저장
                maxVal = Math.min(maxVal, mid);
            }
            else left = mid+1;
        }
        return maxVal;
    }
}