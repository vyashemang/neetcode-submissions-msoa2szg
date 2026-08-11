/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    public int goodNodes(TreeNode root) {
        int res = 1;

        return helper(root, root.val);
    }

    private int helper(TreeNode root, int maxValue) {
        if (root == null) {
            return 0;
        }

        return (root.val >= maxValue ? 1 : 0) + helper(root.left, Math.max(maxValue, root.val)) + helper(root.right, Math.max(maxValue, root.val));
    }
}
