class Solution {
    public List<String> findWords(char[][] board, String[] words) {
        List<String> res = new ArrayList<>();

        for (String word : words) {
            boolean flag = false;
            for (int i = 0; i < board.length && !flag; i++) {
                for (int j = 0; j < board[0].length; j++) {
                    if (board[i][j] != word.charAt(0)) {
                        continue;
                    }
                    if (dfs(word, board, i, j, 0)) {
                        res.add(word);
                        flag = true;
                        break;
                    }
                }
            }
        }

        return res;
    }

    private boolean dfs(String word, char[][] board, int i, int j, int currIdx) {
        if (currIdx == word.length()) {
            return true;
        }
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length || board[i][j] != word.charAt(currIdx)) {
            return false;
        }
        
        board[i][j] = '*';
        boolean res = dfs(word, board, i + 1, j, currIdx + 1) ||
                    dfs(word, board, i - 1, j, currIdx + 1) ||
                    dfs(word, board, i, j + 1, currIdx + 1) ||
                    dfs(word, board, i, j - 1, currIdx + 1);
        board[i][j] = word.charAt(currIdx);
        return res;

    }
}
