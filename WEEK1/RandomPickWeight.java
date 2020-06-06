public class RandomPickWeight {
    class Solution {

        int[] w_sum;
        public Solution(int[] w) {
            w_sum = new int[w.length];
            int sum = 0;
            for(int i = 0; i < w.length; i++){
                sum += w[i];
                w_sum[i] = sum;
            }

            for(int i = 0; i < w.length; i++){
                System.out.print(w_sum[i]);

            }
        }

        public int pickIndex() {
            double target = w_sum[w_sum.length - 1] * Math.random();
            for(int i = 0; i < w_sum.length; i++){
                if(target < w_sum[i]) return i;
            }
            return -1;
        }
    }

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */
}
