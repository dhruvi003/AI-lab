import java.util.*;

public class TspUsingBfs {

    static int implementBFS(int[][] distances, String startPos) {
        Queue<String[]> cities = new LinkedList<>();
        cities.add(new String[]{startPos});

        int optimalDistance = -1; 
        String[] optimalRoute = null;

        while (!cities.isEmpty()) {
            String[] currentRoute = cities.remove();

            if (currentRoute.length == distances.length + 1 && currentRoute[currentRoute.length - 1].equals(startPos)) {
                int currentDistance = calculateTotalDistance(currentRoute, distances);
                if (optimalRoute == null || currentDistance < optimalDistance) {
                    optimalDistance = currentDistance;
                    optimalRoute = currentRoute;
                }
            } else {
                for (int i = 0; i < distances.length; i++) {
                    if (!Arrays.asList(currentRoute).contains(String.valueOf(i))) {
                        String[] extendedRoute = Arrays.copyOf(currentRoute, currentRoute.length + 1);
                        extendedRoute[currentRoute.length] = String.valueOf(i);
                        cities.add(extendedRoute);
                    }
                }
            }
        }

        
        if (optimalRoute != null) {
            System.out.println("Optimal Route: " + Arrays.toString(optimalRoute));
        } else {
            System.out.println("No valid route found.");
        }

        return optimalDistance;
    }

    
    static int calculateTotalDistance(String[] route, int[][] distances) {
        int totalDistance = 0;
        for (int i = 0; i < route.length - 1; i++) {
            int from = Integer.parseInt(route[i]);
            int to = Integer.parseInt(route[i + 1]);
            totalDistance += distances[from][to];
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

        String startCity = "0";

        int optimalDistance = implementBFS(distances, startCity);

        System.out.println("Optimal Distance: " + (optimalDistance >= 0 ? optimalDistance : "No valid route found."));
    }
}
