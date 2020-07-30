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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        return preorder(root, 0, res);
    }
    
    public List<List<Integer>> preorder(TreeNode node, int level, List<List<Integer>> res) {
        if (node == null) {
            return res;
        }
        
        List<Integer> tmp = null;
        if (res.size() == level) {
            tmp = new ArrayList<Integer>();
            res.add(tmp);        
        } else {
            tmp = res.get(level);
        }
        tmp.add(node.val);
        preorder(node.left, level + 1, res);
        preorder(node.right, level + 1, res);
        return res;
    }
}

/*
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        List<Integer> zero = new ArrayList<>();
        zero.add(root.val);
        res.add(zero);
        levelOrder(root.left, res, 1);
        levelOrder(root.right, res, 1);
        return res;
    }
    public void levelOrder(TreeNode n, List<List<Integer>> res, int level) {
        if (n == null) return;
        if (level > res.size() - 1) {
            List<Integer> lvl = new ArrayList<>();
            lvl.add(n.val);
            res.add(lvl);
        } else {
            res.get(level).add(n.val);
        }
        levelOrder(n.left, res, level + 1);
        levelOrder(n.right, res, level + 1);
    }
}
*/
/* Iterative solution (BFS)
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null)
            return res;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()) {
            int levelSize = q.size();
            List<Integer> currLevel = new ArrayList<>();
            for(int i = 0; i < levelSize; i++) {
                TreeNode currNode = q.poll();
                currLevel.add(currNode.val);
                if (currNode.left != null)
                    q.add(currNode.left);
                if (currNode.right != null)
                    q.add(currNode.right);
            }
            res.add(currLevel);
        }
        return res;
    }
}
*/