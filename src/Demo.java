import java.util.*;

public class Demo {
    public static void main (){


    }

    public static class Pair {
        int key,value;
        Pair(int key, int value){
            this.key = key;
            this.value = value;
        }
    }
    public static void demoPair(){
        Pair pair = new Pair(1,2);
        System.out.println(pair.key + " " + pair.value);
    }

    public static void demoQueue() {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        queue.poll();
    }

    public static void demoStack() {
        Stack<Integer> stack = new Stack<>();
        stack.add(1);
        stack.pop();
    }

    public static void priorityQueue() {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        priorityQueue.add(1);
        priorityQueue.peek();
    }

    public static void sort() {
        int[] arr = {1,2,3};
        Arrays.sort(arr);
    }

    static List<List<Integer>> adjacencyList;
    public static void createGraph() {
        int[][] edges = {{1,2},{2,3},{3,4},{3,1}};
        adjacencyList = new ArrayList<>();
        for(int i =0;i<5;i++)
            adjacencyList.add(new ArrayList<>());

        for(int[] edge : edges){
            adjacencyList.get(edge[0]).add(edge[1]);
            adjacencyList.get(edge[1]).add(edge[0]);
        }
    }

    public static void dfs(int node, List<Boolean> visited) {
        if(visited.get(node))
            return;
        System.out.println(node);
        visited.add(node,true);
        for(Integer i : adjacencyList.get(node)) {
            dfs(i,visited);
        }
    }

    public void backtracking(int[] nums, List<Integer> ds, boolean[] visited, List<List<Integer>> ans){
        if(ds.size() == nums.length){
            ans.add(ds);
            return;
        }
        for(int i=0;i<nums.length;i++){
            if(!visited[i]){
                ds.add(nums[i]);
                visited[i]=true;
                backtracking(nums,ds,visited,ans);
                visited[i]=false;
                ds.removeLast();
            }
        }
    }

}


