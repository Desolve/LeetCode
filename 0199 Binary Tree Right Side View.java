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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new LinkedList<>();
        if (root == null) return res;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            TreeNode last = null;
            int cnt = q.size();
            for (int i = 0; i < cnt; ++i) {
                last = q.poll();
                if (last.left != null) q.offer(last.left);
                if (last.right != null) q.offer(last.right);
            }
            res.add(last.val);
        }
        return res;
    }
}