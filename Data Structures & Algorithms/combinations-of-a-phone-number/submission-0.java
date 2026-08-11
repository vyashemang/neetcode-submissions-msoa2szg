class Solution {
    public List<String> letterCombinations(String digits) {
        Map<Character, String> m = new HashMap<>();
        m.put('1', "");
        m.put('2', "abc");
        m.put('3', "def");
        m.put('4', "ghi");
        m.put('5', "jkl");
        m.put('6', "mno");
        m.put('7', "pqrs");
        m.put('8', "tuv");
        m.put('9', "wxyz");

        List<String> res = new ArrayList<>();

        if (digits.isEmpty()) {
            return res;
        }

        helper(digits, m, 0, res, "");
        

        return res;
    }

    private void helper(String digits, Map<Character, String> m, int idx, List<String> res, String curr) {
        if (idx == digits.length()) {
            res.add(curr);
            return;
        }

        for (char c: m.get(digits.charAt(idx)).toCharArray()) {
            helper(digits, m, idx + 1, res, curr + c);
        }
        

    }
}
