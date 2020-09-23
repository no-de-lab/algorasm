class Solution {
    private static final List<int[]> centers = List.of(
            new int[] {1,1}, new int[] {1,4}, new int[] {1,7},
            new int[] {4,1}, new int[] {4,4}, new int[] {4,7},
            new int[] {7,1}, new int[] {7,4}, new int[] {7,7}
    );

    private static final List<int[]> positions = List.of(
            new int[]{-1,-1}, new int[]{-1,0}, new int[]{-1,1}, new int[]{0,-1},
            new int[]{0,1}, new int[]{1,-1}, new int[]{1,0}, new int[]{1,1}
    );
    
    private boolean boxCheck(char [][] board) {
        for (int[] center: centers) {
            final Map<Character, Integer> map = new HashMap<>();
            final int y = center[0];
            final int x = center[1];
            if (board[y][x] != ',')
                map.put(board[y][x],1);

            for (int[] position : positions) {
                final int dy = y + position[0];
                final int dx = x + position[1];
                final char key = board[dy][dx];

                if (key != '.') {
                    if (map.containsKey(board[dy][dx]))
                        return false;
                    else
                        map.put(board[dy][dx], 1);
                }
            }
        }

        return true;
    }

    private boolean rowCheck(char[][] board) {
        for (int i=0; i<9; i++) {
            Map<Character, Integer> map = new HashMap<>();
            for (int j=0; j<9; j++) {
                final char key = board[i][j];

                if(key != '.') {
                    if (map.containsKey(key))
                        return false;
                    else
                        map.put(key, 1);
                }
            }
        }
        return true;
    }

    private boolean columnCheck(char[][] board) {
        for (int i=0; i<9; i++) {
            final Map<Character, Integer> map = new HashMap<>();
            for (int j=0; j<9; j++) {
                final char key = board[j][i];
                if (key != '.') {
                    if (map.containsKey(key))
                        return false;
                    else
                        map.put(key, 1);
                }
                System.out.println(map);
            }
        }
        return true;
    }
    
    public boolean isValidSudoku(char[][] board) {
        return boxCheck(board) && rowCheck(board) && columnCheck(board);
    }
}
