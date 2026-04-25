//AIM
/* Solve Shortest Common Supper sequence(SCS) using dynamic programming.*/

import java.util.*;

public class pr13 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter first string: ");
        String s1 = sc.nextLine();

        System.out.print("Enter second string: ");
        String s2 = sc.nextLine();

        int m = s1.length();
        int n = s2.length();

        int dp[][] = new int[m+1][n+1];

        // Fill DP table
        for(int i = 0; i <= m; i++){
            for(int j = 0; j <= n; j++){
                if(i == 0){
                    dp[i][j] = j;
                }
                else if(j == 0){
                    dp[i][j] = i;
                }
                else if(s1.charAt(i-1) == s2.charAt(j-1)){
                    dp[i][j] = 1 + dp[i-1][j-1];
                }
                else{
                    dp[i][j] = 1 + Math.min(dp[i-1][j], dp[i][j-1]);
                }
            }
        }

        System.out.println("\nDP Table (Values only):");
        System.out.print("    ");
        for(int j = 0; j < n; j++){
            System.out.print("  " + s2.charAt(j) + " ");
        }
        System.out.println();

        for(int i = 0; i <= m; i++){
            if(i == 0){
                System.out.print("  ");
            } else {
                System.out.print(s1.charAt(i-1) + " ");
            }

            for(int j = 0; j <= n; j++){
                System.out.print(" " + dp[i][j] + "  ");
            }
            System.out.println();
        }

        int i = m, j = n;
        String scs = "";

        while(i > 0 && j > 0){
            if(s1.charAt(i-1) == s2.charAt(j-1)){
                scs = s1.charAt(i-1) + scs;
                i--;
                j--;
            }
            else if(dp[i-1][j] < dp[i][j-1]){
                scs = s1.charAt(i-1) + scs;
                i--;
            }
            else{
                scs = s2.charAt(j-1) + scs;
                j--;
            }
        }

        while(i > 0){
            scs = s1.charAt(i-1) + scs;
            i--;
        }

        while(j > 0){
            scs = s2.charAt(j-1) + scs;
            j--;
        }

        System.out.println("\nLength of SCS: " + dp[m][n]);
        System.out.println("SCS String: " + scs);
    }
}

/*Enter first string: ABCBDAB
Enter second string: BDCABA

DP Table (Values only):
       B   D   C   A   B   A
   0   1   2   3   4   5   6
A  1   2   3   4   4   5   6
B  2   2   3   4   5   5   6
C  3   3   4   4   5   6   7
B  4   4   5   5   6   6   7
D  5   5   5   6   7   7   8
A  6   6   6   7   7   8   8
B  7   7   7   8   8   8   9

Length of SCS: 9
SCS String: ABCBDCABA */