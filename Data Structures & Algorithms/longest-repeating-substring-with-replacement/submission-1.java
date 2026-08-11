class Solution {
    public int characterReplacement(String s, int k) {
        int res = 0;

        HashMap<Character, Integer> m = new HashMap<>();


        int l = 0, maxf = 0;
        for (int r = 0; r < s.length(); r++) {
            m.put(s.charAt(r), m.getOrDefault(s.charAt(r), 0) + 1);
            maxf = Math.max(maxf, m.get(s.charAt(r)));


            while (((r - l + 1) - maxf) > k) {
                m.put(s.charAt(l), m.get(s.charAt(l)) - 1);
                l++;
            }
            res = Math.max(res, r - l + 1);
        }


        return res;
    }
}
