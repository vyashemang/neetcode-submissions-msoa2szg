class Solution {
    public int countComponents(int n, int[][] edges) {
        int res = 0;

        if (n == 0 || n == 1) {
            return n;
        }
        
        boolean[] visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            visited[i] = false;
        }

        Map<Integer, List<Integer>> g = new HashMap<>();

        for (int[] edge: edges) {
            g.putIfAbsent(edge[0], new ArrayList<>());
            g.putIfAbsent(edge[1], new ArrayList<>());

            g.get(edge[0]).add(edge[1]);
            g.get(edge[1]).add(edge[0]);
        }

        for (int i = 0; i < n; i++) {
            if (visited[i] == false) {
                res++;
                dfs(visited, i, g);
            }
        }
        return res;
    }

    private void dfs(boolean[] visited, int v, Map<Integer, List<Integer>> graph) {
        if (visited[v]) {
            return;
        }

        visited[v] = true;

        List<Integer> neighbours = graph.get(v);

        if (neighbours == null) {
            return;
        }

        for (int i : neighbours) {
            dfs(visited, i, graph);
        }
    }
}
