import java.util.*;
public class Main {
    static int n;
    static int [] blocks;
    static List<Integer> list = new ArrayList<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        blocks = new int[n];
        for (int i = 0; i < n; i++) {
            blocks[i] = sc.nextInt();
            list.add(blocks[i]);
        }
        int s1 = sc.nextInt();
        int e1 = sc.nextInt();
        int s2 = sc.nextInt();
        int e2 = sc.nextInt();
        
        //첫번째 제거
        for(int i=s1; i<=e1; i++) {
            list.set(i-1,0);
        }
        //System.out.println(list);
        //아예제거
        for (int i = list.size()-1; i >= 0 ; i--) {
            if(list.get(i)==0) {
                list.remove(i);
            }
        }
        // 
        //두번째 제거
        for(int i=s2; i<=e2; i++) {
            list.set(i-1,0);
        }
        //System.out.println(list);
        //아예제거
        for (int i = list.size()-1; i >= 0 ; i--) {
            if(list.get(i)==0) {
                list.remove(i);
            }
        }
        System.out.println(list.size());
        for(int r: list){
            System.out.println(r);
        }

    }
}