class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for (int stone: stones) {
            pq.add(stone);
        }

        while (pq.size() >= 2) {
            int top1 = pq.poll();
            int top2 = pq.poll();
            pq.add(Math.abs(top1 - top2));
        }

        if (pq.isEmpty()) {
            return 0;
        }

        return pq.peek();
    }
}
