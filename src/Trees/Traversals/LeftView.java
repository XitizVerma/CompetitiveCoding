package Trees.Traversals;

import Trees.Node;

import java.util.LinkedList;
import java.util.Queue;

import static Trees.BinaryTree.getBinaryTree;

public class LeftView {

    public static void main(String[] args) {
        Node root = getBinaryTree();
        rightView(root);
    }

    private static void rightView(Node root) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            int n = queue.size();
            for (int i = 0; i < n; i++) {
                Node node = queue.poll();
                if(node.left!=null)
                    queue.add(node.left);
                if(node.right!=null)
                    queue.add(node.right);
                if(i==0)
                    System.out.println(node.value);
            }
        }
    }


}
