package Trees;


import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class LeafSimilarTrees {

    public static boolean main(String[] args){
        Node node = new Node(5);
        List<Integer> arr1 = new ArrayList<>(), arr2 = new ArrayList<>();
        leafSequence(arr1,node);
        leafSequence(arr2,node);
        if(arr1.size()!=arr2.size())
            return false;
        for(int i=0;i<arr1.size();i++)
            if(!Objects.equals(arr1.get(i), arr2.get(i)))
                return false;
        return true;
    }

    public static void leafSequence(List<Integer> arr, Node node) {
        if(node==null)
            return;
        leafSequence(arr,node.left);
        leafSequence(arr,node.right);
        if(node.left==null && node.right==null)
            arr.add(node.value);
    }
}
