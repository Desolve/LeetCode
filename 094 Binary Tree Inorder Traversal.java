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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        inorder(root, res);
        return res;
    }
    public void inorder(TreeNode root, List<Integer> res) {
        if (root == null) return;
        inorder(root.left, res);
        res.add(root.val);
        inorder(root.right, res);
    }
}
/* Go through the left nodes, then the root, then the right.
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root != null) {            
            Stack<TreeNode> st = new Stack<>();
            TreeNode ite = root;
            while (ite != null || !st.empty()) {
                while (ite != null) {
                    st.push(ite);
                    ite = ite.left;
                }
                ite = st.pop();
                res.add(ite.val);
                ite = ite.right;
            }
        }
        return res;
    }
}
*/


/* Using Deque (slow)
class Solution {
    class Opt {
        int opt; // 0: visit, 1: add
        TreeNode n;
        Opt(int opt, TreeNode n) {
            this.opt = opt;
            this.n = n;
        }
    }
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root != null) {            
            Deque<Opt> q = new ArrayDeque<>();
            q.offer(new Opt(0, root));
            while (!q.isEmpty()) {
                Opt step = q.poll();
                if (step.opt == 1) {
                    res.add(step.n.val);
                } else {                    
                    if (step.n.right != null) q.addFirst(new Opt(0, step.n.right));
                    q.addFirst(new Opt(1, step.n));                    
                    if (step.n.left != null) q.addFirst(new Opt(0, step.n.left));
                }
            }            
        }
        return res;
    }
}
*/