package Trees.Traversals;

import Trees.Node;

import java.util.*;

import static Trees.BinaryTree.getBinaryTree;

public class VerticalOrderTraversal {

    public static void main(String[] args) {
        List<List<Integer>> ans = verticalOrderTraversal(getBinaryTree());
    }

    public static List<List<Integer>> verticalOrderTraversal(Node root){
        if(root==null)
            return new ArrayList<>();
        TreeMap<Integer,TreeMap<Integer,PriorityQueue<Integer>>> nodeVerticalLevel = new TreeMap<>();
        Queue<Tuple> queue = new LinkedList<>();
        queue.add(new Tuple(root,0,0));
        while(!queue.isEmpty()){
            int n = queue.size();
            for (int i = 0; i < n; i++) {
                Tuple tuple = queue.poll();
                Node node = tuple.node;
                int x = tuple.x;
                int y = tuple.y;

                if(!nodeVerticalLevel.containsKey(x))
                    nodeVerticalLevel.put(x,new TreeMap<>());
                if(!nodeVerticalLevel.get(x).containsKey(y))
                    nodeVerticalLevel.get(x).put(y,new PriorityQueue<>());

                nodeVerticalLevel.get(x).get(y).add(node.value);

                if(Objects.nonNull(node.left))
                    queue.add(new Tuple(node.left,x-1,y+1));
                if(Objects.nonNull(node.right))
                    queue.add(new Tuple(node.right,x+1,y+1));
            }
        }
        List<List<Integer>> ans = new ArrayList<>();
        for(Map.Entry<Integer,TreeMap<Integer,PriorityQueue<Integer>>> xEntry : nodeVerticalLevel.entrySet()){
            ans.add(new ArrayList<>());
            for(PriorityQueue<Integer> pq : xEntry.getValue().values()){
                while(!pq.isEmpty())
                    ans.get(ans.size()-1).add(pq.poll());
            }
        }
        return ans;
    }

    static class Tuple{
        Node node;
        int x;
        int y;

        Tuple(Node node,int x, int y){
            this.node=node;
            this.x=x;
            this.y=y;
        }
    }
}
