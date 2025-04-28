package cat_2_intellij;
import java.util.LinkedList;
import java.util.Queue;
import java.util.*;

public class views_of_tree {
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
    public static ArrayList<Integer> rightorder(Node root){
        ArrayList<Integer> lst = new ArrayList<>();
        if (root == null) return lst;
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()){
            int n = queue.size();
            for(int i = 0; i<n; i++){
                Node curr = queue.poll();
                if (i == n-1) lst.add(curr.data);
                if (curr.left != null) queue.add(curr.left);
                if (curr.right != null) queue.add(curr.right);

            }
        }
        return lst;
    }
    public static ArrayList<Integer> leftorder(Node root){
        ArrayList<Integer> result = new ArrayList<>();
        if (root == null) return result;
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while(q.isEmpty()){
            int n = q.size();
            for(int i = 0; i<n; i++){
                Node curr = q.poll();
                if (i == 0) result.add(curr.data);
                if (curr.left != null) q.add(curr.left);    
                if (curr.right != null) q.add(curr.right);
            }
        }
        return result;

    }
    public static ArrayList<Integer> topview(Node root){
        ArrayList<Integer> res = new ArrayList<>();
        if (root == null) return res;

        Map<Integer, Integer> map = new TreeMap<>();
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(root, 0));
        while(!q.isEmpty()){
            Pair p = q.poll();
            Node node = p.node;
            int hd = p.hd;
            if (!map.containsKey(hd)) map.put(hd, node.data);
            if(node.left != null) q.add(new Pair(node.left, hd-1));
            if(node.right != null) q.add(new Pair(node.right, hd+1));

        }
        res.addAll(map.values());
        return res;

    }
    public static ArrayList<Integer> bottomview(Node root){
        ArrayList<Integer> res = new ArrayList<>();
        if (root == null) return res;

        Map<Integer, Integer> map = new TreeMap<>();
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(root, 0));

        while(!q.isEmpty()){
            Pair curr = q.poll();
            Node node = curr.node;
            int hd = curr.hd;

            map.put(hd, node.data);
            if (node.left != null) q.add(new Pair(node.left, hd - 1));
            if (node.right != null) q.add(new Pair(node.right, hd - 1));
        }
        return res;
    }
    public static void main(String[] args) {
        System.out.println("");

    }
}
