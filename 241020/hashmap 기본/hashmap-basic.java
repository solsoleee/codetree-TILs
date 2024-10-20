import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    static StringTokenizer tokens;
    static boolean flag;
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(input.readLine());
        Map<String, String> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String str[] = input.readLine().split(" ");
            if (str[0].equals("add")) {
                map.put(str[1], str[2]);
            } else if (str[0].equals("find")) {
                String f = map.get(str[1]);
                if(f!=null) System.out.println(f);
                else System.out.println("None");
            } else {
                map.remove(str[1]);
            }
        }
    }
}