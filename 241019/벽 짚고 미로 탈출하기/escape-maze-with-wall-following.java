import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
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
        r = Integer.parseInt(tokens.nextToken())-1;
        c = Integer.parseInt(tokens.nextToken())-1;
        map = new int[n][n];
        visited = new boolean[n][n][4];
        for(int i=0; i<n; i++) {
            String str = input.readLine();
            for(int j=0; j<n; j++) {
                if(str.charAt(j) == '#') map[i][j]=1;
                else map[i][j]=0;
            }
        }
        //System.out.println(Arrays.deepToString(map));
        int d =0;
        int time = 0;

        do{

            //현재 위치에 같은 방향으로 진행한 적이 이미 있었는지 확인
            //이미 한번 겪었던 상황이면, 탈출이 불가능하다는 의미
            if(visited[r][c][d]) { //불가능
                System.out.print(-1);
                System.exit(0);
            }

            //현재값 방문표시
            visited[r][c][d] = true;

            int nx = r + deltas[d][0];
            int ny = c + deltas[d][1];


            //step1
            //바라보고 있는 방향으로 이동하는 것이 가능하지 않은 경우
            // 90도 반시계 회전
            if(wall(nx,ny)) {
                d = (d-1 +4)%4;
            }


            //step2
            //바라보는 방향으로 이동한 것이 가능한 경우, 바로 앞이 격자 밖
            else if(!check(nx, ny)) {
                r = nx;
                c = ny;
                time ++;
            }

            //바라보는 방향으로 이동
            else{

                //그 방향으로 이동했다고 가정할 때 오른쪽 벽이 존재하는지 여부
                int rx = nx +deltas[(d+1)%4][0];
                int ry = ny +deltas[(d+1)%4][1];

                //오른쪽에 벽이 있다면 해당 방향으로 이동 가능
                if(wall(rx,ry)) {
                    r = nx;
                    c = ny;
                    time ++;
                }
                //오른쪽에 벽이 없다면 2칸 이동 후 시계방향으로 바꿈
               else{
                    r = rx;
                    c = ry;
                    d = (d+1) %4;
                    time +=2;
                }

            }
        } while(check(r,c));

        System.out.print(time);

    }



    static boolean check(int x, int y) {

        return (x>=0 && x<n) && (y>=0 && y<n);
    }

    //벽이 있는지 없는지
    static boolean wall(int x, int y) {
        return check(x,y) && map[x][y] == 1;
    }

}