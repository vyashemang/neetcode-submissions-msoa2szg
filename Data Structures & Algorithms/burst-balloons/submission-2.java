class Solution {


    public int maxCoins(int[] nums) {
        int n = nums.length;

        // dp array to keep track of l,r 
        int[][] dp = new int[n + 2][n + 2];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= n; j++) {
                dp[i][j] = -1;
            }
        }

        // add 1 to both edges
        int[] newNums = new int[n + 2];
        newNums[0] = newNums[n+1] = 1;
        for (int i = 0; i < n; i++) {
            newNums[i + 1] = nums[i];
        }

        return dfs(newNums, 1, n, dp); 
    }

    private int dfs(int[] nums, int l, int r, int[][] dp) {
        if (l > r) {
            return 0;
        }

        if (dp[l][r] != -1) {
            return dp[l][r];
        }

        dp[l][r] = 0;

        for (int i = l; i <= r; i++) {
            // assume this is the last elem that we are solving -> (1, i, 1)
            int coins = nums[l-1] * nums[i] * nums[r+1];
            // solve left side + solve right side
            coins += dfs(nums, l, i-1, dp) + dfs(nums, i+1, r, dp);
            // choose the max
            dp[l][r] = Math.max(dp[l][r], coins);
        }

        return dp[l][r];
    }
}
