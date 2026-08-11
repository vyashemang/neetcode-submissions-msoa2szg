class Solution {
    public int change(int amount, int[] coins) {
        Arrays.sort(coins);
        int[][] memo = new int[coins.length + 1][amount + 1];
        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }
        return helper(coins, 0, amount, memo);
    }

    private int helper(int[] coins, int i, int a, int[][] memo) {
        if (a == 0) {
            return 1;
        }
        
        if (i >= coins.length) {
            return 0;
        }

        if (memo[i][a] != -1) return memo[i][a];

        int res = 0;

        if (a >= coins[i]) {
            res = helper(coins, i + 1, a, memo);
            res += helper(coins, i, a - coins[i], memo);
        }

        memo[i][a] = res;

        return res;
    }
}
