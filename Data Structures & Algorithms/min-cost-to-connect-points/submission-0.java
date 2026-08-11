class Solution {
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;

        DSU dsu = new DSU(n);

        List<int[]> edges = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int dist = Math.abs(points[i][0] - points[j][0]) +
                           Math.abs(points[i][1] - points[j][1]);
                edges.add(new int[] {dist, i, j});
            }
        } 

        edges.sort((a, b) -> Integer.compare(a[0], b[0]));

        int res = 0;

        for (int[] edge: edges) {
            if (dsu.union(edge[1], edge[2])) {
                res += edge[0];
            }
        }
        return res;
    }
}

class DSU {
    int[] par, rank;

    public DSU(int size) {
        par = new int[size + 1];
        rank = new int[size + 1];

        for (int i = 0; i <= size; i++) {
            par[i] = i;
            rank[i] = 1;
        }
    }

    public int find(int x) {
        if (par[x] == x) {
            return x;
        }

        return find(par[x]);
    }

    public boolean union(int x, int y) {
        int parX = find(x);
        int parY = find(y);

        if (parX != parY) {
            int rX = rank[x];
            int rY = rank[y];

            if (rX > rY) {
                par[parY] = parX;
            } else if (rX < rY) {
                par[parX] = parY;
            } else {
                par[parX] = parY;
                rank[parY]++;
            }

            return true;
        }

        return false;
    }
}
