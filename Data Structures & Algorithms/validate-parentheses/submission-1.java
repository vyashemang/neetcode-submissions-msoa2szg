class Solution {
    public boolean isValid(String s) {
        Stack<Character> stk = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(' || s.charAt(i) == '[' || s.charAt(i) == '{') {
                stk.push(s.charAt(i));
            } else if (s.charAt(i) == ')') {
                if (!stk.isEmpty() && stk.peek() == '(') {
                    stk.pop();
                } else {
                    return false;
                }
            } else if (s.charAt(i) == '}') {
                if (!stk.isEmpty() && stk.peek() == '{') {
                    stk.pop();
                } else {
                    return false;
                }
            } else if (s.charAt(i) == ']') {
                if (!stk.isEmpty() && stk.peek() == '[') {
                    stk.pop();
                } else {
                    return false;
                }
            }
        }

        return stk.isEmpty();
    }
}
