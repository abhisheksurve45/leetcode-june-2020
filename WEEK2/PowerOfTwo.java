public class PowerOfTwo {

    /**
     * Link for reference : https://leetcode.com/problems/power-of-two/discuss/676846/Math-or-Bit-or-Recursive-or-1-Line-Code-or-Detailed-Explanations
     */
    class Solution {
        public boolean isPowerOfTwo(int n) {
            return n > 0 && ((n & (n-1)) == 0);
        }
    }
}
