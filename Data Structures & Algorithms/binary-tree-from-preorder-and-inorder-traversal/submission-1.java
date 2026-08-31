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
    int preIndex = 0;
    Map<Integer, Integer> m = new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = preorder.length;

        for (int i = 0; i < n; i++) {
            m.put(inorder[i], i);
        }

        return helper(preorder, 0, n - 1);
    }

    private TreeNode helper(int[] preorder, int l, int r) {

        if (l > r) {
            return null;
        }

        int rootVal = preorder[preIndex++];

        TreeNode root = new TreeNode(rootVal);

        int inorderIdx = m.get(rootVal);

        root.left = helper(preorder, l, inorderIdx - 1);
        root.right = helper(preorder, inorderIdx + 1, r);

        return root;
    } 
}
