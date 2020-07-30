/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode bstFromPreorder(int[] preorder) {
        if (preorder == null || preorder.length == 0) return null;
        return build(preorder, 0, preorder.length - 1);
    }
    public TreeNode build(int[] preorder, int l, int r) {
        if (l > r) return null;
        TreeNode root = new TreeNode(preorder[l]);
        int i = l + 1;
        while (i <= r && preorder[i] < preorder[l]) ++i;
        root.left = build(preorder, l + 1, i - 1);
        root.right = build(preorder, i, r);
        return root;
    }
}

/* O(N) Solution from lee215

class Solution {
    int i = 0;
    public TreeNode bstFromPreorder(int[] preorder) {
        if (preorder == null || preorder.length == 0) return null;
        return build(preorder, Integer.MAX_VALUE);
    }
    public TreeNode build(int[] preorder, int bound) {
        if (i == preorder.length || preorder[i] > bound) return null;
        TreeNode root = new TreeNode(preorder[i++]);
        root.left = build(preorder, root.val);
        root.right = build(preorder, bound);
        return root;
    }
}

*/