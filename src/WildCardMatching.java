class WildcardMatching {

    public static boolean match(String wild, String pattern) {
        int m = wild.length();
        int n = pattern.length();

        // DP table where dp[i][j] will be true if the first i characters in
        // wild can match
        // the first j characters in pattern.
        boolean[][] dp = new boolean[m + 1][n + 1];

        // An empty wild string can match an empty pattern string
        dp[0][0] = true;
        // Handle the case where the wild string starts with '*'
        for (int i = 1; i <= m; i++) {
            if (wild.charAt(i - 1) == '*') {
                dp[i][0] = dp[i - 1][0];
            }
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                char wc = wild.charAt(i - 1);
                char pc = pattern.charAt(j - 1);
                if (wc == pc || wc == '?') {
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (wc == '*') {
                    // '*' can match with an empty sequence (dp[i-1][j]) or any sequence (dp[i][j-1])
                    dp[i][j] = dp[i - 1][j] || dp[i][j - 1];
                }
            }
        }
        return dp[m][n];
    }
    public static void main(String[] args) {
        String wild1 = "ma*i";
        String pattern1 = "mahi";
        System.out.println(match(wild1, pattern1));

        String wild2 = "ma?i*";
        String pattern2 = "mahimughal";
        System.out.println(match(wild2, pattern2));

        String wild3 = "ma*i";
        String pattern3 = "maim";
        System.out.println(match(wild3, pattern3));
    }
}

