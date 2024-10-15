package Trees.Traversals;

import Trees.Node;

import java.util.LinkedList;
import java.util.Queue;

public class BfsTraversal {

    private static void bfs(Node root) {
        if(root==null)
            return;
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            Node current = queue.remove();
            System.out.println(current.value);
            if(current.left!=null)
                queue.add(current.left);
            if(current.right!=null)
                queue.add(current.right);
        }
    }

}
