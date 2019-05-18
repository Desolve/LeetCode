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
    public List<Integer> preorder(Node root) {
        if (root == null) return new ArrayList<Integer>();
        List<Integer> res = new ArrayList<Integer>();
        res.add(root.val);
        for (Node node : root.children) {
            preorder(root, res);
        }
        return res;
    }
    public void preorder(Node n, List<Integer> res){
        if (n == null) return;
        res.add(n.val);
        for (Node node : n.children) {
            preorder(node, res);
        }
    }
}

/* Iterative solution
class Solution {
    public List<Integer> preorder(Node root) {
        List<Integer> res = new ArrayList<Integer>();
        if (root == null) return res;
        Stack<Node> s = new Stack<Node>();
        s.add(root);
        while (!s.isEmpty()) {
            Node n = s.pop();
            res.add(n.val);
            for (int i = n.children.size() - 1; i >= 0; --i)
                s.add(n.children.get(i));
        }
        return res;
    }
}
*/