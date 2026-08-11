class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (b[0] - a[0]));

        int[] output = new int[n - k + 1];

        int start = 0;

        for (int end = 0; end < n; end++) {
            pq.add(new int[]{nums[end], end});

            if (end >= k - 1) {
                // remove old values out of window
                while (pq.peek()[1] <= end - k) {
                    pq.poll();
                }

                output[start++] = pq.peek()[0];
            }
        }
        return output;
    }
}
