class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> entries = new HashMap<>();

        int n = nums.length;

        for (int i = 0; i < n; i++) {
            if (entries.containsKey(target - nums[i])) {
                return new int[]{entries.get(target - nums[i]), i};
            }
            entries.put(nums[i], i);
        }

        return new int[2];
    }
}
