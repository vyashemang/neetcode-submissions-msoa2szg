class Solution {

    private int[][] dp;

    public int longestCommonSubsequence(String t1, String t2) {
        
        dp = new int[t1.length()][t2.length()];

        for (int i = 0; i < t1.length(); i++) {
            for (int j = 0; j < t2.length(); j++) {
                dp[i][j] = -1;
            }
        }

        return dfs(t1, t2, 0, 0);

    }

    private int dfs(String t1, String t2, int i, int j) {
        if (i == t1.length() || j == t2.length()) {
            return 0;
        }

        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        if (t1.charAt(i) == t2.charAt(j)) {
            dp[i][j] = 1 + dfs(t1, t2, i + 1, j + 1);
        } else {
            dp[i][j] = Math.max(dfs(t1, t2, i + 1, j), dfs(t1, t2, i, j + 1));
        }

        return dp[i][j];
    }
}
