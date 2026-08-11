class Solution {
    public int search(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;

        while (start < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] > nums[end]) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }

        int pivot = start;
        start = 0;
        end = nums.length - 1;

        if (target >= nums[pivot] && target <= nums[end]) {
            start = pivot;
        } else {
            end = pivot - 1;
        }

        while (start <= end) {
            int m = (start + end) / 2;
            if (nums[m] == target) {
                return m;
            } else if (nums[m] < target) {
                start = m + 1;
            } else {
                end = m - 1;
            }
        }

        return -1;
    }
}
