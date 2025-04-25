import java.util.*;
public class Main {
    static int n, bomb;
    static int [][] grid, copyGrid;
    static List<int[]> spot;
    static int [] res;
    static int [] arr = {1,2,3};
    static int maxVal = Integer.MIN_VALUE;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        spot = new ArrayList<>();
        grid = new int[n][n];
        copyGrid = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = sc.nextInt();
                if(grid[i][j] == 1)  {
                    bomb++;
                    spot.add(new int[] {i,j});
                }
            }
        }
        res = new int[bomb];
        
        permu(0);
        System.out.println(maxVal);

        
    }
    
    //숫자 별로 터지기
    static void expload() {
        int one [][] = {{-1,0},{-2,0},{1,0},{2,0}};
        int two [][] = {{-1,0},{1,0},{0,1},{0,-1}};
        int three [][] = {{-1,-1},{1,1},{1,-1},{-1,1}};
        for(int i=0; i<res.length; i++) {
            if(res[i] == 1) {
                int x = spot.get(i)[0];
                int y = spot.get(i)[1];
                for(int j=0; j<4; j++) {
                    int nx = x + one[j][0];
                    int ny = y + one[j][1];
                    if(nx >=0 && nx<n && ny>=0 && ny<n) {
                        copyGrid[nx][ny] = 1;
                    }
                }
            }
            else if(res[i] == 2) {
                int x = spot.get(i)[0];
                int y = spot.get(i)[1];
                for(int j=0; j<4; j++) {
                    int nx = x + two[j][0];
                    int ny = y + two[j][1];
                    if(nx >=0 && nx<n && ny>=0 && ny<n) {
                        copyGrid[nx][ny] = 1;
                    }
                }
            }
            else if(res[i] == 3) {
                int x = spot.get(i)[0];
                int y = spot.get(i)[1];
                for(int j=0; j<4; j++) {
                    int nx = x + three[j][0];
                    int ny = y + three[j][1];
                    if(nx >=0 && nx<n && ny>=0 && ny<n) {
                        copyGrid[nx][ny] = 1;
                    }
                }
            }

        }

    }

    // 1의 개수만 세기
    static int find() {
        int cnt=0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(copyGrid[i][j] == 1) cnt++;
            }
        }
        return cnt;
    }


    static void init() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                copyGrid[i][j] = grid[i][j];
            }
        }
    }
    static void permu(int depth) {
        if(depth == bomb) {
            //System.out.println(Arrays.toString(res));
            init(); //초기화
            expload(); //터지기
            //System.out.println(Arrays.deepToString(copyGrid));
            int res = find(); //1의 개수 세기
            maxVal = Math.max(res, maxVal);
            return;
        }
        for(int i=0; i<3; i++) {
            res[depth] = arr[i];
            permu(depth+1);
        }
    }
}