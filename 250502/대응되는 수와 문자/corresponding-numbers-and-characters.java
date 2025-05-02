import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        String[] words = new String[n + 1];
        HashMap<String, Integer> map = new HashMap<>();
        
        for (int i = 1; i <= n; i++) {
            words[i] = sc.next();
            map.put(words[i],i);
        }
        for(int i=0; i<m; i++ ) {
            String command = sc.next();
            char c = command.charAt(0);
           
            if(c>='0' && c<='9') {
                System.out.println(words[Integer.parseInt(command)]);
            }
            else System.out.println(map.get(command));
            // if(Character.isDigit(c)){
            //     System.out.println(words[Integer.parseInt(c)]);
            // }
            // else System.out.println(map.get(command));
        }
        // Please write your code here.



    }
}