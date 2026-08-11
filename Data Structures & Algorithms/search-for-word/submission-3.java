class Solution {

    private Set<Pair<Integer, Integer>> path = new HashSet<>();

    public boolean exist(char[][] board, String word) {
        int resI = 0;
        char[] wc = word.toCharArray();

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (finder(board, i, j, resI, wc)) {
                    return true;
                }
            }
        }
        
        return false;
    }

    private boolean finder(char[][] board, int i, int j, int resI, char[] word) {
        if (resI == word.length) {
            return true;
        }

        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length || board[i][j] != word[resI] || path.contains(new Pair<>(i, j))) {
            return false;
        }

        path.add(new Pair<>(i, j));

        boolean res = finder(board, i + 1, j, resI + 1, word) || 
                    finder(board, i, j + 1, resI + 1, word) || 
                    finder(board, i - 1, j, resI + 1, word) ||
                    finder(board, i, j - 1, resI + 1, word);

        path.remove(new Pair<>(i, j));
        return res;
    }
}
