class Solution {
    public List<Integer> spiralOrder(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;

        int r1 = 0, c1 = 0, r2 = m, c2 = n;

        List<Integer> res = new ArrayList<>();

        while(r1 < r2 && c1 < c2) {
            for (int i = c1; i < c2; i++) {
                res.add(mat[r1][i]);
            }
            r1++;

            for (int i = r1; i < r2; i++) {
                res.add(mat[i][c2 - 1]);
            }
            c2--;

            if (!(c1 < c2 && r1 < r2)) {
                break;
            }

            for (int i = c2 - 1; i >= c1; i--) {
                res.add(mat[r2 - 1][i]);
            }
            r2--;

            for(int i = r2 - 1; i >= r1; i--) {
                res.add(mat[i][c1]);
            }
            c1++;
        }

        return res;
    }
}
