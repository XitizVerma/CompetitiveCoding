package Trees;

import java.util.ArrayList;
import java.util.List;

class NnaryTreeNode {
    int value;
    List<NnaryTreeNode> children = new ArrayList<>();

    NnaryTreeNode(int value){
        this.value=value;

    }

}
public class N_NaryTree {
    static NnaryTreeNode root;
    //Also known as K-Nary Tree
    public static void main(String[] args){

        root = insertNode(root,1);
        insertNode(root,2);
        insertNode(root,3);

        dfs(root);
    }

    private static NnaryTreeNode insertNode(NnaryTreeNode node, int i){
        if(node==null){
            return new NnaryTreeNode(i);
        }
        node.children.add(new NnaryTreeNode(i));
        return node;
    }

    private static void dfs(NnaryTreeNode node) {
        if(node==null)
            return;
        System.out.println(node.value);
        for(NnaryTreeNode treeNode:node.children){
            dfs(treeNode);
        }
    }
}
