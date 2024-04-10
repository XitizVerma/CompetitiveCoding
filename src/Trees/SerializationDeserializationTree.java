package Trees;

import java.util.Objects;

public class SerializationDeserializationTree {

    public static void main(String[] args){

    }
    public String serialize(TreeNode root) {
        StringBuilder stringBuilder = new StringBuilder();
//        bfs(root,stringBuilder);
        return stringBuilder.toString();
    }

    private void dfsInorder(TreeNode root, StringBuilder stringBuilder) {
        if(Objects.isNull(root))
            return;
        dfsInorder(root.left,stringBuilder);
        stringBuilder.append(root.val);
        dfsInorder(root.right,stringBuilder);
    }

    // Decodes your encoded data to tree.
    public void deserialize(String data) {
//        for()

    }
}
class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) {
          this.val = x;
      }
      TreeNode(int val, TreeNode left, TreeNode right){
          this.val = val;
          this.left = left;
          this.right = right;
      }

  }
