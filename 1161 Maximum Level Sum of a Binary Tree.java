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
    public int maxLevelSum(TreeNode root) {
        int level = 1, res = 1, maxSum = Integer.MIN_VALUE;
        Queue<TreeNode> q = new ArrayDeque<TreeNode>();
        q.offer(root);
        while (!q.isEmpty()) {            
            int sum = 0;            
            for (int cnt = q.size(); cnt > 0; --cnt) {
                TreeNode n = q.poll();
                sum += n.val;
                if (n.left != null) q.offer(n.left);
                if (n.right != null) q.offer(n.right);
            }
            
            if (sum > maxSum) {
                maxSum = sum;
                res = level;
            }
            
            ++level;
        }
        return res;
    }
}