import java.util.Arrays;
import java.util.PriorityQueue;

// import org.w3c.dom.Node;

public class EightPuzzle {
    
    //creating the first node
    static Node root;

    public static void main(String[] args) {
        //initialise goal and start position by 2d array
        int[][] initial = {{1,2,3},{5,6,0},{7,8,4}};

        int[][] goal = {{1,2,3},{5,8,6},{0,7,4}};  // here 0 shows blank space

        int x = 1 , y = 2; // x and y are coordinates of blank space for starting node
        root = new Node(initial, x, y, x, 0, null, y);
        StarSearch(root, goal);

    }

    public static void StarSearch(Node root, int[][] goal){
        //we need two list : OPEN and CLOSE
        // OPEN --> Store nodes that are yet to be explored
        // CLOSE --> store nodes that have been explored

        // first adding root node to open list
        PriorityQueue<Node> OPEN = new PriorityQueue<>();
        OPEN.add(root);

        // we traverse the until the open list is not empty, that means each and every node is explored
        while(!OPEN.isEmpty()){
            // creating a new node for each low value in open list
            Node node = OPEN.poll();

            //if current node is goal node
            if(Arrays.deepEquals(node.puzzle, goal)){
                printPath(node);
                return;
            }

            //else we will generate all the steps
            for(int[] direction : new int[][]{{1,0},{-1,0},{0,1},{0,-1}}){
                int newX = node.x + direction[0];
                int newY = node.y + direction[1];

                if(isValid(newX, newY)){
                    Node child = new Node(node.puzzle, node.x, node.y, newX, node.level+1, node, newY);
                    child.cost = calculateCost(child, goal);
                    OPEN.add(child);
                }
            }

        }
    }

    public static int calculateCost(Node child, int[][] goal) {
        int misplacedTiles = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (child.puzzle[i][j] != 0 && child.puzzle[i][j] != goal[i][j]) {
                    misplacedTiles++;
                }
            }
        }
        return misplacedTiles + child.level;
    }



    public static boolean isValid(int newX, int newY) {
       if(newX >= 0 && newX < 3 && newY >=0 && newY <3){
        return true;
       }
       return false;
    }

    public static void printPath(Node node) {
        
        if(node == null){
            return;
        }
        printPath(node.parent);
        printPuzzle(node.puzzle);
        System.out.println();
    }

    public static void printPuzzle(int[][] puzzle){
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(puzzle[i][j] + " ");
            }
            System.out.println();
        }
    }



}

class Node {
    int[][] puzzle;
    int x,y, cost, level;
    Node parent;

    public Node(int[][] puzzle, int x, int y, int newX,int level,Node parent, int newY){
        // initialized the values
        this.puzzle = new int[3][3];
        this.x = newX;
        this.y = newY;
        this.cost = Integer.MAX_VALUE;
        this.level = level;
        this.parent = parent;
    

    for(int i =0; i< 3; i++){
        for(int j = 0; j<3; j++){
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

