public class ReconstructItinerary {

    /**
     * Question : https://leetcode.com/explore/featured/card/june-leetcoding-challenge/542/week-4-june-22nd-june-28th/3374/
     */
    class Solution {
        Map<String, PriorityQueue<String>> graph;
        List<String> result;

        public List<String> findItinerary(List<List<String>> tickets) {
            result = new ArrayList<>();
            graph = new HashMap<>();

            for (List<String> ticket : tickets) {
                String from = ticket.get(0);
                String to = ticket.get(1);
                if (!graph.containsKey(from)) graph.put(from, new PriorityQueue<>());
                graph.get(from).offer(to);
            }

            dfs("JFK");
            return result;
        }


        private void dfs(String from) {
            PriorityQueue<String> to = graph.get(from);
            while (to != null && !to.isEmpty()) dfs(to.poll());
            result.add(0, from);
        }
    }
}
