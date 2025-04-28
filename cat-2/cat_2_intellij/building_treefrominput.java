package cat_2_intellij;
import java.util.*;

class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
    }
}

public class building_treefrominput {
    public static Node buildtree(String input){
        input = input.replaceAll("\\[|\\]", "");
        String[] nodes = input.split(",");
        if (nodes.length == 0 || nodes[0].equals("null")) return null;

        Node root = new Node(Integer.parseInt(nodes[0]));
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        int i = 1;
        while(!queue.isEmpty() && i<nodes.length){
            //get the first element -
            Node current  = queue.poll();
            if (!nodes[i].equals("null")){
                current.left = new Node(Integer.parseInt(nodes[i]));
                queue.add(current.left);
            }
            i++;
            //adding the right child -
            if (i<nodes.length && !nodes[i].equals("null")){
                current.right = new Node(Integer.parseInt(nodes[i]));
                queue.add(current.right);
            }
            i++;
        }
        return root;

    }
    static ArrayList<Integer> finalans = new ArrayList<>();
    public static void printinorder(Node node){
        if (node == null){
            //finalans.add(null);
            return;
        }
        printinorder(node.left);
        finalans.add(node.data);
        //System.out.println(node.data + " ");
        printinorder(node.right);

    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        sc.close();

        Node root = buildtree(input);
        printinorder(root);
        System.out.println(finalans);

    }

}
