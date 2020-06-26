public class SumRoottoLeafNumbers {
    /**
     * Question : https://leetcode.com/explore/featured/card/june-leetcoding-challenge/542/week-4-june-22nd-june-28th/3372/
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
        public int sumNumbers(TreeNode root) {
            return sumNumbers(root, 0);
        }

        public int sumNumbers(TreeNode node, int sum) {
            if (node == null) return 0;
            if (node.left == null && node.right == null) return sum * 10 + node.val;
            return sumNumbers(node.left, sum * 10 + node.val) + sumNumbers(node.right, sum * 10 + node.val);
        }

    }
}
