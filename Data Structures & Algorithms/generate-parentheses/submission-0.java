class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();

        helper(res, "", 0, 0, n);

        return res;
    }

    private void helper(List<String> res, String curr, int open, int close, int max) {
        if (curr.length() == max * 2) {
            res.add(curr);
            return;
        }

        if (open < max) {
            helper(res, curr + "(", open + 1, close, max);
        } 

        if (close < open) {
            helper(res, curr + ")", open, close + 1, max);
        }
    }
}
