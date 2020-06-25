public class FindDuplicateNumber {
    /**
     * Question : https://leetcode.com/explore/featured/card/june-leetcoding-challenge/542/week-4-june-22nd-june-28th/3371/
     * Reference : https://leetcode.com/problems/find-the-duplicate-number/solution/
     */
    class Solution {
        public int findDuplicate(int[] nums) {
            int tortoise = nums[0];
            int hare = nums[0];
            do {
                tortoise = nums[tortoise];
                hare = nums[nums[hare]];
            } while (tortoise != hare);

            tortoise = nums[0];
            while (tortoise != hare) {
                tortoise = nums[tortoise];
                hare = nums[hare];
            }

            return hare;

        }
    }
}
