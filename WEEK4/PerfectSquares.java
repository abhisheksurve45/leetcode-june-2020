public class PerfectSquares {

    /**
     * Question : https://leetcode.com/explore/challenge/card/june-leetcoding-challenge/542/week-4-june-22nd-june-28th/3373/
     * Reference : https://www.youtube.com/watch?v=K715avFmZIk
     */
    class Solution {
        public int numSquares(int n) {
            if (n < 4) return n;
            int dp[] = new int[n + 1];
            Arrays.fill(dp, -1);
            dp[0] = 0;
            dp[1] = 1;
            dp[2] = 2;
            dp[3] = 3;
            return numSquaresHelper(n, dp);
        }

        private int numSquaresHelper(int n, int[] dp) {

            if (dp[n] != -1) return dp[n];
            else {
                int min = Integer.MAX_VALUE;
                for (int i = 1; i * i <= n; i++) {
                    int curr = 1 + numSquaresHelper(n - i * i, dp);
                    min = Math.min(curr, min);
                }
                return dp[n] = min;
            }
        }
    }
}
