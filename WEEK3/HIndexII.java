public class HIndexII {

    /**
     * Question : https://leetcode.com/explore/featured/card/june-leetcoding-challenge/541/week-3-june-15th-june-21st/3364/
     */
    class Solution {
        public int hIndex(int[] citations) {

            if (citations.length == 0) return 0;

            int n = citations.length, l = 0, r = n - 1;

            while (l <= r) {
                int m = l + (r - l) / 2;
                if (citations[m] < (n - m)) l = m + 1;
                else r = m - 1;
            }

            return n - l;
        }
    }
}
