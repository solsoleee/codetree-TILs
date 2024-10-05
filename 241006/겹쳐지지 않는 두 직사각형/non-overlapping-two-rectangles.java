import java.util.Scanner;

public class Main {
    public static final int INT_MIN = Integer.MIN_VALUE;
    public static final int MAX_NUM = 5;
    
    public static int n, m;
    public static int[][] grid = new int[MAX_NUM][MAX_NUM];
    public static int[][] board = new int[MAX_NUM][MAX_NUM];
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        
        // 격자 입력 받기
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                grid[i][j] = sc.nextInt();
        
        int maxSum = INT_MIN;
        
        // 첫 번째 직사각형 탐색
        for (int x1 = 0; x1 < n; x1++) {
            for (int y1 = 0; y1 < m; y1++) {
                for (int x2 = x1; x2 < n; x2++) {
                    for (int y2 = y1; y2 < m; y2++) {

                        // 첫 번째 직사각형의 합 계산
                        int sum1 = 0;
                        for (int i = x1; i <= x2; i++) {
                            for (int j = y1; j <= y2; j++) {
                                sum1 += grid[i][j];
                            }
                        }

                        // 두 번째 직사각형 탐색
                        for (int i = 0; i < n; i++) {
                            for (int j = 0; j < m; j++) {
                                for (int k = i; k < n; k++) {
                                    for (int l = j; l < m; l++) {
                                        
                                        // 겹치는지 확인하기 위해 보드 초기화
                                        for (int p = 0; p < n; p++) {
                                            for (int q = 0; q < m; q++) {
                                                board[p][q] = 0;
                                            }
                                        }
                                        
                                        // 첫 번째 직사각형 그리기
                                        for (int p = x1; p <= x2; p++) {
                                            for (int q = y1; q <= y2; q++) {
                                                board[p][q]++;
                                            }
                                        }

                                        // 두 번째 직사각형 그리기
                                        boolean overlapped = false;
                                        for (int p = i; p <= k; p++) {
                                            for (int q = j; q <= l; q++) {
                                                board[p][q]++;
                                                if (board[p][q] >= 2) {
                                                    overlapped = true;
                                                    break;
                                                }
                                            }
                                            if (overlapped) break;
                                        }

                                        // 겹치지 않은 경우 두 번째 직사각형의 합 계산
                                        if (!overlapped) {
                                            int sum2 = 0;
                                            for (int p = i; p <= k; p++) {
                                                for (int q = j; q <= l; q++) {
                                                    sum2 += grid[p][q];
                                                }
                                            }

                                            // 최대값 갱신
                                            maxSum = Math.max(maxSum, sum1 + sum2);
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

        System.out.print(maxSum);
    }
}