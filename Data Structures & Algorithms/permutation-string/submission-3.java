class Solution {
    public boolean checkInclusion(String s1, String s2) {
        Map<Character, Integer> m1 = new HashMap<>();

        for (char c : s1.toCharArray()) {
            m1.put(c, m1.getOrDefault(c, 0) + 1);
        }

        
        for (int i = 0; i < s2.length(); i++) {
            Map<Character, Integer> m2 = new HashMap<>();
            int currLength = 0;
            for (int j = i; j < s2.length(); j++) {

                m2.put(s2.charAt(j), m2.getOrDefault(s2.charAt(j), 0) + 1);

                if (m1.getOrDefault(s2.charAt(j), 0) < m2.get(s2.charAt(j))) {
                    break;
                }

                if (m1.getOrDefault(s2.charAt(j), 0) == m2.get(s2.charAt(j))) {
                    currLength++;
                }

                

                if (currLength == m1.size()) {
                    return true;
                }
            }
        }
        return false;
    }
}
