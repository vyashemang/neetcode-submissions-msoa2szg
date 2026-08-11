class Solution {
    public int swimInWater(int[][] grid) {
        int n = grid.length;

        boolean[][] visited = new boolean[n][n];

        PriorityQueue<int[]> minHeap = new PriorityQueue<> (
            Comparator.comparingInt(a -> a[0])
        );

        int[][] dirs = {
            {0, 1}, {0, -1}, {1, 0}, {-1, 0}
        };

        minHeap.offer(new int[]{grid[0][0], 0, 0});
        visited[0][0] = true;

        while (!minHeap.isEmpty()) {
            int[] curr = minHeap.poll();

            int t = curr[0], r = curr[1], c = curr[2];
            if (r == n-1 && c == n-1) {
                return t;
            }
            for (int[] dir : dirs) {
                int nR = r + dir[0], nC = c + dir[1];
                if (nR >= 0 && nC >= 0 && nR < n && nC < n && !visited[nR][nC]) {
                    visited[nR][nC] = true;
                    minHeap.offer(new int[]{
                        Math.max(t, grid[nR][nC]),
                        nR, nC
                    });
                }
            }
        }

        return n*n;
    }
}
