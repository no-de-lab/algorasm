class Solution {
    public boolean isValidSudoku(char[][] board) {
        boolean check_row[][] = new boolean[9][9];
        boolean check_col[][] = new boolean[9][9];
        boolean check_box[][] = new boolean[9][9];
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                if(board[i][j]!='.'){
                    int kk = board[i][j] - '0';
                    int k = kk-1;
                    if(check_row[i][k] == false)
                        check_row[i][k] = true;
                    else
                        return false;
                    
                    if(check_col[j][k] == false)
                        check_col[j][k] = true;
                    else
                        return false;
                    
                    if(check_box[(i/3)*3+j/3][k] == false)
                        check_box[(i/3)*3+j/3][k] = true;
                    else
                        return false;
                }
            }
        }
        return true;
    }
}