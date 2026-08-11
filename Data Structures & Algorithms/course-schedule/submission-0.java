class Solution {
    public boolean canFinish(int n, int[][] pre) {

        int[] indegree = new int[n];
        List<List<Integer>> g = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            g.add(new ArrayList<>());
        }

        for (int[] p : pre) {
            indegree[p[1]]++;
            g.get(p[0]).add(p[1]);
        }

        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) {
                q.add(i);
            }
        }

        int finished = 0;
        while(!q.isEmpty()) {
            int node = q.poll();
            finished++;
            for (int nei : g.get(node)) {
                indegree[nei]--;
                if (indegree[nei] == 0) {
                    q.add(nei);
                }
            }
        }

        return finished == n;

    }
}
