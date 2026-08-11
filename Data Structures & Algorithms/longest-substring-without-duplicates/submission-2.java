class Solution {
    public int lengthOfLongestSubstring(String s) {
        int res = 0;
        int n = s.length();

        int start = 0, end = 0;

        Set<Character> st = new HashSet<>();

        while (end < n) {
            
                while(st.contains(s.charAt(end))) {
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
