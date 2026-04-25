//AIM
/* Solve Matrix Chain Multiplication Using Dynamic Programming. */

import java.util.Scanner;

public class pr11 {

    static int[][] m;
    static int[][] s;

    public static void matrixChainOrder(int p[], int n) {
        m = new int[n][n];
        s = new int[n][n];

        for (int i = 1; i < n; i++) {
            m[i][i] = 0;
        }

        for (int L = 2; L < n; L++) {
            for (int i = 1; i < n - L + 1; i++) {
                int j = i + L - 1;
                m[i][j] = Integer.MAX_VALUE;

                for (int k = i; k < j; k++) {
                    int q = m[i][k] + m[k + 1][j] + p[i - 1] * p[k] * p[j];

                    if (q < m[i][j]) {
                        m[i][j] = q;
                        s[i][j] = k;
                    }
                }
            }
        }
    }

    public static void printOptimalParens(int i, int j) {
        if (i == j) {
            System.out.print("A" + i);
        } else {
            System.out.print("(");
            printOptimalParens(i, s[i][j]);
            printOptimalParens(s[i][j] + 1, j);
            System.out.print(")");
        }
    }

    public static void printMatrix(int matrix[][], int n, String name) {
        System.out.println("\n" + name + " Matrix:");
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < n; j++) {
                if (i > j)
                    System.out.print("-\t");
                else
                    System.out.print(matrix[i][j] + "\t");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of matrices: ");
        int n = sc.nextInt();

        int p[] = new int[n + 1];

        System.out.println("Enter dimensions:");
        for (int i = 0; i <= n; i++) {
            System.out.print("p[" + i + "] = ");
            p[i] = sc.nextInt();
        }

        matrixChainOrder(p, n + 1);

        System.out.println("\nMinimum number of multiplications: " + m[1][n]);

        printMatrix(m, n + 1, "Cost (M)");
        printMatrix(s, n + 1, "Split (S)");

        System.out.print("\nOptimal Parenthesization: ");
        printOptimalParens(1, n);

        sc.close();
    }
}

/*Enter number of matrices: 4
Enter dimensions:
p[0] = 5
p[1] = 4
p[2] = 6
p[3] = 2
p[4] = 7

Minimum number of multiplications: 158

Cost (M) Matrix:
0       120     88      158
-       0       48      104
-       -       0       84
-       -       -       0

Split (S) Matrix:
0       1       1       3
-       0       2       3
-       -       0       3
-       -       -       0

Optimal Parenthesization: ((A1(A2A3))A4) */