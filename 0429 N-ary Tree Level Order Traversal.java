/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val,List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/
class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> res = new LinkedList<>();        
        if (root == null) return res;        
        Queue<Node> q = new LinkedList<>();
        q.offer(root);
        
        while (!q.isEmpty()) {
            List<Integer> curLevel = new LinkedList<>();
            int len = q.size();
            for (int i = 0; i < len; i++) {
                Node ite = q.poll();
                curLevel.add(ite.val);
                for (Node c: ite.children)
                    q.offer(c);
            }
            res.add(curLevel);            
        }
        return res;
    }
}

/* Recursive Solution using memory of order
class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        return levelOrder(root, 0, new ArrayList<>());
    }
    
    private List<List<Integer>> levelOrder(Node node, int level, List<List<Integer>> order){
        if (node == null){
            return order;
        }
        List<Integer> list = order.size() > level ?  order.get(level) : new ArrayList<>();
        list.add(node.val);
        if (order.size() <= level){
            order.add(list);
        }
        for (Node n : node.children){
            levelOrder(n, level + 1, order);
        }
        return order;
    }
}
*/