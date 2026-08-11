class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> s = new HashSet<Integer>();

        for (int i = 0; i < nums.length; i++) {
            s.add(nums[i]);
        }

        int count = 0;

        for (int i = 0; i < nums.length; i++) {
            int streak = 0, curr = nums[i];
            while (s.contains(curr)) {
                streak++;
                curr++;
            }
            count = Math.max(count, streak);
        }

        return count;
    }
}
