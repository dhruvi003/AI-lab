## Lab week 1

WAP to implement DFS and BFS for traversing a graph from source node (S) to goal node (G), where source node and goal node is given by the user as an input.

**Answer:**
Breadth-First Search (BFS):
BFS is a graph traversal algorithm that explores all the nodes at the current depth level before moving on to the nodes at the next depth level. It starts at the root node and systematically explores each level of the graph outward from the starting point. BFS uses a queue data structure to keep track of the nodes to be explored. This algorithm is often used to find the shortest path between two nodes in an unweighted graph.

Depth-First Search (DFS):
DFS is a graph traversal algorithm that explores as far as possible along each branch before backtracking. It starts at the root node and explores as deeply as possible along each branch before backtracking to explore other branches. DFS can be implemented using recursion or a stack data structure. This algorithm is often used for topological sorting, cycle detection, and solving puzzles such as mazes.

## Lab week 2 

You are given two jugs with m liters and a n liter capacity. Both the jugs are initially empty. The jugs don’t have markings to allow measuring smaller quantities. You have to use the jugs to measure d liters of water where d is less than n

**Approach:**

Initial State: At the beginning, both jugs are empty.

Goal State: The goal is to measure exactly d liters of water in one of the jugs, where d is less than the capacity of the larger jug.

Operations: You can perform two types of operations

Fill a jug: Fill one of the jugs with water from a water source until it's full.

Pour water: Pour water from one jug into the other until either the jug being poured into is full or the jug being poured from is empty.

Constraints: The capacities of the jugs (m and n) are given, where m is the capacity of the smaller jug and n is the capacity of the larger jug. Both m and n are positive integers, and m is less than n.

Solution: The solution involves finding a sequence of operations (fills and pours) that lead to the desired quantity of water in one of the jugs. This may require a combination of filling, pouring, and emptying the jugs in various ways.

Optimality: There can be multiple solutions to this problem, but the optimal solution is the one that minimizes the number of steps or operations required to reach the goal state.

Constraints Handling: In real-world scenarios, additional constraints might apply, such as the need to minimize water wastage, avoid overflow or spillage, or minimize the number of times water is transferred between jugs.

## Lab week 3 

Solve 8 puzzle problem using A* algorithm where initial state and Goal state will be given by the users.

**Approach:**

Initial State and Goal State: The initial state represents the configuration of the tiles at the beginning of the puzzle, and the goal state represents the desired configuration of the tiles. Both the initial state and the goal state are provided by the user.

Heuristic Function: A* algorithm uses a heuristic function to estimate the cost of reaching the goal state from a given state. For the 8-puzzle problem, a common heuristic function is the Manhattan distance heuristic, which calculates the sum of the distances between each tile's current position and its goal position.

Node Expansion: A* algorithm maintains a priority queue of nodes to be expanded. At each step, it selects the node with the lowest total cost (path cost from the initial state plus the heuristic cost to the goal state) for expansion.

Node Representation: Each node in the search space represents a particular state of the puzzle, including the arrangement of the tiles on the board and the path taken to reach that state.

Transition Operator: A transition operator defines the legal moves that can be made from one state to another. In the 8-puzzle problem, the legal moves involve sliding a tile into the empty space (up, down, left, or right).

Goal Test: A* algorithm checks whether the current state is equal to the goal state. If the current state matches the goal state, the puzzle is considered solved.

Optimality: A* algorithm guarantees optimality under certain conditions, specifically when the heuristic function is admissible (never overestimates the true cost) and consistent (satisfies the triangle inequality).

## Lab week 4:

Implement the Fixed Increment Perceptron Learning algorithm

**Approach:**

The first intercept perceptron implemented in Java is a basic neural network for binary classification tasks. It includes an extra input for an intercept value. Here's a quick overview:

1. **Initialization**: Weights are initialized randomly, including one for the intercept.
   
2. **Training**: Iterate through training data, compute the weighted sum of inputs and weights, apply an activation function (e.g., step function), and adjust weights using the perceptron learning rule.


   
4. **Perceptron Learning Rule**: \( \Delta w_i = \eta \cdot (target - output) \cdot input_i \) where \( \Delta w_i \) is the change in weight for the \(i^{th}\) input, \( \eta \) is the learning rate, \( target \) is the desired output, \( output \) is the predicted output, and \( input_i \) is the \(i^{th}\) input value.
   
5. **Testing**: Once trained, predict outputs for new inputs.
   
6. **Evaluation**: Assess the performance of the perceptron.
