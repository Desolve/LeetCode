/*
// Definition for a QuadTree node.
class Node {
    public boolean val;
    public boolean isLeaf;
    public Node topLeft;
    public Node topRight;
    public Node bottomLeft;
    public Node bottomRight;

    public Node() {}

    public Node(boolean _val,boolean _isLeaf,Node _topLeft,Node _topRight,Node _bottomLeft,Node _bottomRight) {
        val = _val;
        isLeaf = _isLeaf;
        topLeft = _topLeft;
        topRight = _topRight;
        bottomLeft = _bottomLeft;
        bottomRight = _bottomRight;
    }
};
*/

class Solution {
    public Node intersect(Node q1, Node q2) {
        if (q1.isLeaf)
            return q1.val ? q1 : q2;
        if (q2.isLeaf)
            return q2.val ? q2 : q1;
        Node root = new Node();
        Node topLeft = intersect(q1.topLeft, q2.topLeft);
        Node topRight = intersect(q1.topRight, q2.topRight);
        Node bottomLeft = intersect(q1.bottomLeft, q2.bottomLeft);
        Node bottomRight = intersect(q1.bottomRight, q2.bottomRight);
        
        if (topLeft.isLeaf && topRight.isLeaf && bottomLeft.isLeaf && bottomRight.isLeaf) {
            if (topLeft.val && topRight.val && bottomLeft.val && bottomRight.val) {
                root.isLeaf = true;
                root.val = true;
                return root;
            }else if (!topLeft.val && !topRight.val && !bottomLeft.val && !bottomRight.val) {
                root.isLeaf = true;
                root.val = false;
                return root;
            }
        }
        root.topLeft = topLeft;
        root.topRight = topRight;
        root.bottomLeft = bottomLeft;
        root.bottomRight = bottomRight;
        return root;
    }
}