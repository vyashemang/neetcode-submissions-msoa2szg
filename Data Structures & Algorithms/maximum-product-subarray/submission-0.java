class Solution {
    public int maxProduct(int[] nums) {
        int res = nums[0];
        int currMin = 1, currMax = 1;

        for (int num : nums) {
            int curr = currMax * num;
            currMax = Math.max(Math.max(currMax * num, currMin * num), num);
            currMin = Math.min(Math.min(curr, currMin * num), num);
            res = Math.max(res, currMax);
        }

        return res;
    }
}
