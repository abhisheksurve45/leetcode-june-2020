public class TwoCityScheduling {


    /**
     * Question : https://leetcode.com/explore/featured/card/june-leetcoding-challenge/539/week-1-june-1st-june-7th/3349/
     * Link for reference : https://leetcode.com/problems/two-city-scheduling/discuss/278898/Java-2ms-sorting-solution-with-explanation
     */
    class Solution {
        public int twoCitySchedCost(int[][] costs) {
            Arrays.sort(costs, (a, b) -> {
                return a[0] - a[1] - (b[0] - b[1]);
            });

            int sum = 0;
            for (int i = 0; i < costs.length; i++) {
                if (i < costs.length / 2) {
                    sum += costs[i][0];
                } else {
                    sum += costs[i][1];
                }
            }
            return sum;
        }
    }

}
