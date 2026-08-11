class Solution {
    public List<Integer> partitionLabels(String s) {
        HashMap<Character, Integer> lastIdx = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            lastIdx.put(s.charAt(i), i);
        }

        List<Integer> res = new ArrayList<>();
        int end = 0, size = 0;
        for (int i = 0; i < s.length(); i++) {
            size++;

            end = Math.max(end, lastIdx.get(s.charAt(i)));

            if (i == end) {
                res.add(size);
                size = 0;
            }
        }

        return res;
    }
}
