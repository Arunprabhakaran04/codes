package practice;

import java.util.LinkedList;
import java.util.Queue;
import java.util.*;
public class recover_the_bst {
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
    public static void inorder(List<Integer> lst, Node node){
        if(root == null) return;
        inorder(lst, node.left);
        lst.add(node.data);
        inorder(lst, node.right);
    }
    public static void recoverbst(Node node, List<Integer> lst, int index){
        if (node == null) return;
        recoverbst(node, lst, index);
        if (node.data != lst.get(index)) {
            node.data = lst.get(index);
        }
        recoverbst(node, lst, index);

    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] input = sc.nextLine().split(" ");
        Node root = buildtree(input);
        List<Integer> inorderlst = new ArrayList<>();
        inorder(inorderlst, root);
        recoverbst(root, inorderlst, 0);
        List<Integer> answer = new ArrayList<>();
        inorder(answer, root);
    }
}
