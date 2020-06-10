public class SearchInsertPosition {

    /**
     * Problem : https://leetcode.com/explore/featured/card/june-leetcoding-challenge/540/week-2-june-8th-june-14th/3356/
     */
    class Solution {
        public int searchInsert(int[] A, int target) {
            int low = 0, high = A.length-1;
            while(low<=high){
                int mid = (low+high)/2;
                if(A[mid] == target) return mid;
                else if(A[mid] > target) high = mid-1;
                else low = mid+1;
            }
            return low;
        }
    }
}
