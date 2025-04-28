import java.util.*;
public class loop_detect_2{
    public static class Node{
        int data;
        Node next;
        Node(int data){
            this.data = data;
            this.next = null;
        }
    }
    public static Node head;
    public static void push(int ele){
        Node new_node = new Node(ele);
        if(head == null){
            head = new_node;
            return;
        }
        Node curr = head;
        while(curr.next != null){
            curr = curr.next;
        }
        curr.next = new_node;
    }

    public static boolean detectloop(){
        if (head == null){
            return false;
        }
        Node slow = head;
        Node fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        push(2);
        push(4);
        push(6);
        push(8);

        // if (head != null && head.next != null && head.next.next != null){
        //     head.next.next.next = head;

        // }
        if (detectloop()){
            System.out.println("loop there");
        }
        else{
            System.out.println("no loop");
        }
        
    }
}