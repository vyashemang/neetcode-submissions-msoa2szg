class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        Set<List<Integer>> res = new HashSet<>();
        List<Integer> curr = new ArrayList<>();

        helper(nums, target, 0, curr, res);

        return List.copyOf(res);
    }

    public void helper(int[] nums, int target, int idx, List<Integer> curr, Set<List<Integer>> res) {
        if (target == 0) {
            res.add(new ArrayList<>(curr));
            return;
        }

        if (idx == nums.length || target < 0) {
            return;
        }

        curr.add(nums[idx]);
        helper(nums, target - nums[idx], idx, curr, res);
        curr.remove(curr.size() - 1);
        helper(nums, target, idx + 1, curr, res);
    }
}
