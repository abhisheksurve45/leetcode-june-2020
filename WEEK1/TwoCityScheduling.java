public class TwoCityScheduling {


    /**
     * Question : https://leetcode.com/explore/featured/card/june-leetcoding-challenge/539/week-1-june-1st-june-7th/3349/
     * Link for reference : https://leetcode.com/problems/two-city-scheduling/discuss/278898/Java-2ms-sorting-solution-with-explanation
     */
    class Solution {
        public int twoCitySchedCost(int[][] costs) {
            Arrays.sort(costs, new Comparator<int[]>() {
                public int compare(int[] a, int[] b) {
                    return (a[1] - a[0]) - (b[1] - b[0]);
                }
            });
            int cost = 0;
            for (int i = 0; i < costs.length / 2; i++) {
                cost += costs[i][1] + costs[costs.length-i-1][0];
            }
            return cost;
        }
    }

}
