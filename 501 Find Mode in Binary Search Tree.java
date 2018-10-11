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
    public int[] findMode(TreeNode root) {
        if (root == null) return new int[]{};
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        Stack<TreeNode> st = new Stack<TreeNode>();
        st.push(root);
        int max = 0;
        while (!st.empty()) {
            TreeNode node = st.pop();
            int cnt = map.getOrDefault(node.val, 0)+1;
            max = Math.max(max, cnt);
            map.put(node.val, cnt);
            if (node.left != null) st.push(node.left);
            if (node.right != null) st.push(node.right);
        }
        List<Integer> res = new ArrayList<>();
        for(Map.Entry<Integer, Integer> entry: map.entrySet())
            if (entry.getValue() == max)
                res.add(entry.getKey());        
        int[] ans = new int[res.size()];
        for (int i = 0; i < res.size(); ++i) ans[i] = res.get(i);
        return ans;
    }
}

/* Better solution:
由於是BST的關係，可以保證除了root以外，每次先走左側時，右側不會出現左側出現過的element,
所以一旦遇到數到超過max的狀況，就表示最大値要更新了，必須把list整個洗掉。

class Solution {
    Integer prev = null;
    int count = 1;
    int max = 0;
    public int[] findMode(TreeNode root) {
        if (root == null) return new int[0];
        
        List<Integer> list = new ArrayList<>();
        traverse(root, list);
        
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); ++i) res[i] = list.get(i);
        return res;
    }
    
    private void traverse(TreeNode root, List<Integer> list) {
        if (root == null) return;
        traverse(root.left, list);
        if (prev != null) {
            if (root.val == prev)
                count++;
            else
                count = 1;
        }
        if (count > max) {
            max = count;
            list.clear();
            list.add(root.val);
        } else if (count == max) {
            list.add(root.val);
        }
        prev = root.val;
        traverse(root.right, list);
    }
}
*/