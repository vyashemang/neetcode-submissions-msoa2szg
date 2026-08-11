class Solution {
    public int maxSubArray(int[] nums) {
        int currSum = 0;
        int res = nums[0];

        for(int i : nums) {
            if (currSum < 0) {
                currSum = 0;
            }
            currSum += i;
            res = Math.max(res, currSum);
        }

        return res;
    }
}
