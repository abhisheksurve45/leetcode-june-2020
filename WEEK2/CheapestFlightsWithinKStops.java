public class CheapestFlightsWithinKStops {

    /**
     * Question : https://leetcode.com/explore/featured/card/june-leetcoding-challenge/540/week-2-june-8th-june-14th/3360/
     * Video : https://www.youtube.com/watch?v=o6dUXOk-GWQ
     */
    class Solution {
        public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {

            int minPathCost = Integer.MAX_VALUE;
            Map<Integer, List<int[]>> flightGraph = buildGraph(flights);

            int step = 0;

            Queue<int[]> q = new LinkedList<>();
            q.add(new int[]{src, 0});

            while (!q.isEmpty()) {

                int size = q.size();
                for (int i = 0; i < size; i++) {

                    int[] currentStop = q.poll();

                    if (currentStop[0] == dst)
                        minPathCost = Math.min(minPathCost, currentStop[1]);

                    if (!flightGraph.containsKey(currentStop[0])) {
                        continue;
                    }

                    for (int[] flight : flightGraph.get(currentStop[0])) {

                        if (currentStop[1] + flight[1] > minPathCost)
                            continue;

                        q.add(new int[]{flight[0], currentStop[1] + flight[1]});
                    }

                }

                if (step++ > K) break;
            }

            return minPathCost == Integer.MAX_VALUE ? -1 : minPathCost;
        }

        private Map<Integer, List<int[]>> buildGraph(int[][] flights) {
            Map<Integer, List<int[]>> flightGraph = new HashMap<>();

            for (int[] f : flights) {
                flightGraph.putIfAbsent(f[0], new ArrayList<>());
                flightGraph.get(f[0]).add(new int[]{f[1], f[2]});
            }

            return flightGraph;
        }
    }
}
