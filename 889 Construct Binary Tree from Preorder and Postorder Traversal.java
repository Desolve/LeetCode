/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
// Inpired from Big_News
class Solution {
    public TreeNode constructFromPrePost(int[] pre, int[] post) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < post.length; ++i) map.put(post[i], i);
        return build(pre, 0, pre.length - 1, post, 0, post.length - 1, map);
    }
    public TreeNode build(int[] pre, int s1, int e1, int[] post, int s2, int e2, Map<Integer, Integer> map) {
        if (s1 > e1 || s2 > e2) return null;
        TreeNode res = new TreeNode(pre[s1]);
        if (s1 == e1) return res;
        int i = map.get(pre[s1 + 1]);
        res.left = build(pre, s1 + 1, s1 + 1 + i - s2, post, s2, i, map);
        res.right = build(pre, s1 + 1 + i - s2 + 1, e1, post, i + 1, e2, map);
        return res;
    }
}