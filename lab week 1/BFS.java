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
        
        int head = 0, tail = 0;

        visited[startpoint] = true;
        queue[tail++] = startpoint;

        while(head != tail){
            int currentVertex = queue[head++];
            System.out.print(currentVertex + " ");

            for(int i =0; i< V; i++){
                if(graph[currentVertex][i] == 1 && !visited[i]){
                    visited[i] = true;
                    queue[tail++] = i;
                }
            }
        }

    }
}

public class BFS{
    public static void main(String[] args) {
        
        Graph g1 = new Graph(4);

        g1.makeEdge(0,1);
        g1.makeEdge(1,2);
        g1.makeEdge(1,3);
        System.out.println("Breadth First Traversal of given graph");
        g1.implementBFS(0);
        
    }
}