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
    public List<Integer> postorder(Node root) {
        List<Integer> res = new ArrayList<Integer>();
        if (root == null) return res;
        for (Node node : root.children) {
            postorder(node, res);
        }
        res.add(root.val);
        return res;
    }
    public void postorder(Node n, List<Integer> res) {
        if (n == null) return;
        for (Node i: n.children) {
            postorder(i, res);
        }
        res.add(n.val);
    }
}
/* Iterative solution
class Solution {
    public List<Integer> postorder(Node root) {
        List<Integer> res = new ArrayList<Integer>();
        if (root == null) return res;
        Stack<Node> s = new Stack<Node>();
        s.add(root);
        while (!s.isEmpty()) {
            root = s.pop();
            res.add(root.val);
            for (Node n: root.children)
                s.add(n);
        }
        Collections.reverse(res);
        return res;
    }
}
*/