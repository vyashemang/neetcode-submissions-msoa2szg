class Solution {
    public boolean hasDuplicate(int[] nums) {
        Map<Integer, Integer> entries = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (entries.containsKey(nums[i])) {
                return true;
            }
            entries.put(nums[i], 1);
        } 
        return false;
    }
}