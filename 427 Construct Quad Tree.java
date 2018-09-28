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
    public Node construct(int[][] g) {
        return build(0, 0, g.length - 1, g.length -1, g);
    }
    public Node build(int r1, int c1, int r2, int c2, int[][] g) {
        if (r1 > r2 || c1 > c2) return null;
        boolean isLeaf = true;
        int val = g[r1][c1];
        for (int i = r1; i <= r2; i++)
            for (int j = c1; j <= c2; j++)
                if (g[i][j] != val) {
                    isLeaf = false;
                    break;
                }
        if (isLeaf) // All in this block is 1 or All in this block is 0
            return new Node(val == 1, true, null, null, null, null);
        int rMid = (r1 + r2) / 2, cMid = (c1 + c2) / 2;
        return new Node(false, false,
            build(r1      , c1      , rMid, cMid, g),  // top left
            build(r1      , cMid + 1, rMid, c2  , g),  // top right
            build(rMid + 1, c1      , r2  , cMid, g),  // bottom left 
            build(rMid + 1, cMid + 1, r2  , c2  , g)); // bottom right
    }
}