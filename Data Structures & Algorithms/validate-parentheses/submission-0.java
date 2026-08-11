class Solution {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        HashMap<Character, Character> m = new HashMap<>();

        m.put(')', '(');
        m.put(']', '[');
        m.put('}', '{');

        for (char c : s.toCharArray()) {
            if (m.containsKey(c)) {
                if (!st.isEmpty() && st.peek() == m.get(c)) {
                    st.pop();
                } else {
                    return false;
                }
            } else {
                st.push(c);
            }
        }
        return st.isEmpty();
    }
}
