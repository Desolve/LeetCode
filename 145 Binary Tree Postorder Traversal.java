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
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        postorder(root, res);
        return res;
    }
    public void postorder(TreeNode root, List<Integer> res) {
        if (root == null) return;
        postorder(root.left, res);
        postorder(root.right, res);
        res.add(root.val);
    }
}

/* Iterative solution using Deque
// We want the order: left->right->root, so we need to addFirst in the order of visit left -> visit right -> add root val
class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Deque<Opt> path = new ArrayDeque<>();
        if (root != null) {
            path.add(new Opt(root, 1));
            while(!path.isEmpty()) {
                Opt n = path.removeFirst();
                if (n.node == null) continue;
                if (n.opt == 0) {
                    res.add(n.node.val);
                } else {
                    path.addFirst(new Opt(n.node, 0));
                    path.addFirst(new Opt(n.node.right, 1));
                    path.addFirst(new Opt(n.node.left, 1));
                }
            }
        }
        return res;
    }
}
class Opt{
    int opt; // 0 : add, 1 : visit
    TreeNode node;
    public Opt(TreeNode node, int opt) {
        this.opt = opt;
        this.node = node;
    }
}
*/