class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {

        if (hand.length % groupSize != 0) return false;


        Map<Integer, Integer> f = new HashMap<>();

        for (int i : hand) {
            f.put(i, f.getOrDefault(i, 0) + 1);
        }

        Arrays.sort(hand);

        for (int num : hand) {
            if (f.get(num) > 0) {
                for (int i = num; i < num + groupSize; i++) {
                    if (f.getOrDefault(i, 0) == 0) return false;
                    f.put(i, f.get(i) - 1);
                }
            }
        }

        return true;

    }
}
