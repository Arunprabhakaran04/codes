import java.util.ArrayList;

public class sort_dll_brute {
    static class Node{
        int data;
        Node next;
        Node prev;
        Node(int data){
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }
    private static Node head = null;
    public static void push(int data){
        Node newnode = new Node(data);
        if (head == null){
            head = newnode;
            return;
        }
        Node temp = head;
        while(temp.next != null){
            temp = temp.next;
        }
        temp.next = newnode;
        newnode.prev = temp;
        
    }
    public static void print(){
        if(head == null){
            System.out.println("No elements in the list ");
            return;
        }
        Node temp = head;
        while(temp != null){
            System.out.println(temp.data);
            temp = temp.next;
        }
        
    }
    public static void sort_dll(){
        ArrayList<Integer> arr = new ArrayList<>();
        Node temp = head;
        while(temp!=null){
            arr.add(temp.data);
            temp = temp.next;
        }
        arr.sort(null);
        temp = head;
        while(temp!=null){
            temp.data = arr.get(0);
            arr.remove(0);
            temp = temp.next;
        }

    }
    public static void main(String[] args) {
        push(6);
        push(8);
        push(1);
        push(17);
        push(0);
        sort_dll();
        print();

        
    }
}
