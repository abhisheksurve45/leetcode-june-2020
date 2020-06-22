public class SingleNumberII {

    /**
     * Question : https://leetcode.com/explore/featured/card/june-leetcoding-challenge/542/week-4-june-22nd-june-28th/3368/
     * Video : https://www.youtube.com/watch?v=REBZXGjVvMM
     */
    class Solution {
        public int singleNumber(int[] nums) {
            int res = 0;
            int sum, mask;

            for (int i = 0; i < 32; i++) {
                mask = (1 << i);
                sum = 0;
                for (int n : nums) {
                    if ((n & mask) != 0) sum++;
                }
                if (sum % 3 != 0) res |= mask;
            }

            return res;
        }
    }
}
