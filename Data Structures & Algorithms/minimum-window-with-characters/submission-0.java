class Solution {
    public String minWindow(String s, String t) {

        if (t.isEmpty()) return "";

        Map<Character, Integer> mt = new HashMap<>();
        Map<Character, Integer> ms = new HashMap<>();

        for (char c : t.toCharArray()) {
            mt.put(c, mt.getOrDefault(c, 0) + 1);
        }

        int start = 0;
        int resLen = Integer.MAX_VALUE;
        int[] res = {-1, -1};
        int have = 0, need = mt.size(); 


        for (int end = 0; end < s.length(); end++) {
            char c = s.charAt(end);
            ms.put(c, ms.getOrDefault(c, 0) + 1);

            if (mt.containsKey(c) && ms.get(c).equals(mt.get(c))) {
                // calculate the required length of the substring
                have++;
            }

            while(have == need) {
                if ((end - start + 1) < resLen) {
                    resLen = end - start + 1;
                    res[0] = start;
                    res[1] = end;
                }

                // shrink the window
                char leftC = s.charAt(start);
                ms.put(leftC, ms.get(leftC) - 1);
                
                if (mt.containsKey(leftC) && ms.get(leftC) < mt.get(leftC)) {
                    have--;
                }
                start++;
            }
        }

        return resLen == Integer.MAX_VALUE ? "" : s.substring(res[0], res[1] + 1);
    }
}
