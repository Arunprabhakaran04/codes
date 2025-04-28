public class even_odd_list {
    static class Node{
        int data;
        Node next;
        Node(int data){
            this.data = data;
            this.next = null;
        }
        
    }
    private static Node head;
    public static void push(int ele){
        Node newnode = new Node(ele);
        if (head == null){
            head = newnode;
            return;
        }
        Node temp = head;
        while(temp.next != null){
            temp = temp.next;
        }
        temp.next = newnode;
    }

    public static void print(){
        if (head == null){
            System.out.println("there are no elements in the list ");

        }
        Node temp = head;
        while(temp != null){
            System.out.println(temp.data);
            temp = temp.next;
        }
        System.out.println();
    }
    public static void dualsplit(){
        Node estart = null, eend = null;
        Node ostart = null, oend = null;
        Node curr = head;
        while(curr != null){
            if (curr.data % 2 == 0){
                if (estart == null){
                    estart = curr;
                    eend = estart;
                }
                else{
                    eend.next = curr;
                    eend = eend.next;
                }
            }
            else{
                if (ostart == null){
                    ostart = curr;
                    oend = ostart;
                }
                else{
                    oend.next = curr;
                    oend = oend.next;
                }
            }
            curr = curr.next;
        }
        if (ostart == null || oend == null){
            return;
        }
        head = estart;
        eend.next = ostart;
        oend.next = null;

    }
    public static void main(String[] args) {
        push(7);
        push(8);
        push(1);
        push(10);
        push(6);
        push(99);
        push(18);
        dualsplit();
        print();
        
    }
}
