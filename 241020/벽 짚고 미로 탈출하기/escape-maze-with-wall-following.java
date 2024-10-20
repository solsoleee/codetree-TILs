import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer tokens;
    static int n,r,c;
    static int[][] map;
    static boolean[][][] visited;
    static int [][] deltas={{0,1}, {1,0},{0,-1},{-1,0}}; //시계방향

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(input.readLine());
        tokens = new StringTokenizer(input.readLine());
        r = Integer.parseInt(tokens.nextToken()) - 1;
        c = Integer.parseInt(tokens.nextToken()) - 1;
        map = new int[n][n];
        visited = new boolean[n][n][4];
        for (int i = 0; i < n; i++) {
            String str = input.readLine();
            for (int j = 0; j < n; j++) {
                if (str.charAt(j) == '#') map[i][j] = 1;
                else map[i][j] = 0;
            }
        }
        int d =0;
        int time =0;

        do{
            if(visited[r][c][d]){
                System.out.print(-1);
                System.exit(0);
            }

            visited[r][c][d] = true;
            int nx = r + deltas[d][0];
            int ny = c + deltas[d][1];

            //1. 바로 앞이 격자 밖이라면 이동해서 탈출
            if(!check(nx,ny)){
                r =nx;
                c = ny;
                time ++;
            }

            //2. 바라보고 있는 방향으로 이동 X, 반시계 90도
            else if(map[nx][ny]==1) {
                d = (d-1+4)%4;
            }

            //3. 바라보고 있는 방향으로 이동 가능
            else {

            //3-1 그 방향으로 이동했다고 가정

                //오른쪽 확인
                int rx = nx + deltas[(d+1)%4][0];
                int ry = ny + deltas[(d+1)%4][1];

                //3-1-1 그 방향을 기준으로 오른쪽 벽이 있다면 그 방향으로 이동
                if(isWall(rx,ry)) {
                    r = nx;
                    c = ny;
                    time ++;
                }

                //3-1-2 오른쪽 벽이 존재하지 않음
                else {
                    //한칸 이동 후, 방향 전환, 그 방향으로 이동
                    d = (d+1) %4;
                    r = nx + deltas[d][0];
                    c = ny + deltas[d][1];
                    time +=2;
                }
            }

        }while(check(r,c));
        System.out.print(time);

    }


    //오른쪽 벽이 존재
    static boolean isWall(int x, int y) {
        return check(x,y) && map[x][y]==1;

    }


    //범위 안에 드는지
    static boolean check(int x, int y) {
        return x>=0 && x<n && y>=0 && y<n;
    }


}