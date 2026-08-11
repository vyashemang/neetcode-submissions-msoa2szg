class Solution {
    public void rotate(int[][] matrix) {
        int edgeLength = matrix.length;

        int top = 0, bottom = edgeLength - 1;

        while (top < bottom) {
            for (int j = 0; j < edgeLength; j++) {
                int temp = matrix[top][j];
                matrix[top][j] = matrix[bottom][j];
                matrix[bottom][j] = temp;
            }
            top++;
            bottom--;
        }

        for (int i = 0; i < edgeLength; i++) {
            for (int j = i + 1; j < edgeLength; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }


    }
}
