/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/
/* Adapted from talent58*/
class Solution {
    public Node connect(Node root) {
        Node level_first = root;
        while (level_first != null) {
            Node curr = level_first;
            while (curr != null) {
                if (curr.left != null) curr.left.next = curr.right;
                if (curr.right != null && curr.next != null) curr.right.next = curr.next.left;
                curr = curr.next;
            }
            level_first = level_first.left;
        }
        return root;
    }
}
/* dfs solutions
class Solution {
    public Node connect(Node root) {
        if(root == null)
            return null;
        
        //root.next = null;
            
        if(root.left != null)
            root.left.next = root.right;
        
        if(root.right != null && root.next != null)
            root.right.next = root.next.left;
        
        connect(root.left);
        connect(root.right);
        
        return root;
    }
}
class Solution {
    public Node connect(Node root) {
        if (root != null)
            dfs(root.left, root.right);
        return root;
    }
    private void dfs(Node n1, Node n2) {
        if (n1 == null) return;
        n1.next = n2;
        dfs(n1.left, n1.right);
        dfs(n1.right, n2.left);
        dfs(n2.left, n2.right);
    }
}*/