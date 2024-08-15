//COUNT PALINDROME SUB-SEQUENCE
/*We define dp[i][j] as the number of palindromic subsequences in the substring s[i...j].
If s[i] == s[j], then:
dp[i][j]=dp[i+1][j]+dp[i][j−1]+1
The +1 is added because the substring s[i...j] itself is a palindrome.
If s[i] != s[j], then:
dp[i][j]=dp[i+1][j]+dp[i][j−1]−dp[i+1][j−1]
The - dp[i+1][j-1] is done to avoid counting the palindromic subsequences of
s[i+1...j-1] twice.*/

import java.util.*;
public class CountPalindromeSubsequence {
    public static int countPalindromicSubsequences(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            dp[i][i] = 1;
        }
        for (int length = 2; length <= n; length++) {
            for (int i = 0; i <= n - length; i++) {
                int j = i + length - 1;
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i + 1][j] + dp[i][j - 1] + 1;
                } else {
                    dp[i][j] = dp[i + 1][j] + dp[i][j - 1] - dp[i + 1][j - 1];
                }
            }
        }
        return dp[0][n-1];
    }
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        String s = "abca";
        System.out.println("Total palindromic subsequences: " +
                countPalindromicSubsequences(s));
        sc.close();
    }
}

