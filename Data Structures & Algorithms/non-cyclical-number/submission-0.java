class Solution {
    public boolean isHappy(int n) {
        Set<Integer> visited = new HashSet<Integer>();

        while (!visited.contains(n)) {
            visited.add(n);
            n = helper(n);
            if (n == 1) {
                return true;
            }
        }

        return false;
    }

    private int helper(int n) {
        int res = 0;

        while (n > 0) {
            res += Math.pow(n % 10, 2);
            n /= 10;
        }

        return res;
    }
}
