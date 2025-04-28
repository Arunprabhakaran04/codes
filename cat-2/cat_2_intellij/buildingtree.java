package cat_2_intellij;
import java.util.*;
public class buildingtree {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] temp = sc.nextLine().split(" ");
        int v = Integer.parseInt(temp[0]);
        int e = Integer.parseInt(temp[1]);
        String[] edges = sc.nextLine().split(" ");

        Map<Integer, Node> map = new HashMap<>();
        for(int i =0; i<v; i++){
            map.put(i, new Node(i));
        }
    }
}
