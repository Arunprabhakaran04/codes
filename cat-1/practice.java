import java.util.*;
class Node2{
    int data;
    Node2 next;
    Node2(int data){
        this.data = data;
        this.next = null;
    }
}
public class practice {
    public static Node2 head;
    public static void push(int x){
        Node2 newnode = new Node2(x);
        if (head == null){
            head = newnode;
            return;
        }
        Node2 temp = head;
        while(temp.next != null){
            temp = temp.next;

        }
        temp.next = newnode;
    }
    public static boolean loopdetect(){
        if (head == null) return false;
        Node2 fast = head;
        Node2 slow = head;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow) return true;
        }
        return false;


    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x;
        while((x = sc.nextInt()) != -1){
            push(x);
        }
        Node2 temp = head;
        while(temp.next != null) {
            temp = temp.next; // reach the last node (5)
        }
        Node2 loopPoint = head;
        for(int i = 0; i < 2; i++) { // move 2 steps to reach node with value 3
            loopPoint = loopPoint.next;
        }
        temp.next = loopPoint;
        if (loopdetect()) System.out.println("there is a loop");
        else System.out.println("there is no loop ");
    }
}
