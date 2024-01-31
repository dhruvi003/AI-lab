class TSP {
    private int V;
    private int[][] graph;
    private boolean[] visited;
    private int minCost = Integer.MAX_VALUE;

    public TSP(int v) {
        V = v;
        graph = new int[v][v];
        visited = new boolean[v];
    }

    public void addEdge(int start, int end, int cost) {
        graph[start][end] = cost;
        graph[end][start] = cost; // Assuming an undirected graph
    }

    public void tspDFS(int pos, int count, int cost, int start) {
        visited[pos] = true;

        if (count == V && graph[pos][start] != 0) {
            minCost = Math.min(minCost, cost + graph[pos][start]);
        }

        for (int city = 0; city < V; city++) {
            if (!visited[city] && graph[pos][city] != 0) {
                tspDFS(city, count + 1, cost + graph[pos][city], start);
            }
        }

        visited[pos] = false;
    }

    public int solveTSP() {
        for (int i = 0; i < V; i++) {
            tspDFS(i, 1, 0, i);
        }

        return minCost;
    }
}

public class TSPExample {
    public static void main(String[] args) {
        TSP tsp = new TSP(4);
        tsp.addEdge(0, 1, 22);
        tsp.addEdge(0, 2, 48);
        tsp.addEdge(0, 3, 28);
        tsp.addEdge(1, 2, 20);
        tsp.addEdge(1, 3, 18);
        tsp.addEdge(2, 3, 32);

        int result = tsp.solveTSP();
        System.out.println("Minimum cost for TSP: " + result);
    }
}
