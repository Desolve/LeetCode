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
    public static List<String> res;
    public List<String> binaryTreePaths(TreeNode root) {
        res = new ArrayList<String>();
        String path = "";
        binaryTreePaths(root, path);
        return res;
    }
    public void binaryTreePaths(TreeNode root, String path) {
        if (root == null) return;
        if (path.equals(""))
            path += String.valueOf(root.val);
        else
            path += "->" + String.valueOf(root.val);
        if (root.left == null && root.right == null) {
            res.add(path);
            return;
        }
        binaryTreePaths(root.left, path);
        binaryTreePaths(root.right, path);
    }    
}