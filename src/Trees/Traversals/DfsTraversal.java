package Trees.Traversals;

import Trees.Node;

public class DfsTraversal {

    private static void dfsPreorder(Node root) {
        if(root==null)
            return;
        System.out.println(root.value);
        dfsPreorder(root.left);
        dfsPreorder(root.right);

    }

}
