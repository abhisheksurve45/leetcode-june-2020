public class LargestDivisibleSubset {

    /**
     * Question : https://leetcode.com/explore/featured/card/june-leetcoding-challenge/540/week-2-june-8th-june-14th/3359/
     * Reference : https://leetcode.com/problems/largest-divisible-subset/discuss/684740/Detailed-4-step-dp-solution-or-flow-diagram
     * Video :
     */
    class Solution {
        public List<Integer> largestDivisibleSubset(int[] nums) {
            List<Integer> result = new ArrayList<>();
            if (nums.length == 0) return result;

            int n = nums.length;

            Arrays.sort(nums);

            int[] count = new int[n];
            Arrays.fill(count, 1);

            for (int i = 1; i < n; i++) {
                for (int j = i - 1; j >= 0; j--) {
                    if (nums[i] % nums[j] == 0) count[i] = Math.max(count[i], count[j] + 1);
                }
            }

            int maxCountIndex = 0;
            for (int i = 1; i < n; i++) {
                maxCountIndex = count[i] > count[maxCountIndex] ? i : maxCountIndex;
            }

            int temp = nums[maxCountIndex];
            int currentCount = count[maxCountIndex];
            for (int i = maxCountIndex; i >= 0; i--) {
                if (temp % nums[i] == 0 && count[i] == currentCount) {
                    result.add(nums[i]);
                    temp = nums[i];
                    currentCount--;
                }
            }

            return result;
        }
    }
}
