import java.util.*;
public class tower_of_hanoi {
    public static void towerofhanoi(int n, String source, String aux, String dest){
        if (n == 1){
            System.out.println("Move disk 1 from "+source + " to "+ dest);
            return;
        }
        towerofhanoi(n-1, source, dest, aux);
        System.out.println("Moving disk "+n+" from "+ source +" to "+ dest);
        towerofhanoi(n-1, aux, source, dest);
    }
    public static void main(String[] args) {
        int n = 3;
        towerofhanoi(n, "A", "B", "C");
    }
}
