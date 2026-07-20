class Solution {
    public int longestConsecutive(int[] nums) {
        int n = nums.length;

        if (n == 0) {
            return 0;
        }

        Arrays.sort(nums);

        int res = 0, curr = nums[0], streak = 0;

        int i = 0;

        while (i < n) {
            if (nums[i] != curr) {
                curr = nums[i];
                streak = 0;
            }
            while (i < n && nums[i] == curr) {
                i++;
            }
            streak++;
            curr++;
            res = Math.max(res, streak);
        }
        return res;
    }
}
