public class UniquePaths {

    /**
     * Question : https://leetcode.com/explore/challenge/card/june-leetcoding-challenge/543/week-5-june-29th-june-30th/3375/
     * Reference : https://leetcode.com/problems/unique-paths/discuss/711209/Summary-of-4-different-solutions-w-Recursion-Tree
     */
    class Solution {
        public int uniquePaths(int m, int n) {
            int[][] dp = new int[m][n];

            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (i == 0 || j == 0) {
                        dp[i][j] = 1;
                    } else {
                        dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                    }
                }
            }

            return dp[m - 1][n - 1];
        }
    }
}
