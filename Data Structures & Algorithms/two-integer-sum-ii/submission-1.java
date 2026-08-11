class Solution {
    public int[] twoSum(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int curr = nums[l] + nums[r];
            if (curr > target) {
                r--;
            } else if (curr < target) {
                l++;
            } else {
                return new int[]{l+1, r+1};
            }
        }
        return new int[]{};
    }
}
