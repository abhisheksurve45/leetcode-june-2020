public class InsertDeleteGetRandom {

    /**
     * Question : https://leetcode.com/explore/featured/card/june-leetcoding-challenge/540/week-2-june-8th-june-14th/3358/
     * Reference : https://leetcode.com/problems/insert-delete-getrandom-o1/discuss/85425/Java-Solution-(Beats-99.20)-Using-HashMap-and-ArrayList-with-Explanation
     */
    class RandomizedSet {

        List<Integer> list;
        Map<Integer, Integer> map;
        int ind = 0;

        /**
         * Initialize your data structure here.
         */
        public RandomizedSet() {
            list = new ArrayList<>();
            map = new HashMap<>();
        }

        /**
         * Inserts a value to the set. Returns true if the set did not already contain the specified element.
         */
        public boolean insert(int val) {
            if (map.containsKey(val)) return false;
            list.add(val);
            map.put(val, list.size() - 1);
            return true;
        }

        /**
         * Removes a value from the set. Returns true if the set contained the specified element.
         */
        public boolean remove(int val) {
            int ind = map.getOrDefault(val, -1);
            if (ind == -1) return false;
            Collections.swap(list, ind, list.size() - 1);
            int swappedWith = list.get(ind);
            map.put(swappedWith, ind);
            list.remove(list.size() - 1);
            map.remove(val);
            return true;
        }

        /**
         * Get a random element from the set.
         */
        public int getRandom() {
            int max = list.size();
            int min = 0;
            int ind = (int) (Math.random() * (max - min) + min);
            return list.get(ind);
        }
    }

    /**
     * Your RandomizedSet object will be instantiated and called as such:
     * RandomizedSet obj = new RandomizedSet();
     * boolean param_1 = obj.insert(val);
     * boolean param_2 = obj.remove(val);
     * int param_3 = obj.getRandom();
     */
}
