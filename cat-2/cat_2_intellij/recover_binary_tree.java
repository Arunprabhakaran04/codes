package cat_2_intellij;
import java.util.*;

//class Node{
//    int data;
//    Node left;
//    Node right;
//    Node(int data){
//        this.data = data;
//    }
//}

public class recover_binary_tree {
    //construction of binary tree -
    public static Node buildtree(String input){
        input = input.replaceAll("\\[|\\]","");
        String[] nodes = input.split(",");
        if(nodes.length == 0 || nodes[0].equals("null")) return null;

        Node root = new Node(Integer.parseInt(nodes[0]));
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        int i = 1;
        while(i<nodes.length && !queue.equals("null")){
            Node current = queue.poll();
            if(!nodes[i].equals("null")){
                current.left = new Node(Integer.parseInt(nodes[i]));
                queue.add(current.left);
            }
            i++;
            if(i<nodes.length && !nodes[i].equals("null")){
                current.right = new Node(Integer.parseInt(nodes[i]));
                queue.add(current.right);
            }
            i++;
        }
        return root;
    }
    // find swapped nodes -
    static Node first, second, prev;
    public static void findswappednodes(Node node){
        if (node == null){
            return;
        }
        findswappednodes(node.left);
        if(prev != null && node.data < prev.data){
            if (first == null){
                first = prev;
            }
            second = node;
        }
        prev = node;
        findswappednodes(node.right);
    }

    //recovering -
    public static void recover(Node root){
        first = second =prev = null;
        findswappednodes(root);
        if (first != null && second != null){
            int temp = first.data;
            first.data = second.data;
            second.data = temp;

        }


    }
    //level-order traversing -
    public static List<Integer> levelordertravering(Node root){
        List<Integer> result = new ArrayList<>();
        Queue<Node> que = new LinkedList<>();
        if (root == null) return result;

        que.add(root);
        while(!que.isEmpty()){
            Node curr = que.poll();
            if (curr != null){
                result.add(curr.data);
                que.add(curr.left);
                que.add(curr.right);

            }
            else{
                result.add(-1);
            }

        }
        while(result.get(result.size()-1) == -1){
            result.remove(result.size()-1);

        }
        return result;

    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        Node root = buildtree(input);
        recover(root);
        List<Integer> lst = levelordertravering(root);
        System.out.println(lst);
//        scanner.close();
//
//        TreeNode root = buildTreeFromInput(input);
//        System.out.println("Input: " + treeToString(root));
//
//        new BSTRecovery().recoverTree(root);
//
//        System.out.println("Output: " + treeToString(root));
    }
}


