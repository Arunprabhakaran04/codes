package practice;
import java.util.*;
class Node{
    int data;
    Node left;
    Node right;
    Node(int val){
        this.data = val;
        this.left = null;
        this.right = null;
    }
}
public class boundry_traversal_build {
    private static Node root;
    public static Node buildtree(String[] input){
        if (input[0].equals("N") || input.length == 0){
            return null;
        }
        Node root = new Node(Integer.parseInt(input[0]));
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        int i = 1;
        while(!queue.isEmpty() && i < input.length){
            Node node = queue.poll();
            if(!input[i].equals("N")){
                int currval = Integer.parseInt(input[i]);
                node.left = new Node(currval);
                queue.add(node.left);
            }
            i++;
            if (i >= input.length) break;
            if (!input[i].equals("N")){
                int currval = Integer.parseInt(input[i]);
                node.right = new Node(currval);
                queue.add(node.right);
            }
            i++;
        }
        return root;
    }
    public static void boundry_left(Node node){
        if (node == null) return;
        if (node.left != null){
            System.out.print(node.data + " ");
            boundry_left(node.left);
        }
        else if(node.right != null){
            System.out.print(node.data + " ");
            boundry_left(node.right);
        }
    }
    public static void boundry_right(Node node){
        if (node == null) return;
        if (node.right != null){
            boundry_right(node.right);
            System.out.print(node.data+ " ");
        }
        else if (node.left != null){
            boundry_right(node.left);
            System.out.print(node.data+ " ");
        }
    }
    public static void boundry_leaf(Node node){
        if (node == null) return;
        boundry_leaf(node.left);
        if (node.left == null && node.right == null){
            System.out.print(node.data + " ");
        }
        boundry_leaf(node.right);
    }
    public static void boundrytraversal(Node node){
        if (node == null){
            return;
        }
        System.out.print(node.data + " ");
        if (node.left != null) boundry_left(node.left);

        boundry_leaf(node.left);
        boundry_leaf(node.right);

        if (node.right != null) boundry_right(node.right);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] input = sc.nextLine().split(" ");
        Node root = buildtree(input);
        boundrytraversal(root);
    }
}
