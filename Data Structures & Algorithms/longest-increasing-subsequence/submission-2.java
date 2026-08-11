class Solution {
    private int[][] memo;
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        memo = new int[n+1][n+1];


        // we start from the right side of the array
        for (int i = n - 1; i >= 0; i--) {
            // j represents the prev elements from curr idx i
            for (int j = i - 1; j >= -1; j--) {

                // start by not including in the sequence
                int LIS = memo[i+1][j+1];

                // j == -1 represents the first element
                // other condition check if the prev element is smaller than the current one
                if (j == -1 || nums[j] < nums[i]) {
                    // if it is smaller then consider it in the sequence
                    LIS = Math.max(LIS, 1 + memo[i+1][i+1]);
                }
                memo[i][j+1] = LIS;
            }
        }

        return memo[0][0];    
    }
}
