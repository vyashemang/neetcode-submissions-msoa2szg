class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {

        List<Integer> res = new ArrayList<>();
        int[] indegree = new int[numCourses];

        List<List<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] edge : prerequisites) {
            indegree[edge[0]]++;
            adj.get(edge[1]).add(edge[0]);
        }

        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                q.add(i);
            }
        }

        int completedCourses = 0;
        while(!q.isEmpty()) {
            int node = q.poll();
            res.add(node);
            completedCourses++;
            for (int nei : adj.get(node)) {
                indegree[nei]--;
                if (indegree[nei] == 0) {
                    q.add(nei);
                }
            }
        }

        if (numCourses != completedCourses) {
            return new int[0];
        }

        return res.stream().mapToInt(Integer::intValue).toArray();
    }
}
