import java.util.Arrays;

public class TspUsingDfs {

    static int implementDFS(int[][] distances, int startCity) {
        int numberOfCities = distances.length;
        boolean[] visited = new boolean[numberOfCities];
        int[] currentRoute = new int[numberOfCities + 1]; // +1 for returning to the starting city
        Arrays.fill(currentRoute, -1); // Initialize with an invalid value
        int[] optimalRoute = new int[numberOfCities + 1]; // +1 for returning to the starting city
        Arrays.fill(optimalRoute, -1); // Initialize with an invalid value

        currentRoute[0] = startCity;
        visited[startCity] = true;

        dfs(distances, visited, currentRoute, 1, optimalRoute);

        // Print the optimal route
        System.out.println("Optimal Route: " + Arrays.toString(Arrays.copyOf(optimalRoute, optimalRoute.length - 1)));

        return calculateTotalDistance(optimalRoute, distances);
    }

    static void dfs(int[][] distances, boolean[] visited, int[] currentRoute, int position, int[] optimalRoute) {
        if (position == currentRoute.length) {
            // Complete route, check if it's better than the current optimal route
            int currentDistance = calculateTotalDistance(currentRoute, distances);
            int optimalDistance = calculateTotalDistance(optimalRoute, distances);

            if (optimalRoute[0] == -1 || currentDistance < optimalDistance) {
                System.arraycopy(currentRoute, 0, optimalRoute, 0, currentRoute.length);
            }
            return;
        }

        for (int nextCity = 0; nextCity < distances.length; nextCity++) {
            if (!visited[nextCity]) {
                currentRoute[position] = nextCity;
                visited[nextCity] = true;
                dfs(distances, visited, currentRoute, position + 1, optimalRoute);
                visited[nextCity] = false; // Backtrack
            }
        }
    }

    static int calculateTotalDistance(int[] route, int[][] distances) {
        int totalDistance = 0;
        for (int i = 0; i < route.length - 1; i++) {
            totalDistance += distances[route[i]][route[i + 1]];
        }
        return totalDistance;
    }

    public static void main(String[] args) {
        int[][] distances = {
                {0, 10, 15, 20},
                {10, 0, 35, 25},
                {15, 35, 0, 30},
                {20, 25, 30, 0}
        };

        int startCity = 0;

        int optimalDistance = implementDFS(distances, startCity);

        System.out.println("Optimal Distance: " + optimalDistance);
    }
}
