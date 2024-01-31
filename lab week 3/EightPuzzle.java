import java.util.*;

class Node {

    int[][] puzzle;
    int x, y, cost, level;
    Node parent;

    // initialized the values
    public Node(int[][] puzzle, int x, int y, int newX, int newY, int level, Node parent) {
        this.puzzle = new int[3][3];
        this.level = level;
        this.parent = parent;
        this.x = newX;
        this.y = newY;
        this.cost = Integer.MAX_VALUE;

        // Copy puzzle state
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                // assign values 
                this.puzzle[i][j] = puzzle[i][j];
            }
        }

        // swapping the value of old node with the new values
        int temp = this.puzzle[x][y];
        this.puzzle[x][y] = this.puzzle[newX][newY];
        this.puzzle[newX][newY] = temp;
    }
}

public class EightPuzzle {
    //creating the first node
    static Node root;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //initialise goal and start position by 2d array
        System.out.println("Enter initial state of puzzle:");
        int[][] initial = new int[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                initial[i][j] = scanner.nextInt();
            }
        }
        // int[][] initial = {{1,2,3},{5,6,0},{7,8,4}};


        // Get goal state
        System.out.println("Enter goal state of puzzle:");
        int[][] goal = new int[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                goal[i][j] = scanner.nextInt();
            }
        }
        // int[][] goal = {{1,2,3},{5,8,6},{0,7,4}};  // here 0 shows blank space


        // Get coordinates of the blank tile
        System.out.println("Enter the x and y coordinates of the blank tile (0):");
        int x = scanner.nextInt();
        int y = scanner.nextInt();

        root = new Node(initial, x, y, x, y, 0, null);
        AStarSearch(root, goal);
    }

    // A* Search Algorithm
    public static void AStarSearch(Node root, int[][] goal) {
        //we need two list : OPEN and CLOSE
        // OPEN --> Store nodes that are yet to be explored
        // CLOSE --> store nodes that have been explored

        // first adding root node to open list
        PriorityQueue<Node> openList = new PriorityQueue<>(Comparator.comparingInt(node -> node.cost));
        openList.add(root);

        while (!openList.isEmpty()) {
            Node node = openList.poll();

            // Goal Test
            if (Arrays.deepEquals(node.puzzle, goal)) {
                printPath(node);
                return;
            }

            // Generate all possible 
            for (int[] direction : new int[][]{{1, 0}, {-1, 0}, {0, -1}, {0, 1}}) {
                int newX = node.x + direction[0];
                int newY = node.y + direction[1];

                if (isValid(newX, newY)) {
                    Node child = new Node(node.puzzle, node.x, node.y, newX, newY, node.level + 1, node);
                    child.cost = calculateCost(child, goal);
                    openList.add(child);
                }
            }
        }
    }

    // Check if the new coordinates are valid
    public static boolean isValid(int x, int y) {
        return (x >= 0 && x < 3 && y >= 0 && y < 3);
    }

    // Calculate cost of a node
    public static int calculateCost(Node node, int[][] goal) {
        int misplacedTiles = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (node.puzzle[i][j] != 0 && node.puzzle[i][j] != goal[i][j]) {
                    misplacedTiles++;
                }
            }
        }
        return misplacedTiles + node.level;
    }

    // Print the path from root to goal
    public static void printPath(Node node) {
        if (node == null) {
            return;
        }
        printPath(node.parent);
        printPuzzle(node.puzzle);
        System.out.println();
    }

    // Print the state of the puzzle
    public static void printPuzzle(int[][] puzzle) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(puzzle[i][j] + " ");
            }
            System.out.println();
        }
    }
}