/* Add to Queue(Using LinkedList), poll and add the same level's nodes to the list, and add to result one level at a time.*/
class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(root == null) return res;
        Queue<TreeNode> levelQ = new LinkedList<>();
        levelQ.add(root);
        while(q.size() > 0) {
            List<Integer> level = new LinkedList<>();
            int size = q.size();
            for(int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                level.add(node);
                if(node.left != null) q.add(node.left);
                if(node.right != null) q.add(node.right);
            }
            res.add(0, level);
        }
        return res;
    }
}
/* Visit by level 
class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        visit(root, res, 0);
        Collections.reverse(res);
        return res;        
    }
    public void visit(TreeNode node, List<List<Integer>> res, int level) {
        if(node == null)
            return;
        if(res.size() < level + 1)
            res.add(new ArrayList<Integer>());
        res.get(level).add(node.val);
        visit(node.left, res, level+1);
        visit(node.right, res, level+1);
    }
}
*/