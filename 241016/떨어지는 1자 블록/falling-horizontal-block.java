import java.io.*;
import java.util.*;

public class Main {
	static StringTokenizer tokens;
	static StringBuilder output = new StringBuilder();
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static int n,m,k;
	static int[][] map;
	public static void main(String[] args) throws IOException {
		tokens = new StringTokenizer(input.readLine());
		n =Integer.parseInt(tokens.nextToken());
		m =Integer.parseInt(tokens.nextToken());
		k = Integer.parseInt(tokens.nextToken());
		map = new int[n][n];
		for(int i=0;i<n;i++) {
			tokens = new StringTokenizer(input.readLine());
			for(int j=0;j<n;j++) {
				map[i][j] = Integer.parseInt(tokens.nextToken());
			}
		}
		//아래만 체크하면 됨, 그 아래가 체크가 되면 그 아래를 기준으로 떨어지면 됨
		int start = k-1;
		int end = k+m-1;
		int stop = 0; //그만두게 되는 행
		boolean flag = true;
		for(int i=0; i<n-1; i++) {
			//아래가 닿으면
			if(!check(i,start,end)) {
				stop =i;
				flag = false;
				break;
			}
		}
		if(!flag) { //마지막인 열이 아닌경우
			for(int i=start; i<end; i++) {
				map[stop][i] =1;
			}
		}
		else { //마지막 열인 경우
			for(int i=start; i<end; i++) {
				map[n-1][i] =1;
			}
		}
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				System.out.print(map[i][j]+" ");
			}
			System.out.println();
		}
	}
	static boolean check(int row, int start, int end){
		for(int i=start; i<end; i++){

			if(map[row+1][i] == 1) {
				return false;
			}
		}
		return true;
	}
}