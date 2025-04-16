import java.util.*;
public class Main {
    static int n;
    static int m; 
    static int k;
    static int ans = Integer.MIN_VALUE; //답
    static int[] res;
    static int[] arr;
    static int[] stick;
    static int[] nums;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        k = sc.nextInt();
        nums = new int[n];
        stick = new int[k];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        res = new int[n]; //현재 들어가는 말
        arr = new int[k]; // 
        for(int i=0; i<k; i++) {
            arr[i] = i+1;
            stick[i] = i+1; //말 현재 상태.
        }
        
        // Please write your code here.

        // 중복 순열

        permu(0);
        System.out.println(ans);

    }
    static void reset() {
        for(int i=0; i<k; i++) {
            stick[i] = 1; //말 현재 상태.
        }
    }
    static void permu(int depth) {
        if(depth == n) {
            //System.out.println(Arrays.toString(res));
            int cnt =0;

            reset(); //말 상태 초기화

            for(int i=0; i<n; i++) {
                stick[res[i]-1] += nums[i]; //현재말, nums[i]이것만큼 움직임 저장
            }
            // m이랑 같거나 크면 점수
            for(int i=0; i<k; i++) {
                if(stick[i] >= m) {
                    cnt++;
                }
            }
            // 최대값 구함
            ans = Math.max(cnt, ans);
            return;
        }
        for(int i=0; i<k; i++) {
            res[depth] = arr[i];
            permu(depth+1);
        }
    }
}