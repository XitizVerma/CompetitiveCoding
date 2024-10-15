package Trees.Traversals;

import Trees.Node;

import java.util.*;

import static Trees.BinaryTree.getBinaryTree;

public class BoundaryTraversal {

    static List<Node> ans = new ArrayList<>();

    public static void main(String[] args) {
        Node root = getBinaryTree();
        BoundaryTraversal.boundaryTraversal(root);
        for(Node node : ans)
            System.out.println(node.value);
    }

    public static void boundaryTraversal(Node root){
        traverseLeftBoundary(root);
        traverseLeafNodes(root);
        traverseRightBoundary(root);
    }


    private static void traverseLeftBoundary(Node root) {
        if(root==null)
            return;
        if(!isLeaf(root))
            ans.add(root);
        if(Objects.nonNull(root.left))
            traverseLeftBoundary(root.left);
        else
            traverseLeftBoundary(root.right);
    }

    private static void traverseLeafNodes(Node root) {
        if(Objects.isNull(root))
            return;
        if(isLeaf(root))
            ans.add(root);
        traverseLeafNodes(root.left);
        traverseLeafNodes(root.right);
    }

    private static void traverseRightBoundary(Node root) {
        if(Objects.isNull(root))
            return;
        Stack<Node> stack = new Stack<>();
        while(Objects.nonNull(root)){
            if(isLeaf(root))
                stack.add(root);
            if(Objects.nonNull(root.right)){
                root=root.right;
            }else {
                root=root.left;
            }
        }
        while(stack.isEmpty())
            ans.add(stack.pop());
    }

    private static boolean isLeaf(Node root) {
        return Objects.isNull(root.left) && Objects.isNull(root.right);
    }
}
