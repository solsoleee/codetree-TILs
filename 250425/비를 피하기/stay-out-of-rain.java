import java.util.*;
public class Main {
    static int n,h,m;
    static int [][] a;
    static List<int[]> person;
    static int p;
    static boolean [][] visited;
    static int deltas[][] = {{0,1},{1,0},{-1,0},{0,-1}};
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        h = sc.nextInt();
        m = sc.nextInt();
        a = new int[n][n];
        visited = new boolean[n][n];
        person = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                a[i][j] = sc.nextInt();
                if(a[i][j] ==2 ) {
                    person.add(new int[] {i,j,-1});
                    p++;
                }
            }
        }
        // person마다 위치를 구함
        // Integer.MAX_VALUE이면 -1이임

    
        //System.out.println(bfs(3,0));
        for(int i=0; i<p; i++) {
            int temp[] = person.get(i);
            // System.out.println(Arrays.toString(temp));
            int minTime = bfs(temp[0],temp[1]);
            
            //person의 위치에 bfs결과값을 넣으면 됨
            if(  minTime != Integer.MAX_VALUE ) {
                person.get(i)[2] = minTime;
            }
        }
        
        


        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                if(a[i][j]!=2) a[i][j] = 0;
            }
        }
        for(int i=0; i<p; i++) {
            int temp[] = person.get(i);
            // System.out.println(Arrays.toString(temp));
            a[temp[0]][temp[1]] = temp[2];
        }
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                System.out.print(a[i][j] +" ");
            }
            System.out.println();
        }

    }

    static boolean check(int x, int y) {
        return x>=0 && x<n && y>=0 && y<n;
    }
    static int bfs(int x, int y) {
        int res  = Integer.MAX_VALUE ; //정답
        visited = new boolean[n][n]; //초기화
        Queue<int []> que = new ArrayDeque<>();
        que.offer(new int[] {x,y,0});
        while(!que.isEmpty()) {
            
            int t[] = que.poll();
            int dx = t[0];
            int dy = t[1];
            int time = t[2];
            //System.out.println(dx+" " +dy+" "+time);
            // 위치가 3이면 최소거리 
            if(a[dx][dy] == 3) {
                res = Math.min(res, time);
            }

            for(int d[]: deltas) {
                int nx = dx+d[0];
                int ny = dy+d[1];
                if(check(nx,ny) && !visited[nx][ny]) {
                    if(a[nx][ny] !=1) {
                        que.offer(new int[] {nx,ny, time+1});
                        visited[nx][ny] = true;
                    }

                }
            }

        }
        return res;
    }


}