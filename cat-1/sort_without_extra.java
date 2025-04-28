import java.util.*;
public class sort_without_extra {
    public static void main(String[] args) {
        Queue<Integer> lst = new LinkedList<Integer>();
        lst.add(10);
        lst.add(15);
        lst.add(9);
        lst.add(80);
        ArrayList<Integer> arrlst = new ArrayList<>();

        for(int num:lst){
            arrlst.add(num);
        }
        arrlst.sort(null);
        Queue<Integer> newlst = new LinkedList<>();
        int n = arrlst.size();
        for(int i = 0; i<n; i++){
            newlst.add(arrlst.get(0));
            arrlst.remove(0);
        }

        int qsize = newlst.size();
        for(int i = 0; i<qsize; i++){
            System.out.println(newlst.poll());
        }
        
    }
}
