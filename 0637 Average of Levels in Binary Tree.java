/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
// BFS
class Solution {
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> res = new LinkedList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            int cnt = q.size();
            Double sum = 0.0;
            for (int i = 0; i < cnt; ++i) {
                TreeNode node = q.poll();
                sum += node.val;
                if (node.left != null) q.offer(node.left);
                if (node.right != null) q.offer(node.right);
            }
            res.add(sum / cnt);
        }
        return res;
    }
}

// DFS
/*
class Solution {
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> res = new LinkedList<>();
        List<Double> sum = new ArrayList<>();
        List<Integer> cnt = new ArrayList<>();
        helper(root, sum, cnt, 0);
        for (int i = 0; i < sum.size(); ++i) {
            res.add((double)sum.get(i) / cnt.get(i));
        }
        return res;        
    }
    public void helper(TreeNode root, List<Double> sum, List<Integer> cnt, int level) {
        if (root == null) return;
        if (level == sum.size()) {
            sum.add(level, (double)root.val);
            cnt.add(level, 1);
        } else {
            sum.set(level, (double)sum.get(level) + root.val);
            cnt.set(level, cnt.get(level) + 1);
        }
        helper(root.left, sum, cnt, level + 1);
        helper(root.right, sum, cnt, level + 1);
    }
}
*/
// Faster DFS using a class to integrate sums and counts
/*
class Solution {
    class Node {
        double sum;
        int count;
        Node (double d, int c) {
            sum = d;
            count = c;
        }
    }
    public List<Double> averageOfLevels(TreeNode root) {
        List<Node> temp = new ArrayList<>();
        helper(root, temp, 0);
        List<Double> result = new LinkedList<>();
        for (int i = 0; i < temp.size(); i++) {
            result.add(temp.get(i).sum / temp.get(i).count);
        }
        return result;
    }
    public void helper(TreeNode root, List<Node> temp, int level) {
        if (root == null) return;
        if (level == temp.size()) {
            Node node = new Node((double)root.val, 1);
            temp.add(node);
        } else {
            temp.get(level).sum += root.val;
            temp.get(level).count++;
        }
        helper(root.left, temp, level + 1);
        helper(root.right, temp, level + 1);
    }
}
*/