public class SortColors {

    /**
     * Problem : https://leetcode.com/explore/featured/card/june-leetcoding-challenge/540/week-2-june-8th-june-14th/3357/
     * Link for reference : https://www.techiedelight.com/sort-array-containing-0s-1s-2s-dutch-national-flag-problem/
     */
    class Solution {
        public void sortColors(int[] nums) {
            int low = 0, mid = 0, high = nums.length - 1, temp;
            while (mid <= high) {
                if (nums[mid] == 0) {
                    temp = nums[mid];
                    nums[mid] = nums[low];
                    nums[low] = temp;
                    mid++;
                    low++;
                } else if (nums[mid] == 2) {
                    temp = nums[high];
                    nums[high] = nums[mid];
                    nums[mid] = temp;
                    high--;
                } else {
                    mid++;
                }
            }
        }
    }
}
