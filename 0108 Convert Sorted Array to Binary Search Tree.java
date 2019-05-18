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
    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums == null || nums.length == 0) return null;
        if(nums.length == 1) return new TreeNode(nums[0]);
        return getTreeNode(nums, 0, nums.length - 1);
    }
    public TreeNode getTreeNode(int[] nums, int start, int end) {
        if(start > end) return null;
        int mid = start + (end - start) / 2;
        TreeNode r = new TreeNode(nums[mid]);
        r.left = getTreeNode(nums, start, mid - 1);
        r.right = getTreeNode(nums, mid + 1, end);
        return r;
    }
}