class Solution {
    //A grid can store more than 0 and 1
    //so we can store different transfering state in the grid too
    public void gameOfLife(int[][] board) {
        // 0 ->1: -1, 1 -> 0: -2
        update(board);
        return;
    }
    
    public void update(int[][] board){
        int row = board.length;
        int column = board[0].length;
        int[] dx = {1, 1, 0, -1, -1, -1, 0, 1};
        int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};
        for (int i = 0; i < row; ++i) {
            for (int j = 0; j < column; ++j) {
                int sum = 0;
                for (int n = 0; n < 8; ++n) {
                    int a = i + dx[n];
                    int b = j + dy[n];
                    if (a >= 0 && a < row && b >= 0 && b < column && (board[a][b] == 1 || board[a][b] == -2)) {
                        sum++;
                    }
                }
                //System.out.println(sum);
                if ((sum < 2 || sum > 3) && board[i][j] == 1) board[i][j] = -2;
                if (sum == 3 && board[i][j] == 0) board[i][j] = -1;
                
            }
        }
        
        for (int i = 0; i < row; ++i) {
            for (int j = 0; j < column; ++j) {
                //System.out.print(board[i][j]+" ");
                if (board[i][j] == -1) board[i][j] = 1;
                if (board[i][j] == -2) board[i][j] = 0;
                
            }
            //System.out.println();
        }
    }
}