public class priorityqueue {
    static class Node{
        int data;
        int priority; 
        Node next;
        Node prev;
        Node(int data, int priority){
            this.data = data;
            this.priority = priority;
            this.next = null;
        }
    }
    private static Node head = null;
    public static void push(int val, int prioirty){
        Node newnode = new Node(val, prioirty);
        if (head == null){
            head = newnode;
            return;
        }
        Node parent = null;
        Node temp = head;
        while(temp != null && temp.priority < prioirty){
            parent = temp;
            temp = temp.next;
        }
        if(parent == null){
            head.prev = newnode;
            newnode.next = head;
            head = newnode;
        }
        if (temp == null){
            parent.next = newnode;
            newnode.prev = parent;
        }
        else{
            parent.next = newnode;
            newnode.prev = parent;
            newnode.next = temp;
            temp.prev = newnode;
        }
             
    }
    public static void peek(){
        if (head == null){
            System.out.println("queue is empty");
            return;
        }
        System.out.println(head.data);
        
    }
    public static void pop(){
        if (head == null){
            System.out.println("queue is empty");
            return;
        }
        int curr = head.data;
        head = head.next;
        if(head.prev != null){
            head.prev = null;
        }
        System.out.println("poped element is "+ curr);
    }
    public static void main(String[] args) {
        
        
    }
}
