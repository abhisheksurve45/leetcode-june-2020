public class DungeonGame {
    /**
     * Question : https://leetcode.com/explore/featured/card/june-leetcoding-challenge/541/week-3-june-15th-june-21st/3367/
     * Reference : https://leetcode.com/problems/dungeon-game/discuss/698271/Python-Short-DP-9-lines-O(mn)-top-down-explained
     */
    class Solution {
        public int calculateMinimumHP(int[][] dungeon) {
            int n = dungeon.length;
            int m = dungeon[0].length;
            int[][] dp = new int[n][m];

            for (int i = n - 1; i >= 0; i--) {
                for (int j = m - 1; j >= 0; j--) {

                    if (i == n - 1 && j == m - 1) {
                        dp[i][j] = Math.max(1 - dungeon[i][j], 1);
                        continue;
                    }

                    if (i == n - 1) {
                        dp[i][j] = Math.max(dp[i][j + 1] - dungeon[i][j], 1);
                    } else if (j == m - 1) {
                        dp[i][j] = Math.max(dp[i + 1][j] - dungeon[i][j], 1);
                    } else {
                        int right = Math.max(dp[i][j + 1] - dungeon[i][j], 1);
                        int down = Math.max(dp[i + 1][j] - dungeon[i][j], 1);
                        dp[i][j] = Math.min(right, down);
                    }

                }
            }
            return dp[0][0];
        }
    }
}
