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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int[] pre = new int[1], in = new int[1];
        pre[0] = 0;
        in[0] = 0;
        return build(preorder, pre, inorder, in, null);
    }
    public TreeNode build(int[] preorder, int[] pre, int[] inorder, int[] in, TreeNode res) {
        if (pre[0] == preorder.length || (res != null && inorder[in[0]] == res.val)) return null;
        TreeNode root = new TreeNode(preorder[pre[0]++]);
        root.left = build(preorder, pre, inorder, in, root);
        in[0]++;
        root.right = build(preorder, pre, inorder, in, res);            
        return root;
    }
}
/* Iterative solution from opmiss
class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (inorder.length==0) return null; 
        Stack<TreeNode> stack = new Stack<TreeNode>(); 
        TreeNode root = new TreeNode(Integer.MIN_VALUE);
        stack.push(root); 
        int i=0, j=0;
        TreeNode node = null; 
        TreeNode cur = root; 
        while (j<inorder.length){
            if (stack.peek().val == inorder[j]){
                node = stack.pop(); 
                j++; 
            }
            else if (node!=null){
                cur = new TreeNode(preorder[i]); 
                node.right = cur;
                node=null; 
                stack.push(cur); 
                i++; 
            }
            else {
                cur = new TreeNode(preorder[i]); 
                stack.peek().left = cur; 
                stack.push(cur);
                i++; 
            }
        }
        return root.left; 
    }
}
*/