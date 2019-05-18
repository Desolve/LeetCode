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
    public boolean findTarget(TreeNode root, int k) {
        return dfs(root, k, root);
    }
    public boolean dfs(TreeNode n, int k, TreeNode root) {
        if (n == null) return false;
        return dfs(n.left, k, root) || getResult(root, k, n) || dfs(n.right, k, root);
    }
    public boolean getResult(TreeNode root, int k, TreeNode n) {
        int remain = k - n.val;
        while (root != null) {
            if (remain == root.val && root.val != n.val) return true;
            else if (remain > root.val) root = root.right;
            else root = root.left;
        }
        return false;
    }
}

/* Two-stacks solution
class Solution {
    public boolean findTarget(TreeNode root, int k) {
        Stack<TreeNode> stackL = new Stack<TreeNode>();  // iterator 1 that gets next smallest value
        Stack<TreeNode> stackR = new Stack<TreeNode>();  // iterator 2 that gets next largest value
        
        for(TreeNode cur = root; cur != null; cur = cur.left)  
            stackL.push(cur);
        for(TreeNode cur = root; cur != null; cur = cur.right)  
            stackR.push(cur);
            
        while(stackL.size() != 0 && stackR.size() != 0 && stackL.peek() != stackR.peek()){
            int tmpSum = stackL.peek().val + stackR.peek().val;
            if(tmpSum == k)  return true;
            else if(tmpSum < k)
                for(TreeNode cur = stackL.pop().right; cur != null; cur = cur.left) 
                    stackL.push(cur);
            else
                for(TreeNode cur = stackR.pop().left; cur != null; cur = cur.right) 
                    stackR.push(cur);
        }
        
        return false;
    }
}
*/