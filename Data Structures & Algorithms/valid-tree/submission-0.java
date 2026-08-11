class Solution {
    public boolean validTree(int n, int[][] edges) {
        if (edges.length > n - 1) {
            return false;
        }

        Map<Integer, List<Integer>> g = new HashMap<>();

        for (int i = 0; i < n; i++) { 
            g.putIfAbsent(i, new ArrayList<>());
        }

        for (int[] edge : edges) {
            g.get(edge[0]).add(edge[1]);
            g.get(edge[1]).add(edge[0]);
        }

        Set<Integer> visited = new HashSet<>();

        if (!dfs(0, -1, visited, g)) {
            return false;
        }

        return visited.size() == n;
    }

    private boolean dfs(int node, int parent, Set<Integer> visited, Map<Integer, List<Integer>> g) {
        if (visited.contains(node)) {
            return false;
        }

        visited.add(node);

        for (int nei : g.get(node)) {
            if (nei == parent) {
                continue;
            }

            if (!dfs(nei, node, visited, g)) {
                return false;
            }
        }

        return true;
    }
}
