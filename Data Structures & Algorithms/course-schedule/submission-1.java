class Solution {
    public boolean canFinish(int n, int[][] prerequisites) {
        int[] indegree = new int[n];

        List<List<Integer>> g = new ArrayList<>();

        

        for (int i = 0; i < n; i++){
            g.add(new ArrayList<>());
        }

        for (int[] p: prerequisites) {
            indegree[p[1]]++;
            g.get(p[0]).add(p[1]);
        }

        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < n; i++){
            if (indegree[i] == 0) {
                q.add(i);
            }
        }
        
        int completed = 0;

        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int curr = q.poll();
                completed++;
                for (int j = 0; j < g.get(curr).size(); j++) {
                    indegree[g.get(curr).get(j)]--;
                    if (indegree[g.get(curr).get(j)] == 0) {
                        q.add(g.get(curr).get(j));
                    }
                }
            }
        }


        return completed == n;
    }
}
