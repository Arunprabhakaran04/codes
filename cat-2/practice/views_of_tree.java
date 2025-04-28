package practice;
import java.util.*;
class Pair{
    int hd;
    Node node;
    Pair(Node node, int hd){
        this.node = node;
        this.hd = hd;
    }
}
public class views_of_tree {
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
    public static void topview(Node node){
        if (node == null) return;
        List<Integer> answer = new ArrayList<>();
        Queue<Pair> queue = new LinkedList<>();
        TreeMap<Integer, Integer> map = new TreeMap<>();
        queue.add(new Pair(node, 0));
        while(!queue.isEmpty()){
            Pair ele = queue.poll();
            Node node1 = ele.node;
            int hd = ele.hd;
            if (map.get(hd) == null) map.put(hd, node1.data);

            if (node1.left != null) queue.add(new Pair(node1.left, hd-1));
            if (node1.right != null) queue.add(new Pair(node1.right, hd+1));
        }
        answer.addAll(map.values());
        System.out.println(answer);

    }
    public static void bottomview(Node node){
        if (node == null) return;
        List<Integer> answer = new ArrayList<>();
        Queue<Pair> queue = new LinkedList<>();
        TreeMap<Integer, Integer> map = new TreeMap<>();
        queue.add(new Pair(node, 0));
        while(!queue.isEmpty()){
            Pair ele = queue.poll();
            Node node1 = ele.node;
            int hd = ele.hd;
            map.put(hd, node1.data);

            if (node1.left != null) queue.add(new Pair(node1.left, hd-1));
            if (node1.right != null) queue.add(new Pair(node1.right, hd+1));
        }
        answer.addAll(map.values());
        System.out.println(answer);
    }
    public static void leftview(Node node){
        if (node == null) return;
        List<Integer> answer = new ArrayList<>();
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(node, 0));
        while(!queue.isEmpty()){
            int n = queue.size();
            for(int i =0; i<n; i++){
                Pair ele = queue.poll();
                int hd = ele.hd;
                Node node1 = ele.node;
                if (i == 0) answer.add(node1.data);
                if (node1.left != null) queue.add(new Pair(node1.left, hd-1));
                if (node1.right != null) queue.add(new Pair(node1.right, hd+1));
            }
        }
        System.out.println(answer);
    }
    public static void rightview(Node node){
        if (node == null) return;
        List<Integer> answer = new ArrayList<>();
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(node, 0));
        while(!queue.isEmpty()){
            int n = queue.size();
            for(int i =0; i<n; i++){
                Pair ele = queue.poll();
                int hd = ele.hd;
                Node node1 = ele.node;
                if (hd == n-1) answer.add(node1.data);
                if (node1.left != null) queue.add(new Pair(node1.left, hd-1));
                if (node1.right != null) queue.add(new Pair(node1.right, hd+1));
            }
        }
        System.out.println(answer);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] input = sc.nextLine().split(" ");
        Node root = buildtree(input);
        topview(root);
        bottomview(root);
        leftview(root);
        rightview(root);
    }
}
