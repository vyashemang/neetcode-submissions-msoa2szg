class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        ArrayList<Integer> pre = new ArrayList<>(Collections.nCopies(n, 1));
        ArrayList<Integer> suf = new ArrayList<>(Collections.nCopies(n, 1));

        pre.set(0, 1);
        suf.set(n-1, 1);
        for (int i = 1; i < n; i++) {
            pre.set(i, nums[i-1] * pre.get(i-1));
        }

        for(int i = n - 2; i >= 0; i--) {
            suf.set(i, nums[i+1]* suf.get(i+1));
        }

        int[] res = new int[n];
        for(int i = 0; i < n; i++) {
            res[i] = pre.get(i) * suf.get(i);
        }

        return res;

    }
}  
