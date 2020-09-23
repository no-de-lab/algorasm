class Solution {
    public void rotate(int[][] matrix) {
        final int SIZE = matrix.length;
        for (int i=0; i<SIZE; i++) {
            for (int j=0; j<SIZE; j++) {
                if (i>j) {
                    int tmp = matrix[i][j];
                    matrix[i][j] = matrix[j][i];
                    matrix[j][i] = tmp;
                }
            }
        }
        

        for (int i=0; i<SIZE/2; i++) {
            for (int j=0; j<SIZE; j++) {
                int tmp = matrix[j][i];
                matrix[j][i] = matrix[j][SIZE-1-i];
                matrix[j][SIZE-1-i] = tmp;
            }
        }
    }
}
