import java.util.*;

public class Main {
    static int n;
    static int segments[][];
    static int res[][];
    static boolean visited[];
    static int maxVal = Integer.MIN_VALUE;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        segments = new int[n][2];
        visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            segments[i][0] = sc.nextInt();
            segments[i][1] = sc.nextInt();
        }
        // Please write your code here.
        subSet(0);
        System.out.println(maxVal);
    }

    //겹치는 게 있는지 없는지
    static int check(int arr[][]) {
        
        int len = arr.length;
        //System.out.println(len);
        Arrays.sort(arr, (a, b) -> {
    if (a[0] != b[0]) return a[0] - b[0];
    return a[1] - b[1];
});

        //Arrays.sort(arr);
        for(int i=1; i<len; i++) {
            int x = arr[i][0];
            int y = arr[i][1];
            if(arr[i-1][1] >= x) {
                return 0;
            }
        }
        return len;

    }

    static void subSet(int depth) {
        if(depth == n) {
            int cnt = 0;
            for(int i=0; i<n; i++)
            {
                if(!visited[i]) {
                    cnt ++;
                    //System.out.print(c);
                    //System.out.print(segments[i][0] + " " + segments[i][1]);
                }
            }
            res = new int[cnt][2];
            int l = 0;
            for(int i=0; i<n; i++)
            {
                if(!visited[i]) {
                    res[l][0] = segments[i][0];
                    res[l][1] = segments[i][1];
                    l ++;
                    //System.out.print(c);
                    //System.out.print(segments[i][0] + " " + segments[i][1]);
                }
            }
            int temp = check(res);
            maxVal = Math.max(temp, maxVal);

            return;
        }
            
            visited[depth] = true;
            subSet(depth+1);

            visited[depth] = false;
            subSet(depth+1);
    }

}