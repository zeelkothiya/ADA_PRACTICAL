//AIM
/* Solve Longest Common Subsequence(LCS) using dynamic programming.*/

import java.util.*;

public class pr12 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter first string: ");
        String s1 = sc.nextLine();

        System.out.print("Enter second string: ");
        String s2 = sc.nextLine();

        int m = s1.length();
        int n = s2.length();

        int dp[][] = new int[m+1][n+1];
        char dir[][] = new char[m+1][n+1];

        for(int i = 1; i <= m; i++){
            for(int j = 1; j <= n; j++){
                if(s1.charAt(i-1) == s2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1] + 1;
                    dir[i][j] = 'D';
                }
                else if(dp[i-1][j] >= dp[i][j-1]){
                    dp[i][j] = dp[i-1][j];
                    dir[i][j] = 'U';
                }
                else{
                    dp[i][j] = dp[i][j-1];
                    dir[i][j] = 'L';
                }
            }
        }

        System.out.println("\nDP Table (Value + Direction):");
        System.out.print("    "); 
        for(int j = 0; j < n; j++){
            System.out.print("  " + s2.charAt(j)+"  ");
        }
        System.out.println();

        for(int i = 0; i <= m; i++){
            if(i == 0){
                System.out.print("  ");
            } else {
                System.out.print(s1.charAt(i-1) + " ");
            }

            for(int j = 0; j <= n; j++){
                if(i == 0 || j == 0){
                    System.out.print(" " + dp[i][j] + "  ");
                } else {
                    System.out.print(dp[i][j] + "" + dir[i][j] + "  ");
                }
            }
            System.out.println();
        }

        int i = m, j = n;
        String lcs = "";

        while(i > 0 && j > 0){
            if(dir[i][j] == 'D'){
                lcs = s1.charAt(i-1) + lcs;
                i--;
                j--;
            }
            else if(dir[i][j] == 'U'){
                i--;
            }
            else{
                j--;
            }
        }

        System.out.println("\nLength of LCS: " + dp[m][n]);
        System.out.println("LCS String: " + lcs);
    }
}

/*Enter first string: ABCBDAB
Enter second string: BDCABA

DP Table (Value + Direction):
      B   D    C   A   B   A
   0   0   0   0   0   0   0
A  0  0U  0U  0U  1D  1L  1D
B  0  1D  1L  1L  1U  2D  2L
C  0  1U  1U  2D  2L  2U  2U
B  0  1D  1U  2U  2U  3D  3L
D  0  1U  2D  2U  2U  3U  3U
A  0  1U  2U  2U  3D  3U  4D
B  0  1D  2U  2U  3U  4D  4U

Length of LCS: 4
LCS String: BCBA */