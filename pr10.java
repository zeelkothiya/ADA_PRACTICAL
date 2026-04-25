//AIM
/* Solve 0/1 Knapsack Problem Using Dynamic Programming. */

import java.util.*;
public class pr10 {

    static int max(int a, int b) {
        return (a > b) ? a : b;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n, W;

        System.out.print("Enter number of items: ");
        n = sc.nextInt();

        int[] wt = new int[n];
        int[] val = new int[n];
        System.out.print("Enter weights of items: ");
        for (int i = 0; i < n; i++) {
            wt[i] = sc.nextInt();
        }

        System.out.println("Enter values of items: ");
        for (int j = 0; j < n; j++) {
            val[j] = sc.nextInt();
        }

        System.out.print("Enter capacity of Knapsack: ");
      W = sc.nextInt();

        int[][] V = new int[n + 1][W + 1];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= W; j++) {

                    if (i == 0 || j == 0) {
                    V[i][j] = 0;
                } 
                else if (wt[i - 1] <= j) {
                    V[i][j] = max(V[i - 1][j], V[i - 1][j - wt[i - 1]] + val[i - 1]);
                } 
                else {
                    V[i][j] = V[i - 1][j];
                }
            }
        }
        System.out.println("\nDP Matrix:");
        System.out.print("     ");
        for (int j = 0; j <= W; j++) {
            System.out.print(j + "\t");
        }
        System.out.println();

        for (int i = 0; i <= n; i++) {
            System.out.print("i=" + i + " |");
            for (int j = 0; j <= W; j++) {
                System.out.print(V[i][j] + "\t");
            }
            System.out.println();
        }
        System.out.println("\nMaximum Profit in Knapsack = " + V[n][W]);
    }
}

/*Enter number of items: 4
Enter weights of items:
2
1
3
2
Enter values of items:
12
10
20
15
Enter capacity of Knapsack: 5

DP Matrix:
     0  1       2       3       4       5
i=0 |0  0       0       0       0       0
i=1 |0  0       12      12      12      12
i=2 |0  10      12      22      22      22
i=3 |0  10      12      22      30      32
i=4 |0  10      15      25      30      37

Maximum Profit in Knapsack = 37 */