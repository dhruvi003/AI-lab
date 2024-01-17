class graph{
    private int V;
    private int[][] graph;

    public void graph(int v){
        V = v;
        graph = new int[v][v];
    }

    public void makeEdge(int start, int end, int cost){
        graph[start][end] = cost;
    }

    public void implementDFS(int startpoint){
        boolean[] visited = new boolean[V];
        int[] stack = new int[V];
        

        int top = -1;

        stack[++top] = startpoint;
        visited[startpoint] = true;

        while(top != -1){
            int currentVertex = stack[--top];
            System.out.println(currentVertex + " ");

            for(int i=0; i< V; i++){
                if(graph[currentVertex][i] == 1 && !visited[i]){
                    stack[++top] = i;
                    visited[i] = true;
                }
            }
        }

        
    }

}

public class DFS {
    public static void main(String[] args) {
        Graph g = new Graph(6);
        g.makeEdge(0, 2);
        g.makeEdge(0, 1);
        g.makeEdge(1, 3);
        g.makeEdge(2, 4);
        g.makeEdge(3, 5);

        g.implementBFS(0);

    }
}
