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
    int preIdx = 0;
    HashMap<Integer, Integer> m = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for (int i = 0; i < inorder.length; i++) {
            m.put(inorder[i], i);
        }    

        return helper(preorder, 0, inorder.length - 1);
    }

    private TreeNode helper(int[] preorder, int l, int r) {
        if (l > r) return null;

        int rootVal = preorder[preIdx++];

        TreeNode root = new TreeNode(rootVal);

        int rootInorderIdx = m.get(rootVal);

        root.left = helper(preorder, l, rootInorderIdx - 1);
        root.right = helper(preorder, rootInorderIdx + 1, r);

        return root;

    }
}
