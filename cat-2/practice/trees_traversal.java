package practice;
import java.util.*;
//class Node{
//    int data;
//    Node left;
//    Node right;
//    Node(int data, Node left, Node right){
//        this.data = data;
//        this.left = null;
//        this.right = null;
//    }
//}
public class trees_traversal {
    private static Node root;
    public static Node buildtree(String[] input){
        if (input[0].equals("N") || input.length == 0){
            return null;
        }
        Queue<Node> queue = new LinkedList<>();
        int i = 1;
        Node head = new Node(Integer.parseInt(input[0]));
        queue.add(head);
        while(!queue.isEmpty() && i<input.length){
            Node node = queue.poll();
            if (!input[i].equals("N")){
                node.left = new Node(Integer.parseInt(input[i]));
                queue.add(node.left);
            }
            i++;
            if (i >= input.length){
                break;
            }
            if (!input[i].equals("N")){
                node.right = new Node(Integer.parseInt(input[i]));
                queue.add(node.right);
            }
            i++;

        }
        return head;
    }
    public static void inorder(Node node){
        if (node == null) return;
        inorder(node.left);
        System.out.print(node.data + " ");
        inorder(node.right);
    }
    public static void preorder(Node node){
        if (node == null) return;
        System.out.print(node.data + " ");
        preorder(node.left);
        preorder(node.right);
    }
    public static void postorder(Node node){
        if (node == null) return;
        postorder(node.left);
        postorder(node.right);
        System.out.print(node.data + " ");
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] input = sc.nextLine().split(" ");
        Node root = buildtree(input);
        inorder(root);
        System.out.println();
        preorder(root);
        System.out.println();
        postorder(root);

    }
}
