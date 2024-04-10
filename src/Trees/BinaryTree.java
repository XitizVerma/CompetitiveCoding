package Trees;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

class Node{
    int value;
    Node left,right;

    public Node(){
        left=right=null;
    }
    Node(int value){
        this.value=value;
        left=right=null;
    }

    Node(int val, Node right, Node left){
        this.value = val;
        this.right = right;
        this.left = left;
    }
}

public class BinaryTree {

    static Node root;
    public BinaryTree(){
        root=null;
    }

    public static void main(String[] args){

//        root = insertNode(root,5);
//        root = insertNode(root,1);
//        root = insertNode(root,2);
//        root = insertNode(root,3);
//        root = insertNode(root,4);
//        root = insertNode(root,6);
//
//        System.out.println("DFS");
//        dfsPreorder(root);
//
//        System.out.println("BFS");
//        bfs(root);

        List<Integer> arr = Arrays.asList(5,4,2,3,3,7);
//        for(Integer i : arr){
//            TreeNode treeNode = new TreeNode();
//        }
        isEvenOddTree();
    }

    private static Node insertNode(Node node,int i) {
        if(node==null)
            return new Node(i);
        if(i<node.value)
            node.left = insertNode(node.left,i);
        else
            node.right = insertNode(node.right,i);
        return node;
    }

    private static void dfsPreorder(Node root) {
        if(root==null)
            return;
        System.out.println(root.value);
        dfsPreorder(root.left);
        dfsPreorder(root.right);

    }

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

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(Objects.isNull(p) && Objects.isNull(q))
            return true;
        if(Objects.isNull(p) || Objects.isNull(q))
            return false;
        if(p.val!=q.val)
            return false;
        return isSameTree(p.left,q.left) && isSameTree(p.right,q.right);
    }

    int maxi=0;
    public int diameterOfBinaryTree(TreeNode root) {
        if(root==null)
            return 0;
        int leftWing = diameterOfBinaryTree(root.left);
        int rightWing = diameterOfBinaryTree(root.right);
        maxi = Math.max(maxi,leftWing+rightWing+1);//Ultimately maxi is the true max Diameter.Hence return maxi from main function
        return Math.max(leftWing,rightWing)+1;
    }

    public int findBottomLeftValue(TreeNode root) {
        //              1
        //          2       3
        //      4      5  6     7
        int bottomLeftValue=0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            int n = queue.size();
            for(int i=0;i<n;i++){
                TreeNode node = queue.poll();
                if(i==0)
                    bottomLeftValue=node.val;
                if(Objects.nonNull(node.left))
                    queue.add(node.left);
                if(Objects.nonNull(node.right))
                    queue.add(node.right);
            }
        }
        return bottomLeftValue;
    }

    public static boolean isEvenOddTree() {
//        TreeNode root = new TreeNode(1,
//                new TreeNode(10, new TreeNode(3,new TreeNode(12),new TreeNode(8)),null),
//                new TreeNode(4, new TreeNode(7, new TreeNode(6),null), new TreeNode(9 , null, new TreeNode(6))));
        TreeNode root = new TreeNode(5, new TreeNode(4 , new TreeNode(3), new TreeNode(3)), new TreeNode(2, new TreeNode(7),null));
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        int level=0;
        boolean flag = true;
        while(!queue.isEmpty()){
            if(flag==false)
                break;
            int n = queue.size();
            AtomicInteger temp = new AtomicInteger();
            if(level%2==0){
                temp.set(0);
            }else{
                temp.set(10000000);
            }
            for(int i=0;i<n;i++){
                TreeNode node = queue.remove();
                if(checkConditions(node.val,level%2,temp)){
                    flag=false;
                    break;
                }
                if(node.left!=null)
                    queue.add(node.left);
                if(node.right!=null)
                    queue.add(node.right);
            }
            level++;
        }
        return flag;
    }

    private static boolean checkConditions(int nodeVal, int level,AtomicInteger temp) {
        if(nodeVal%2==level)
            return true;
        if(level==0){
            if(!(temp.get()<nodeVal))
                return true;
        }else {
            if (!(temp.get()>nodeVal))
                return true;
        }
        temp.set(nodeVal);
        return false;
    }

}


