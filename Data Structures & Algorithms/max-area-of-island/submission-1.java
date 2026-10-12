class Solution {
    int maxSize = 0;

    int[][] dirs = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};

    public int maxAreaOfIsland(int[][] grid) {
        int m = grid.length, n = grid[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    int size = dfs(grid, i, j);
                    maxSize = Math.max(maxSize, size);
                }
            }
        }


        return maxSize; 
    }

    private int dfs(int[][] grid, int i, int j) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == 0) {
            return 0;
        }

        int size = 1;
        grid[i][j] = 0;

        for (int[] dir : dirs) {
            size += dfs(grid, i + dir[0], j + dir[1]);
        }

        return size;
    }
}
