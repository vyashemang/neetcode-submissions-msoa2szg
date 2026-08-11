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

    int res = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        postOrder(root);
        return res;
    }

    private int postOrder(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = Math.max(postOrder(root.left), 0);
        int right = Math.max(postOrder(root.right), 0);

        int curr = root.val + Math.max(left, right);

        res = Math.max(res, root.val + left + right);
        
        return curr;
    }
}
