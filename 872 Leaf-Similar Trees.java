/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
// If we want to check valid root, we may need to use if (n == null) return;
class Solution {
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> l1 = new ArrayList<>();
        List<Integer> l2 = new ArrayList<>();
        addLeaves(root1, l1);
        addLeaves(root2, l2);
        return l1.equals(l2);
    }
    public void addLeaves(TreeNode n, List l) {
        if (n.left == null && n.right == null) l.add(n.val);
        else {
            if (n.left != null) addLeaves(n.left, l);
            if (n.right != null) addLeaves(n.right, l);
        }
    }
}