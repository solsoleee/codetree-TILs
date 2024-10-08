import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {


	static StringTokenizer tokens;
	static StringBuilder output = new StringBuilder();
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static int n;
	static int arr[][];
	static boolean visitedRow[];
	static boolean visitedCol[];
	static int res[];
	static int maxVal = Integer.MIN_VALUE;

	public static void main(String[] args) throws IOException {
		n = Integer.parseInt(input.readLine());
		arr =new int [n][n];
		visitedRow = new boolean[n];
		visitedCol = new boolean[n];
		res = new int[n];

		for(int i=0; i<n; i++) {
			tokens = new StringTokenizer(input.readLine());
			for(int j=0; j<n; j++) {
				arr[i][j] = Integer.parseInt(tokens.nextToken());
			}
		}
		permutation(0);
		System.out.println(maxVal);
	}
	static void permutation(int cnt) {
		if(cnt == n) {
			int min=Integer.MAX_VALUE;
			for(int i=0; i<n; i++) {
				min = Math.min(min, res[i]);
			}
			maxVal = Math.max(maxVal, min);
			return;
		}
		for(int i=0; i<n*n; i++) {
			int row = i/n;
			int col = i%n;
			if(!visitedRow[row] && !visitedCol[col]) {
				res[cnt] = arr[row][col];
				visitedRow[row] = true;
				visitedCol[col] = true;
				permutation(cnt+1);
				visitedRow[row] = false;
				visitedCol[col] = false;
			}
		}
	}
}