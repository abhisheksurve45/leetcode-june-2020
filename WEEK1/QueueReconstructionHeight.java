public class QueueReconstructionHeight {

    /**
     * Link for reference : https://leetcode.com/problems/queue-reconstruction-by-height/discuss/672958/Problem-Explanation-or-Detailed-Steps-Solution-or-Simple-or-Using-Sorting
     */
    class Solution {
        public int[][] reconstructQueue(int[][] people) {
            Arrays.sort(people, (p1, p2) -> p1[0] == p2[0] ? p1[1] - p2[1] : p2[0] - p1[0]);
            List<int[]> list = new ArrayList<>();
            for (int i = 0; i < people.length; i++) {
                list.add(people[i][1], people[i]);
            }
            return list.toArray(people);
        }
    }
}
