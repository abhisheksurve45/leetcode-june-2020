public class CountCompleteTreeNodes {

    /**
     * Question : https://leetcode.com/explore/featured/card/june-leetcoding-challenge/542/week-4-june-22nd-june-28th/3369/
     */
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode() {}
     * TreeNode(int val) { this.val = val; }
     * TreeNode(int val, TreeNode left, TreeNode right) {
     * this.val = val;
     * this.left = left;
     * this.right = right;
     * }
     * }
     */
    class Solution {
        public int countNodes(TreeNode root) {
            if (root == null) return 0;
            return 1 + countNodes(root.left) + countNodes(root.right);
        }
    }
}
