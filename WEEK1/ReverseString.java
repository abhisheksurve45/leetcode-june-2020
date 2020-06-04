public class ReverseString {

    /**
     * Question : https://leetcode.com/explore/featured/card/june-leetcoding-challenge/539/week-1-june-1st-june-7th/3350/
     */
    class Solution {
        public void reverseString(char[] s) {
            int n = s.length;
            for(int i=0; i < n/2; i++){
                char temp = s[i];
                s[i] = s[n-i-1];
                s[n-i-1] = temp;
            }
        }
    }
}
