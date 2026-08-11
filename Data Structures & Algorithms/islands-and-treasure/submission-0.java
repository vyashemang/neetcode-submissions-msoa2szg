class Solution {
    public void islandsAndTreasure(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        Queue<int[]> q = new LinkedList<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    q.add(new int[]{i, j});
                }
            }
        }

        int level = 0;

        int[][] dirs = {{-1, 0}, {0, -1}, {0, 1}, {1, 0}};

        while (!q.isEmpty()) {
            int[] node = q.poll();

            int row = node[0];
            int col = node[1];

            for (int[] dir: dirs) {
                int r = row + dir[0];
                int c = col + dir[1];

                if (r >= m || c >= n || c < 0 || r < 0 || grid[r][c] != Integer.MAX_VALUE) {
                    continue;
                }

                q.add(new int[]{r, c});

                grid[r][c] = grid[row][col] + 1;
            }
        }


    }
}
