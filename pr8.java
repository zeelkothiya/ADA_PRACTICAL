//AIM
/* To solve the Minimum Spanning Tree (MST) problem using Kruskal's Algorithm by applying the Greedy Strategy. */

import java.util.*;
public class pr8 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of vertices: ");
        int num = sc.nextInt();

        int matrix[][] = new int[num][num];
        int parent[] = new int[num];
        System.out.println("Enter adjacency matrix (use 0 for no edge):");
        for (int i = 0; i < num; i++) {
            parent[i] = i;
            for (int j = 0; j < num; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }

        int count = 0;
        int total = 0;

        System.out.println("\nEdges in Minimum Spanning Tree:");
        while (count < num - 1) {
            int min = Integer.MAX_VALUE;
            int u = -1, v = -1;

            for (int i = 0; i < num; i++) {
                for (int j = 0; j < num; j++) {
                    if (matrix[i][j] != 0 && matrix[i][j] < min) {
                        min = matrix[i][j];
                        u = i;
                        v = j;
                    }
                }
            }

            int ucomp = parent[u];
            int vcomp = parent[v];
            if (ucomp != vcomp) {
                System.out.println("Edge: " + u + " -> " + v + " | Weight: " + min);
                total += min;
                count++;
                for (int i = 0; i < num; i++) {
                    if (parent[i] == vcomp) {
                        parent[i] = ucomp;
                    }
                }
            }
            matrix[u][v] = matrix[v][u] = Integer.MAX_VALUE;
        }
        System.out.println("\nTotal cost of Minimum Spanning Tree: " + total);
    }
}

/*Enter number of vertices: 6
Enter adjacency matrix (use 0 for no edge):
0 6 1 5 0 0
6 0 5 0 3 0
1 5 0 5 6 4
5 0 5 0 0 3
0 3 6 0 0 6
0 0 4 3 6 0

Edges in Minimum Spanning Tree:
Edge: 0 -> 2 | Weight: 1
Edge: 1 -> 4 | Weight: 3
Edge: 3 -> 5 | Weight: 3
Edge: 2 -> 5 | Weight: 4
Edge: 1 -> 2 | Weight: 5

Total cost of Minimum Spanning Tree: 16 */