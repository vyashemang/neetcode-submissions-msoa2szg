class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();
        helper(nums, res, curr, 0);
        
        return res;
    }

    void helper(int[] nums, List<List<Integer>> res, List<Integer> curr, int idx) {
        if (idx == nums.length) {
            res.add(new ArrayList<>(curr));
            return;
        }



        curr.add(nums[idx]);
        helper(nums, res, curr, idx + 1);
        curr.remove(curr.size() - 1);
        helper(nums, res, curr, idx + 1);


    }
}
