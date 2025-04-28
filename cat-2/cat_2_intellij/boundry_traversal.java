package cat_2_intellij;
import java.util.*;

public class boundry_traversal {
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

    public static void boundry_left(Node node){
        if (node == null) return;
        if (node.left != null){
            System.out.println(node.data + " ");
            boundry_left(node.left);
        }
        else if (node.right != null){
            System.out.println(node.data + " ");
            boundry_left(node.right);
        }

    }
    public static void boundry_leaf(Node node){
        if (node == null){
            return;
        }
        boundry_leaf(node.left);
        if (node.left == null && node.right == null){
            System.out.println(node.data + " ");

        }
        boundry_leaf(node.right);
    }

    public static void boundry_right(Node node){
        if (node == null) return;

        if (node.right != null){
            boundry_right(node.right);
            System.out.println(node.data);
        }
        else if (node.left != null){
            boundry_right(node.left);
            System.out.println(node.data);
        }
    }

    public static void boundry(Node root){
        if (root == null){
            return;
        }
        System.out.println(root.data);
        if (root.left != null) boundry_left(root.left);

        boundry_leaf(root.left);
        boundry_leaf(root.right);

        if(root.right != null) boundry_right(root.right);
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        Node root = buildtree(input);
        boundry(root);

    }
}
