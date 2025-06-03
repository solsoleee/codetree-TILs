import java.util.*;

public class Main {
    static int [][] deltas = {{-1,0},{1,0},{0,-1},{0,1}};
    static int visited[][];
    static int n;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int m = sc.nextInt();
        int t = sc.nextInt();
        int[][] grid = new int[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                grid[i][j] = sc.nextInt();
        int[][] marbles = new int[m][2];
        for (int i = 0; i < m; i++) {
            marbles[i][0] = sc.nextInt()-1;
            marbles[i][1] = sc.nextInt()-1;
        }
        int ans = m;
        boolean[] m_check = new boolean[m];
        while(t > 0) {
            if(ans <=0 ) {
                break;
            }
            List<int[]> list = new ArrayList<>();
            
            visited = new int[n][n];
            for(int i=0; i<m; i++) {
                if(m_check[i]) {
                    continue;
                }
                else {
                    //상하좌우
                    int max_value = Integer.MIN_VALUE;
                    int index = -1;
                    
                    for(int j=0; j<4; j++) {
                        int x = marbles[i][0] + deltas[j][0];
                        int y = marbles[i][1] + deltas[j][1];
                        if(check(x,y)) { //범위를 넘지 않아야함
                            int current = grid[x][y];
                            if(current > max_value) {
                                max_value = current;
                                index = j; //상하좌우 중에 어디인지
                            }
                        }

                    }
                    //가장 큰 값으로 이동하는 visited 체크
                    int dx = marbles[i][0] + deltas[index][0];
                    int dy = marbles[i][1] + deltas[index][1];
                    visited[dx][dy] +=1; 
                    list.add(new int[]{dx,dy});
                    //System.out.println(t+" 초 " + dx + " " +dy);
                    //다음 위치 갱신
                    marbles[i][0] = dx;
                    marbles[i][1] = dy;
                }

            }
            //visited에서 0이 아닌게 있다면 그 수만큼 구슬이 없어짐
            for(int i=0; i<n; i++) {
                for(int j=0; j<n; j++) {
                    if(visited[i][j] >= 2) {
                        ans -= visited[i][j];
                    }
                }
            }
            // 구슬 비 활 성 화
            for(int i=0; i<m; i++) {
                int temp[] = list.get(i);
                for(int j=0; j<list.size(); j++) {
                    if(i==j) continue;
                    if(Arrays.equals(temp, list.get(j))) {
                        m_check[i] = true;
                        break;
                    }
                }
            }

            
            // 구슬 1번부터 차례대로 큰 곳에
            // 위치 저장,
            // 겹치는 걸 찾아야 함 -> 어떻게 저장? -> 리스트에 넣어둬서 contains
            //구슬의 수만 체크

            t--;
        }
        // Please write your code here.
        System.out.println(ans);
    }

    static boolean check(int x, int y) {
        return x>=0 && x<n && y>=0 && y<n;
    }
}