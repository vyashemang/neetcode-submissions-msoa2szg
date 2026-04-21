
class Solution {

    int findWays (int[] nums, int target) {
        int n = nums.length;

        int[] prev = new int[target + 1];
        int[] curr = new int[target + 1];

        Arrays.fill(prev, 0);
        Arrays.fill(curr, 0);

        if (nums[0] == 0) {
            prev[0] = 2;
        }
        else {
            prev[0] = 1;
        }

        if (nums[0] != 0 && nums[0] <= target) {
            prev[nums[0]] = 1;
        }

        for (int ind = 1; ind < n; ind++) {
            curr = new int[target + 1];
            for (int sum = 0; sum <= target; sum++) {
                int notTake = prev[sum];
                int take = 0;

                if (nums[ind] <= sum) {
                    take = prev[sum - nums[ind]];
                }

                curr[sum] = (notTake + take);
            }
            prev = curr;
        }

        return prev[target];
    }

    public int findTargetSumWays(int[] nums, int target) {
        int totalSum = 0;
        for (int i : nums ){
            totalSum += i;
        }

        if (totalSum - target < 0) {
            return 0;
        }

        if ((totalSum - target) % 2 != 0) return 0;

        return findWays(nums, (totalSum - target) / 2);
    }


}
