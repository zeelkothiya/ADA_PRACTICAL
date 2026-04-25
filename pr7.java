//AIM
/* To implement Minimum Spanning Tree (MST) generation using Prim's Algorithm based on the Greedy Strategy. */

import java.util.*;
public class pr7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of vertices: ");
        int num = sc.nextInt();

        int matrix[][] = new int[num][num];
        int visited[] = new int[num];

        System.out.println("Enter adjacency matrix (use 0 for no edge):");
        for (int i = 0; i < num; i++) {
            for (int j = 0; j < num; j++) {
                matrix[i][j] = sc.nextInt();
                visited[i] = 0;
            }
        }

        visited[0] = 1;
        int count = 0, total = 0;
        System.out.println("\nEdges in Minimum Spanning Tree:");

        while (count < num - 1) {
            int min = Integer.MAX_VALUE;
            int u = -1, v = -1;

            for (int i = 0; i < num; i++) {
                if (visited[i] == 1) {
                    for (int j = 0; j < num; j++) {
                        if (visited[j] == 0 && matrix[i][j] != 0 && matrix[i][j] < min) {
                            min = matrix[i][j];
                            u = i;
                            v = j;
                        }
                    }
                }
            }
            if (u != -1 && v != -1) {
                System.out.println("Edge: " + u + " -> " + v + " | Weight: " + min);
                total += min;
                visited[v] = 1;
                count++;
            }
        }
        System.out.println("\nTotal cost of Minimum Spanning Tree: " + total);
    }
}

/*
Enter number of vertices: 7
Enter adjacency matrix (use 0 for no edge):
0 1 0 4 0 0 0
1 0 2 6 4 0 0
0 2 0 0 5 6 0
4 6 0 0 3 0 4
0 4 5 3 0 8 7
0 0 6 0 8 0 3
0 0 0 4 7 3 0

Edges in Minimum Spanning Tree:
Edge: 0 -> 1 | Weight: 1
Edge: 1 -> 2 | Weight: 2
Edge: 0 -> 3 | Weight: 4
Edge: 3 -> 4 | Weight: 3
Edge: 3 -> 6 | Weight: 4
Edge: 6 -> 5 | Weight: 3

Total cost of Minimum Spanning Tree: 17 */