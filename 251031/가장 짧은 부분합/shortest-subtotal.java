import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int s = sc.nextInt();
        int[] arr = new int[n];
        int tempsum = 0;
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
            tempsum += arr[i];
        }
        boolean flag = true;
        //전체를 다 더했는데 s가 안 넘으면 -1
        if(tempsum < s)  flag = false;
        // i, j
        int ans = Integer.MAX_VALUE; //구간
        if(flag) {
            
            
            for(int i=0; i<n; i++) {
                int sum = 0;
                int j = i;
                int diff=0;
                while(j<n && sum<=s ) {
                    sum += arr[j];
                    if(sum >= s) {
                        diff = j-i;
                        break;
                    }
                    j++;
                }            
                //구간

                if(sum >= s) {
                        //System.out.println(i +" " + j +" " + diff);
                        ans = Math.min(diff+1, ans);
                        
                }
                
                

            }
        }
        if(flag) {
            System.out.println(ans);
        }
        else {
            System.out.println(-1);
        }
        
    }
}