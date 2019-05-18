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
    public int pathSum(TreeNode root, int sum) {
        if (root == null) return 0;
        return sumFrom(root, sum) + pathSum(root.left, sum) + pathSum(root.right, sum);
    }
    public int sumFrom(TreeNode node, int sum) {
        if (node == null) return 0;
        return (node.val == sum ? 1 : 0) + sumFrom(node.left, sum - node.val) + sumFrom(node.right, sum - node.val);
    }
}

/* Solution Using prefix sums
class Solution {
    public int pathSum(TreeNode root, int sum) {
        HashMap<Integer, Integer> preSum = new HashMap();
        preSum.put(0, 1);       // 整條路徑剛好到現在這個node為止總和和sum一樣的話取値在HashMap內就是(0, 1)
        return helper(root, 0, sum, preSum);
    }
    public int helper(TreeNode root, int currSum, int target, HashMap<Integer, Integer> preSum) {
        if (root == null) return 0;
        currSum += root.val;
        // 假設一條路徑 Root->...->A->...->Node, 因為我們記錄了Root到A的和能達成的對應總次數x，當我們走到Node時，
        // 如果發現r = currSum - target存在的話，代表扣掉r的狀況我們也有x種方式得到target。
        int res = preSum.getOrDefault(currSum - target, 0); 
        preSum.put(currSum, preSum.getOrDefault(currSum, 0) + 1);
        res += helper(root.left, currSum, target, preSum) + helper(root.right, currSum, target, preSum);
        preSum.put(currSum, preSum.get(currSum) - 1); // 最後要將已經走過的部分去掉避免重複
        return res;
    }
}
*/