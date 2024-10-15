package Trees;

public class Node{
    public int value;
    public Node left,right;

    public Node(){
        left=right=null;
    }
    public Node(int value){
        this.value=value;
        left=right=null;
    }

    public Node(int val, Node left, Node right){
        this.value = val;
        this.right = right;
        this.left = left;
    }
}
