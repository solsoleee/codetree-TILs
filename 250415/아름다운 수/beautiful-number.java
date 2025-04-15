import java.util.Scanner;
public class Main {
    static int n;
    static boolean visited[];
    static int arr[] = {1,2,3,4,5,6,7,8,9};
    static int ans=0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        // Please write your code here.

         visited = new boolean[n];
        
        int res[] = new int[n];
        subset(0);
        System.out.println(ans);


    }

    static void subset(int idx) {
        if(n == idx) {
            int count = 1;
            int pre = 0;
            int start = 0;
            boolean flag = false;
            for(int i=0; i<n; i++) {
                if(!visited[i]) {
                    pre = arr[i];
                    start = i;
                }
            }
            if(pre == 1) flag = true;
            for(int i=start+1; i<n; i++) {
                flag = true;
                if(!visited[i]) {
                    // 전이랑 같으면
                    if( pre == arr[i]) {
                        count ++;
                    }
                    // 전이랑 다른데 카운트까지 다르면
                    else {
                        if(count != arr[i]) flag = false;
                    }
                    if(count == arr[i]){
                        count = 1;
                    }

                    pre = arr[i];
                    
                    
                    //System.out.print(arr[i] +" ");
                }
            } 
            if(count !=1) {
                flag = false;
            }
        
            if(flag) 
            {
                for(int i=0; i<n; i++) {
                if(!visited[i]) {
                    //System.out.print(arr[i] +" ");
                }
            }
            //System.out.println();
                ans ++;
            }
            
            
            return;
        }
        visited[idx] = true;
        subset(idx+1);
        
        visited[idx] = false;
        subset(idx+1);

    }


}