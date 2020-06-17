public class SurroundedRegions {
    /**
     * Question : https://leetcode.com/explore/featured/card/june-leetcoding-challenge/541/week-3-june-15th-june-21st/3363/
     */
    class Solution {
        public void solve(char[][] board) {

            int row = board.length;
            if (row == 0) return;
            int col = board[0].length;

            for (int i = 0; i < row; i++) {
                if (board[i][0] == 'O')
                    dfs(board, i, 0);
            }

            for (int i = 0; i < row; i++) {
                if (board[i][col - 1] == 'O')
                    dfs(board, i, col - 1);
            }

            for (int j = 0; j < col; j++) {
                if (board[0][j] == 'O')
                    dfs(board, 0, j);
            }

            for (int j = 0; j < col; j++) {
                if (board[row - 1][j] == 'O')
                    dfs(board, row - 1, j);
            }

            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    if (board[i][j] == 'O')
                        board[i][j] = 'X';
                    if (board[i][j] == '*')
                        board[i][j] = 'O';
                }
            }

        }

        private void dfs(char[][] board, int i, int j) {
            if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != 'O') {
                return;
            }
            board[i][j] = '*';
            dfs(board, i + 1, j);
            dfs(board, i, j + 1);
            dfs(board, i - 1, j);
            dfs(board, i, j - 1);
        }
    }
}
