package cat_2_intellij;
import java.util.*;
public class recover_bst {
    private static Node root;
    public static Node buildtree(String input){
        String[] in = input.split(" ");
        if (in[0].equals("N") || in.length == 0){
            return null;
        }
        Queue<Node> queue = new LinkedList<>();
        Node root = new Node(Integer.parseInt(in[0]));
        queue.add(root);
        int i = 1;
        while(!queue.isEmpty() && i < in.length){
            Node node = queue.poll();
            if (!in[i].equals("N")){
                node.left = new Node(Integer.parseInt(in[i]));
                queue.add(node.left);
            }
            i++;
            if (i >= in.length) break;
            if (!in[i].equals("N")){
                node.right = new Node(Integer.parseInt(in[i]));
                queue.add(node.right);

            }
            i++;
        }
        return root;
    }
    public static void inorder(Node node, List<Integer> lst){
        if (node == null) return;
        inorder(node.left, lst);
        lst.add(node.data);
        inorder(node.right, lst);
    }
    public static void recover(Node node, List<Integer> lst, int[] index){
        if (node == null) return;
        recover(node.left, lst, index);
        node.data = lst.get(index[0]);
        index[0]++;
        recover(node.right, lst, index);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        Node root = buildtree(input);

        List<Integer> inorderlst = new ArrayList<>();
        inorder(root, inorderlst);
        System.out.println(inorderlst);
        inorderlst.sort(null);

        //swapping incorrect nodes -
        recover(root, inorderlst, new int[]{0});
        List<Integer> answer = new ArrayList<>();
        inorder(root, answer);
        System.out.println(answer);
    }
}
