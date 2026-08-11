class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int maxArea = 0;

        int r = grid.length;
        int c = grid[0].length;

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (grid[i][j] == 1) {
                    maxArea = Math.max(helper(grid, i, j), maxArea);
                }
            }
        }

        return maxArea;
    }

    private static final int[][] directions = {{1, 0}, {-1, 0},
                                               {0, 1}, {0, -1}};

    private int helper(int[][] grid, int i, int j) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == 0) {
            return 0;
        }

        grid[i][j] = 0;

        int res = 1;
        for (int[] dir : directions) {
            res += helper(grid, i + dir[0], j + dir[1]);
        }

        return res;
    }
}
