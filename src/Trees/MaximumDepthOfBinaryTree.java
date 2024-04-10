package Trees;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Math.max;

public class MaximumDepthOfBinaryTree {
    
    public static void main(String []args){
        TreeNode root = new TreeNode(5);
    }

    
      public static class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
          TreeNode() {}
          TreeNode(int val) { this.val = val; }
          TreeNode(int val, TreeNode left, TreeNode right) {
              this.val = val;
              this.left = left;
              this.right = right;
          }
      }
     
    class Solution {
        public int maxDepth(TreeNode root) {
            if(root.equals(null))
                return 0;
            int right = maxDepth(root.right);
            int left = maxDepth(root.left);
            return max(right,left) + 1;
        }
    }

    public String tree2str(TreeNode root) {
        StringBuilder str = new StringBuilder();
        dfs(str,root);
        return str.toString();
    }
//    Input: root = [1,2,3,null,4]
//    Output: "1(2()(4))(3)"
    public void dfs(StringBuilder str, TreeNode root){
        if(root==null)
            return;
        str.append(root.val);
        if(root.left==null && root.right==null)
            return;
        str.append("(");
        dfs(str,root.left);
        str.append(")");
        str.append("(");
        dfs(str,root.right);
        str.append(")");
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        dfs(root,ans);
        return ans;
    }

    public void dfs(TreeNode root, List<Integer> ans){
        if(root==null)
            return;
        dfs(root.left,ans);
        ans.add(root.val);
        dfs(root.right,ans);
    }
}
