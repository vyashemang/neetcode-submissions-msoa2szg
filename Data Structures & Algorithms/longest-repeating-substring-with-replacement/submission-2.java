class Solution {
    public int characterReplacement(String s, int k) {
        int res = 0, n = s.length();

        int start = 0, maxFreq = 0;
        Map<Character, Integer> m = new HashMap<>();

        for (int end = 0; end < n; end++) {
            m.put(s.charAt(end), m.getOrDefault(s.charAt(end), 0) + 1);
            maxFreq = Math.max(maxFreq, m.get(s.charAt(end)));

            while (((end - start + 1) - maxFreq) > k) {
                m.put(s.charAt(start), m.get(s.charAt(start)) - 1);
                start++;
            }
            res = Math.max(res, end - start + 1);
            
        }

        return res;
    }
}
