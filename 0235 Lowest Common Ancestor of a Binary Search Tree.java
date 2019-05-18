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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return root;
        if (p.val < root.val && q.val < root.val)
            return lowestCommonAncestor(root.left, p, q);
        if (p.val > root.val && q.val > root.val)
            return lowestCommonAncestor(root.right, p, q);
        return root;
    }
}

/* A much faster solution:
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if ((root.val - p.val) * (root.val - q.val) < 1) return root; // 在不同邊的話，一邊是>=0，另一邊<=0，相乘為負或0，用<1來判斷比<=0還快。
        if (p.val < root.val)	// 同邊且在左邊
            return lowestCommonAncestor(root.left, p, q);
        return lowestCommonAncestor(root.right, p, q); //同邊且在右邊
    }
}
*/