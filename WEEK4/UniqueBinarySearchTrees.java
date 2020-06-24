public class UniqueBinarySearchTrees {
    /**
     * Question : https://leetcode.com/explore/challenge/card/june-leetcoding-challenge/542/week-4-june-22nd-june-28th/3370/
     * Video : https://www.youtube.com/watch?v=GgP75HAvrlY
     */
    class Solution {
        public int numTrees(int n) {
            if (n == 0) return 0;

            int[] dp = new int[n + 1];

            dp[0] = 1;
            dp[1] = 1;

            for (int i = 2; i <= n; i++) {
                for (int j = 0; j < i; j++) {
                    dp[i] += (dp[j] * dp[i - j - 1]);
                }
            }

            return dp[n];
        }
    }
}
