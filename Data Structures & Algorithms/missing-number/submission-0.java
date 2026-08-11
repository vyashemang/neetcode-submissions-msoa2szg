class Solution {
    public int missingNumber(int[] nums) {

        int n = nums.length + 1;

        int idealSum = (n * (n - 1)) / 2;

        int currSum = 0;
        for (int i = 0; i < nums.length; i++) {
            currSum += nums[i];
        }

        return (idealSum - currSum);
    }
}
