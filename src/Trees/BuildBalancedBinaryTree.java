package Trees;

import java.util.ArrayList;
import java.util.List;

public class BuildBalancedBinaryTree {


    public TreeNode balanceBST(TreeNode root) {
        List<Integer> sortedArray = new ArrayList<>();
        inorderTraversal(root, sortedArray);
        return buildBalancedBinaryTree(sortedArray, 0, sortedArray.size() - 1);
    }

    private void inorderTraversal(TreeNode root, List<Integer> sortedArray) {
        if (root == null)
            return;
        inorderTraversal(root.left, sortedArray);
        sortedArray.add(root.val);
        inorderTraversal(root.right, sortedArray);
    }

    private TreeNode buildBalancedBinaryTree(List<Integer> sortedArray, int start, int end) {
        if(start>end)
            return null;
        int mid = start + (end - start) / 2;
        TreeNode root = new TreeNode(sortedArray.get(mid));
        root.left = buildBalancedBinaryTree(sortedArray, start, mid - 1);
        root.right = buildBalancedBinaryTree(sortedArray, mid + 1, end);
        return root;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

}



