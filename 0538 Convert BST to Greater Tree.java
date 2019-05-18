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
    int adder = 0;
    public TreeNode convertBST(TreeNode root) {
        reverseInorder(root);
        return root;
    }
    public void reverseInorder(TreeNode root) {
        if (root == null) return;
        reverseInorder(root.right);
        root.val += adder;
        adder = root.val;
        reverseInorder(root.left);
    }
}

/* If no extra variable
class Solution {
    public TreeNode convertBST(TreeNode root) {
        count(root,0);
        return root;       
    }
    public int count(TreeNode root,int num){
        if(root!=null){
            num=count(root.right,num);
            root.val+=num;
            num=root.val;
            num=count(root.left,num);
        }
        return num;
    }
}
*/