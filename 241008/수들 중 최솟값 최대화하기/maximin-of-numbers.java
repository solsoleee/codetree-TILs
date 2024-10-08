import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static StringTokenizer tokens;
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static int n;
	static int arr[][];
	static int res[];
	static boolean visited[];
	static int maxVal = Integer.MIN_VALUE;

	public static void main(String[] args) throws IOException {
		n = Integer.parseInt(input.readLine());
		arr = new int[n][n];
		visited = new boolean[n];
		res = new int[n];
		for (int i = 0; i < n; i++) {
			tokens = new StringTokenizer(input.readLine());
			for (int j = 0; j < n; j++) {
				arr[i][j] = Integer.parseInt(tokens.nextToken());
			}
		}
		dfs(0);
		System.out.println(maxVal);
	}

	static void dfs(int cnt) {

		if(cnt == n ) {
			int min = Integer.MAX_VALUE;
			for(int i = 0; i < n; i++) {
				min = Math.min(min, res[i]);
			}
			maxVal = Math.max(maxVal, min);
			return;
		}
		for(int i=0; i<n; i++) {
			if(!visited[i]) {
				visited[i] = true;
				res[cnt] = arr[cnt][i];
				dfs(cnt+1);
				visited[i] = false;
			}
		}


	}
}