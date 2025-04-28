import java.util.*;

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class loop_detection {
    Node head;

    public void push(int ele) {
        Node new_node = new Node(ele);
        if (head == null) {
            head = new_node;
            return;
        }
        Node curr = head;
        while (curr.next != null) {
            curr = curr.next;
        }
        curr.next = new_node;
    }

    public boolean detectloop() {
        Node slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }
}

public class detect_loop {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        loop_detection llist = new loop_detection();
        int x;
        while ((x = sc.nextInt()) != -1) {
            llist.push(x);
        }

        if (llist.head != null && llist.head.next != null && llist.head.next.next != null) {
            llist.head.next.next.next = llist.head; 
        }

        if (llist.detectloop()) {
            System.out.println("Loop detected");
        } else {
            System.out.println("No loop detected");
        }
        sc.close();
    }
}
