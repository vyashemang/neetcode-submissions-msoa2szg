class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int n = numbers.length;

        int l = 0, r = n - 1;

        while (l < r) {
            int curr = numbers[l] + numbers[r];
            if (curr == target) {
                return new int[]{l + 1, r + 1};
            } else if (curr > target) {
                r--;
            } else {
                l++;
            }
        }

        return new int[]{-1, -1};
    }
}
