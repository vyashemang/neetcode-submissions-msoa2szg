class Solution {

    private double getDistance(int[] point) {
        return Math.sqrt(Math.pow(point[0], 2) + Math.pow(point[1], 2));
    }

    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<Pair<Double, Integer>> pq = new PriorityQueue<>(
            (a, b) -> Double.compare(b.getKey(), a.getKey())
        );

        for (int i = 0; i < points.length; i++) {
            double dist = getDistance(points[i]);
            pq.add(new Pair<>(dist, i));
            if (pq.size() > k) {
                pq.poll();
            }
        }

        int[][] res = new int[k][2];
        int i = 0;
        while(!pq.isEmpty()) {
            res[i++] = points[pq.poll().getValue()];
        }
        return res;
    }
}
