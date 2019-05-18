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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int[] in = new int[1], po = new int[1];
        po[0] = postorder.length - 1;
        in[0] = inorder.length - 1;        
        return build(inorder, in, postorder, po, null);
    }
    public TreeNode build(int[] inorder, int[] in, int[] postorder, int[] po, TreeNode res) {
        if (po[0] < 0 || (res != null && inorder[in[0]] == res.val)) return null; // end of recursion 
        TreeNode root = new TreeNode(postorder[po[0]--]);
        root.right = build(inorder, in, postorder, po, root);
        in[0]--;
        root.left = build(inorder, in, postorder, po, res);        
        return root;
    }
}
/* Iterative solution from mayijie88
public TreeNode buildTree(int[] inorder, int[] postorder) {
    if (inorder.length == 0 || postorder.length == 0) return null;
    int ip = inorder.length - 1;
    int pp = postorder.length - 1;
    
    Stack<TreeNode> stack = new Stack<TreeNode>();
    TreeNode prev = null;
    TreeNode root = new TreeNode(postorder[pp]);
    stack.push(root);
    pp--;
    
    while (pp >= 0) {
        while (!stack.isEmpty() && stack.peek().val == inorder[ip]) {
            prev = stack.pop();
            ip--;
        }
        TreeNode newNode = new TreeNode(postorder[pp]);
        if (prev != null) {
            prev.left = newNode;
        } else if (!stack.isEmpty()) {
            TreeNode currTop = stack.peek();
            currTop.right = newNode;
        }
        stack.push(newNode);
        prev = null;
        pp--;
    }
    
    return root;
}
*/