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
    // index 0: depth, index 1: parent's val
    int[] x_vars = new int[2];
    int[] y_vars = new int[2];
    public boolean isCousins(TreeNode root, int x, int y) {
        if (x == root.val || y == root.val) return false;
        
        helper(root, x, x_vars, 0, 0);
        helper(root, y, y_vars, 0, 0);
        
        if (x_vars[0] == y_vars[0] && x_vars[1] != y_vars[1]) return true;
        
        return false;
    }
    public boolean helper(TreeNode ite, int t, int[] vars, int prev, int depth) {
        if (ite == null) return false;
        if (t == ite.val) {
            vars[0] = depth;
            vars[1] = prev;
            return true;
        }
        return helper(ite.left, t, vars, ite.val, 1+depth) || helper(ite.right, t, vars, ite.val, 1+depth);
    }
}


/* BFS solution(iterative) from Klaus2code
class Solution {
    public static boolean isCousins(TreeNode root, int x, int y) {
        if(root == null) return false;
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode xParent = null, yParent = null;
        queue.offer(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            while(size > 0){
                TreeNode node = queue.poll();
                if(node.left != null){
                    queue.offer(node.left);
                    if(node.left.val == x) xParent = node;
                    if(node.left.val == y) yParent = node;
                }
                if(node.right != null){
                    queue.offer(node.right);
                    if(node.right.val == x) xParent = node;
                    if(node.right.val == y) yParent = node;
                }
                --size;
                if(xParent != null && yParent != null) break;
            }
            if(xParent != null && yParent != null) return xParent != yParent;
            if((xParent != null && yParent == null) || 
               (xParent == null && yParent != null)) return false;
            
        }
        return false;
    }
}
*/