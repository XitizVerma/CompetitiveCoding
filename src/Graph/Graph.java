package Graph;

import java.util.*;

public class Graph {

    static List<List<Integer>> adjacencyList;

    Graph(int vertices){
        adjacencyList = new ArrayList<>(vertices);
        for(int i=0;i<vertices;i++)
            adjacencyList.add(new ArrayList<>());

    }
    public static void main(String[] args){
        int n=5;
        int[][] edges = {{1,2},{1,3},{2,4},{3,5},{4,5}};

        Graph graph = new Graph(6);
        insertEdgesIntoGraph(edges);

        displayGraph(adjacencyList);

        System.out.println("DFS");
        List<Boolean> visited=new ArrayList<>();
        for(int i=0;i<=adjacencyList.size();i++)
            visited.add(false);
        for(int i=1;i<adjacencyList.size();i++)
            dfs(i,visited);

        System.out.println("BFS");
        bfs(1);

    }

    private static void insertEdgesIntoGraph(int[][] edges) {
        for(int i=0;i<edges.length;i++){
            int u=edges[i][0];
            int v=edges[i][1];
            adjacencyList.get(u).add(v);
            adjacencyList.get(v).add(u);
        }
    }

    private static void displayGraph(List<List<Integer>> adjacencyList) {
        int i=0;
        for(List<Integer> vertex : adjacencyList) {
            System.out.print("Vertex " + i++ + " : ");
            for (Integer j : vertex){
                System.out.print(j + " , ");
            }
            System.out.println();
        }
    }

    private static void dfs(int root,List<Boolean> visited){
        if(visited.get(root))
            return;
        visited.set(root,true);
        System.out.println(root);
        for(Integer j :adjacencyList.get(root)){
            dfs(j,visited);
        }
    }

    public static void bfs(int root){
        boolean[] visited = new boolean[adjacencyList.size()+1];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            int node = queue.remove();
            System.out.println(node);
            visited[node]=true;
            for(Integer i:adjacencyList.get(node)){
                if(visited[i]==false)
                    queue.add(i);
            }
        }
    }
}
