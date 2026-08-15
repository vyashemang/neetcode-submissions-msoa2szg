class Solution {
    public int lengthOfLongestSubstring(String s) {
        int res = 0, n = s.length(), start = 0;

        Set<Character> st = new HashSet<>();

        for (int end = 0; end < n;) {
            while (st.contains(s.charAt(end))) {
                st.remove(s.charAt(start));
                start++;
            }
            res = Math.max(res, end - start + 1);
            st.add(s.charAt(end));
            end++;
        }
        return res;
    }
}
