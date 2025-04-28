package cat_2_intellij;
import java.util.*;
class Pair{
    Node node;
    int hd;
    Pair(Node n, int h){
        node =  n;
        hd = h;
    }
}

public class VerticalOrderTraversal {
    static void verticalordertravesal(Node root){
        if(root == null) return;
        TreeMap<Integer, ArrayList<Integer>> map = new TreeMap<>();
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(root, 0));

        while(!queue.isEmpty()){
            Pair p = queue.poll();
            Node node = p.node;
            int hd = p.hd;

            map.putIfAbsent(hd, new ArrayList<>());
            map.get(hd).add(node.data);

            if (node.left != null) queue.add(new Pair(node.left, hd-1));
            if (node.right != null) queue.add(new Pair(node.right, hd + 1));

        }
        for(ArrayList<Integer> values: map.values()){
//            Collections.sort(values);
            for(int val : values){
                System.out.println(val + " ");
            }
            System.out.println();
        }

    }


    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        verticalordertravesal(root);
    }
}
