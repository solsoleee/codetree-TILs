import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.*;

public class Main {

    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer tokens;

    public static void main(String[] args) throws IOException {
        Map<String, Integer> map = new HashMap<>();
        int n = Integer.parseInt(input.readLine());
        for(int i=0; i<n; i++) {
            String str = input.readLine();
            map.put(str, map.getOrDefault(str, 0)+1);
        }

        Collection<Integer> list = map.values();
        int max =0;

        for(int l: list) {
            max = Math.max(max, l);
        }
        System.out.print(max);
    }
}