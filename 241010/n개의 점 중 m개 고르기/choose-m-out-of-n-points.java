import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static StringTokenizer tokens;
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static int n,m;
	static int arr[][];
	static int res[][];
	static boolean visited[];
	static int min = Integer.MAX_VALUE;
	public static void main(String[] args) throws IOException {
		tokens = new StringTokenizer(input.readLine());
		n = Integer.parseInt(tokens.nextToken());
		m = Integer.parseInt(tokens.nextToken());
		arr = new int [n][2];
		res = new int[m][2];
		visited = new boolean[n];
		for(int i=0; i<n; i++) {
			tokens = new StringTokenizer(input.readLine());
			arr[i][0] = Integer.parseInt(tokens.nextToken());
			arr[i][1] = Integer.parseInt(tokens.nextToken());
		}
		combi(0,0);
		System.out.println(min);
	}
	static void combi(int start, int cnt) {
		if(cnt == m) {
			int d = check();
			min = Math.min(min, d);
			return;
		}
		for(int i=start; i<n; i++) {
			if(!visited[i]) {
				visited[i] = true;
				res[cnt][0] = arr[i][0];
				res[cnt][1] = arr[i][1];
				combi(i+1, cnt+1);
				visited[i] = false;
			}
		}
	}
	static int check() {
		int d=0;
		int maxVal  = Integer.MIN_VALUE;
		//System.out.println(Arrays.deepToString(res));
		for(int i=0; i<m-1; i++) {
			for(int j=i+1; j<m; j++) {
				d = (int) Math.pow(res[i][0] - res[j][0], 2) + (int) Math.pow(res[i][1] - res[j][1], 2);
				//System.out.println(d);
                maxVal = Math.max(d, maxVal);
			}
			
			//System.out.println(maxVal);
		}
		return maxVal;
	}
}