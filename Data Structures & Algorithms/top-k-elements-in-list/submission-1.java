class Solution {
    public int[] topKFrequent(int[] nums, int k) {

        int n = nums.length;

        Map<Integer, Integer> count = new HashMap<>();

        for (int i = 0; i < n; i++) {
            count.put(nums[i], count.getOrDefault(nums[i], 0) + 1);
        }

        List<Integer>[] freq = new List[n + 1];

        for (int i = 0; i < freq.length; i++) {
            freq[i] = new ArrayList<>();
        }

        for (Map.Entry<Integer, Integer> entry : count.entrySet()) {
            freq[entry.getValue()].add(entry.getKey());
        }

        int[] res = new int[k];

        int idx = 0;

        for (int i = freq.length - 1; i > 0 && idx < k; i--) {
            for (int j : freq[i]) {
                res[idx++] = j;
                if (idx == k) {
                    return res;
                }
            }
        }

        return res;
    }
}
