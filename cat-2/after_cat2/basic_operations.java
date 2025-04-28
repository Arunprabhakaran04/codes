package after_cat2;

import java.util.HashSet;
import java.util.*;
public class basic_operations {
    public static void main(String[] args) {
        Set<Integer> set = new HashSet<>();
        set.add(1);
        set.add(130);
        set.add(12);
        set.add(2);
//        Iterator<Integer> it = set.iterator();
//        while(it.hasNext()){
//            System.out.println(it.next());
//        }
        for (Integer integer : set) {
            System.out.println(integer);
        }
        set.remove(130);

//        TreeSet<Integer> set1 = new TreeSet<>(); - addAll(), contains(), pollFirst(), pollLast()
//        LinkedHashSet<Integer> set1 = new LinkedHashSet<>() - maintains the order of insertion.
    }
}
