class Solution {
    public boolean isAnagram(String s, String t) {
        s = sort(s);
        t = sort(t);

        if (s.length() != t.length()) {
            return false;
        }

        int i = 0;
        for(; i < s.length(); i++) {
            if (s.charAt(i) != t.charAt(i)) {
                return false;
            }
        }

        return true;
    }

    private String sort(String inputString) {
        char[] charArray = inputString.toCharArray();

        // Sort the character array using Arrays.sort()
        Arrays.sort(charArray);

        // Convert the sorted character array back to a string
        return new String(charArray);
    }
}
