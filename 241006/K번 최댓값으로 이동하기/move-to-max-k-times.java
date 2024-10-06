import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static StringTokenizer tokens;
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static int n,k,maxVal;
    static int map[][];
    static int arr[] =new int [2];
    static boolean visited[][];
    static int deltas[][] = {{0,1}, {1,0}, {-1,0}, {0,-1} };

    public static void main(String[] args) throws IOException {
        tokens = new StringTokenizer(input.readLine());
        n = Integer.parseInt(tokens.nextToken());
        k = Integer.parseInt(tokens.nextToken());

        map = new int[n][n];


        for(int i=0; i<n; i++) {
            tokens = new StringTokenizer(input.readLine());
            for(int j=0; j<n; j++) {
                map[i][j] = Integer.parseInt(tokens.nextToken());
            }
        }
        tokens = new StringTokenizer(input.readLine());
        int r = Integer.parseInt(tokens.nextToken());
        int c = Integer.parseInt(tokens.nextToken());
        arr[0] = r-1;
        arr[1] = c-1;
        for(int i=0; i<k; i++) {
            visited = new boolean[n][n];
            bfs(arr[0], arr[1], map[arr[0]][arr[1]]);
        }
        System.out.println((arr[0]+1)+" " + (arr[1]+1));
    }
    static void bfs(int x, int y, int val) {
        maxVal =0;
        Queue<int[]> que = new ArrayDeque<>();
        que.offer(new int [] {x,y});
        visited[x][y] = true;

        while(!que.isEmpty()) {
            int t[] = que.poll();
            int r = t[0];
            int c = t[1];

            for(int d[] : deltas) {
                int nx = r+d[0];
                int ny = c+d[1];
                if( check(nx, ny, val)) {
                    que.offer(new int [] {nx, ny});
                    visited[nx][ny] =true;

                    //arr가 시작점이 되고 maxval이 그 시작점의 값
                    if(maxVal < map[nx][ny] ) {
                        maxVal = map[nx][ny];
                        arr[0] = nx; arr[1] =ny;
                    } else if (maxVal == map[nx][ny]) {
                        //행이 더 작은거
                        if(arr[0] > nx) {
                            arr[0] = nx; arr[1] = ny;
                        } else if (arr[0] == nx) {
                            //열이 더 작은거
                            if(arr[1] > ny) {
                                arr[0] = nx; arr[1] = ny;
                            }
                        }
                    }
                };
            }

        }

    }
    static boolean check(int x, int y, int val) {
        if(x >=0 && x<n && y>=0 && y<n) {
            if(!visited[x][y] && map[x][y] < val) {
                return true;
            }
        }
        return false;
    }
}