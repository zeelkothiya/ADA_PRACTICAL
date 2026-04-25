//AIM
/*  Solve Make a change problem Using Dynamic Programming. */

import java.util.*;
public class pr9 {
    public static void minCoins(int[] coins, int amount) {

        int[][] dp = new int[coins.length + 1][amount + 1];
        for (int i = 0; i <= coins.length; i++) {
            for (int j = 0; j <= amount; j++) {
                if (j == 0)
                    dp[i][j] = 0;
                else if (i == 0)
                    dp[i][j] = amount + 1;
                else {
                    if (coins[i - 1] <= j) {
                        dp[i][j] = Math.min( 1 + dp[i][j - coins[i - 1]] , dp[i - 1][j] );
                    } else {
                        dp[i][j] = dp[i - 1][j];
                    }
                }
            }
        }
        System.out.println("\nDP Matrix:");
        for (int i = 0; i <= coins.length; i++) {
            for (int j = 0; j <= amount; j++) {
                if (dp[i][j] == amount + 1)
                    System.out.print("∞ ");
                else
                    System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("\nMinimum coins needed: " + dp[coins.length][amount]);
        int i = coins.length;
        int j = amount;
        int[] count = new int[coins.length];
        while (j > 0 && i > 0) {
            if (dp[i][j] == dp[i - 1][j]) {
                i--;
            } else {
                count[i - 1]++;
                j = j - coins[i - 1];
            }
        }
        for (int k = 0; k < coins.length; k++) {
            if (count[k] > 0) {
                System.out.println("Coin " + coins[k] + " is used : " + count[k] + " time");
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of coins: ");
        int n = sc.nextInt();

        int[] coins = new int[n];
        System.out.println("Enter coin values:");
        for (int i = 0; i < n; i++) {
            coins[i] = sc.nextInt();
        }
        System.out.print("Enter target amount: ");
        int amount = sc.nextInt();
        minCoins(coins, amount);
    }
}

/*Enter number of coins: 3
Enter coin values:
1
4
6
Enter target amount: 8

DP Matrix:
0 ∞ ∞ ∞ ∞ ∞ ∞ ∞ ∞
0 1 2 3 4 5 6 7 8
0 1 2 3 1 2 3 4 2
0 1 2 3 1 2 1 2 2

Minimum coins needed: 2
Coin 4 is used : 2 time */