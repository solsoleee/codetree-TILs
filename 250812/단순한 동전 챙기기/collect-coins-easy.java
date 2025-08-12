import java.util.*;
public class Main {
    static int N;
    static String[] grid;
    static int[] start;
    static int[] end;
    static int[][] map;
    static List<Integer> list = new ArrayList<>();
    static boolean flag;
    static int minval = Integer.MAX_VALUE;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        flag = false;
        grid = new String[N];
        start = new int[2];
        end = new int[2];
        map = new int[400][2];
        for (int i = 0; i < N; i++) {
            grid[i] = sc.next();
            for(int j=0; j<N; j++) {
                if(grid[i].charAt(j) == 'S'){
                    start[0] = i;
                    start[1] = j;
                }
                else if(grid[i].charAt(j) == 'E'){
                    end[0] = i;
                    end[1] = j;
                }
                else  {
                    int num = grid[i].charAt(j) - '0';
                    if(num >=1 ) {
                        map[num][0] = i;
                        map[num][1] = j;
                        list.add(num);
                    }
                }
            }
            
        }
        Collections.sort(list);
            combi(0,0,start[0],start[1],0);
            if(flag) System.out.println(minval);
            else System.out.println(-1);
        // Please write your code here.
    }
    //3개 고르기
    static void combi(int depth, int start, int dx, int dy, int sum) {
        if (depth == 3) {
            flag = true;
            sum = sum + Math.abs(dx-end[0]) + Math.abs(dy-end[1]);
            minval = Math.min(sum, minval);
            return;
        }
        for(int i=start; i<list.size(); i++) {
            int l = list.get(i); //map에서 i 번쩨
            int x = map[l][0];
            int y = map[l][1];
            //전에서 지금 위치 길이 
            int total = sum + Math.abs(dx-x) + Math.abs(dy-y);
            combi(depth+1, i+1, x, y, total); 
        }
    }
}