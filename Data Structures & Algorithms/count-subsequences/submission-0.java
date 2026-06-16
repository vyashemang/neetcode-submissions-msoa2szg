class Solution {
    int[][] dp;
    public int numDistinct(String s, String t) {
        if (t.length() > s.length()) {
            return 0;
        }

        dp = new int[s.length()][t.length()];

        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < t.length(); j++) {
                dp[i][j] = -1;
            }
        }
        return dfs(0, 0, s, t);
    }

    private int dfs(int i, int j, String s, String t) {
        if (j == t.length()) {
            return 1;
        }
        if (i == s.length()) {
            return 0;
        }

        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        int res = dfs(i+1, j, s, t);
        if (s.charAt(i) == t.charAt(j)) {
            res += dfs(i + 1, j + 1, s, t);
        }
        return dp[i][j] = res;
    }
}
