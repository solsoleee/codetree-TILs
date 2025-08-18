import java.util.*;

public class Main {
    static int n;
    static int [][] grid;
    static int [][] deltas = {{0,1}, {1,0}, {-1,0}, {0,-1}};
    static int [][] temp;
    static int maxVal = Integer.MIN_VALUE;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        grid = new int[n][n];
        temp = new int [n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                grid[i][j] = sc.nextInt();
        
        //완탐
        for(int i=0; i<n; i++ ) {
            for(int j=0; j<n; j++) {
                init();//초기화
                bomp(i,j); //1.터짐
                gravity(); //2. 중력내려옴
                int r = pairRow() + pairCol(); //3.짝지음
                maxVal = Math.max(maxVal, r);
            }
        }
    
        System.out.println(maxVal);
    }
    static int pairRow() {
    int res = 0;
    for (int i = 0; i < n; i++) {
        int cnt = 1;
        for (int j = 1; j < n; j++) {
            if (temp[i][j] != 0 && temp[i][j] == temp[i][j-1]) {
                cnt++;
            } else {
                if (cnt == 2) res++;
                cnt = 1;
            }
        }
        if (cnt == 2) res++;
    }
    return res;
}

static int pairCol() {
    int res = 0;
    for (int j = 0; j < n; j++) {
        int cnt = 1;
        for (int i = 1; i < n; i++) {
            if (temp[i][j] != 0 && temp[i][j] == temp[i-1][j]) {
                cnt++;
            } else {
                if (cnt == 2) res++;
                cnt = 1;
            }
        }
        if (cnt == 2) res++;
    }
    return res;
}

    // //2개인것만 짝지음 (행, 각각)
    // static int pairRow() {
    //     int res = 0;
    //     for(int i=0; i<n; i++) {
    //         int cnt =1;
    //         for(int j=1; j<n; j++) {
    //             if(temp[i][j-1] == temp[i][j]) {
    //                 cnt++;
    //             }
    //             else{
    //                 if(cnt == 2) res++;
    //                 cnt = 1;
    //             }
    //         }
    //         if(cnt == 2) res++;
    //     }
    //     return res;
    // }
    //     //2개인것만 짝지음 (행, 각각)
    // static int pairCol() {
    //     int res = 0;
    //     for(int i=0; i<n; i++) {
    //         int cnt =1;
    //         for(int j=1; j<n; j++) {
    //             if(temp[j-1][i] == temp[j][i]) {
    //                 cnt++;
    //             }
    //             else{
    //                 if(cnt == 2) res++;
    //                 cnt = 1;
    //             }
    //         }
    //         if(cnt == 2) res++;
    //     }
    //     return res;
    // }

    //중력, 0일 때 내려옴
    // static void gravity() {
    //     for(int i=0; i<n; i++ ) {
    //         for(int j=n-1; j>0; j--) {
    //             //맨 아래부터 검사
    //             if(temp[j][i] == 0) {
    //                 //아래가 0이면 한칸씩 땡겨오기
    //                 temp[j][i] = temp[j-1][i];
    //                 temp[j-1][i] = 0;
    //             }
    //         }   
    //     }
    // }
    
    static void gravity() {
    for (int col = 0; col < n; col++) {
        int write = n - 1; // 아래에서부터 채워넣을 위치
        for (int row = n - 1; row >= 0; row--) {
            if (temp[row][col] != 0) {
                temp[write][col] = temp[row][col];
                if (write != row) temp[row][col] = 0; // 자리를 옮겼다면 원래 칸은 0
                write--;
            }
        }
        // 위에 남은 부분은 다 0으로
        for (int row = write; row >= 0; row--) {
            temp[row][col] = 0;
        }
    }
}
       

    //초기화
    static void init() {
        for(int i=0; i<n; i++) {
            temp[i] = Arrays.copyOf(grid[i], n);
        }
    }

    //폭탄 터짐
    static boolean check(int x, int y) {
        return x>=0 && x<n && y>=0 && y<n;
    }

    static void bomp(int x, int y) {
        int num = grid[x][y];
        temp[x][y] = 0;
        for(int d[] : deltas) {
            int nx = x;
            int ny = y;
            for(int i=1; i<num; i++) {
                int dx = nx + d[0];
                int dy = ny + d[1];
                if(check(dx, dy)) {
                    temp[dx][dy] = 0; //터짐
                }
                
                nx = dx;
                ny = dy;
            }
        }
    }
}