// 9ms solution
class Solution {
    public boolean isSymmetric(TreeNode root) {
        return root == null ? true : isSymmetric(root.left, root.right);
    }

    public boolean isSymmetric(TreeNode l, TreeNode r) {
        return l == r || (l != null && r != null && l.val == r.val && isSymmetric(l.left, r.right) && isSymmetric(l.right, r.left));
    }
}

/* 11 ms solution
class Solution {
    public boolean dfs(TreeNode l, TreeNode r) {
        if (l == null || r == null)
            return (l == r);
        if (l.val == r.val) {
            return dfs(l.left, r.right) && dfs(l.right, r.left);
        }
        return false;
    }
    public boolean isSymmetric(TreeNode root) {
        if(root == null)
            return true;
        return dfs(root.left, root.right);
    }
}*/