class Solution {
    public int longestConsecutive(int[] nums) {
        int n = nums.length;

        if (n == 0) return 0;

        HashSet<Integer> s = new HashSet<>();

        for (int i : nums) {
            s.add(i);
        }

        int longest = 0;
        int curr = nums[0];

        for (int num : s) {
            if (!s.contains(num - 1)) {
                int length = 1;

                while (s.contains(num + length)) {
                    length++;
                }
                longest = Math.max(longest, length);
            }

        }

        return longest;
    }

}
