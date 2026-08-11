class Solution {
    private int[][] memo;
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        memo = new int[n+1][n+1];


        for (int i = n - 1; i >= 0; i--) {
            for (int j = i - 1; j >= -1; j--) {
                int LIS = memo[i+1][j+1];
                if (j == -1 || nums[j] < nums[i]) {
                    LIS = Math.max(LIS, 1 + memo[i+1][i+1]);
                }
                memo[i][j+1] = LIS;
            }
        }

        return memo[0][0];    
    }
}
