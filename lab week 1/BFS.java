class Graph{
    private int V;
    private int[][] graph;

    public Graph(int v){
        V = v;
        graph = new int[v][v];
    }

    public void makeEdge(int start, int end){
        graph[start][end] = 1;
    }

    public void implementBFS(int startpoint){
        boolean[] visited = new boolean[V];
        int[] queue = new int[V];
        
    }
}

public class BFS{
    public static void main(String[] args) {
        
    }
}