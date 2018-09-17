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
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;
        Stack<TreeNode> st = new Stack<TreeNode>();
        st.push(root);
        while(!st.empty()) {
            TreeNode ite = st.pop();
            TreeNode tmp;
            if (ite.left == null && ite.right == null) {
                continue;
            } else if (ite.left == null) {
                ite.left = ite.right;
                ite.right = null;
                st.push(ite.left);
            } else if (ite.right == null) {
                ite.right = ite.left;
                ite.left = null;
                st.push(ite.right);
            } else {
                tmp = ite.left;
                ite.left = ite.right;
                ite.right = tmp;
                st.push(ite.left);
                st.push(ite.right);
            }            
        }
        return root;
    }
}
/* Recursion Solution: 

class Solution {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }
}
*/


/* Trivia:
This problem was inspired by this original tweet by Max Howell:
Google: 90% of our engineers use the software you wrote (Homebrew), 
but you can’t invert a binary tree on a whiteboard so f*** off.

逸事(From Wikipedia)
Homebrew的作者Max Howell曾應聘過Google的職位，在技術沒有成功之後，
在Twitter上發帖 Google: 90% of our engineers use the software you wrote (Homebrew), 
but you can't invert a binary tree on a whiteboard so f*** off.
Google：我們90%的工程師都在用你的軟體（Homebrew），但是你不會在白板上翻轉二元樹所以滾出去） 
，在網上引發了關於招聘程式設計師面試時白板編程意義的討論。

所以說，到底白板上會解題和實際會不會產出有沒有正相關呢XD
但不考這些要從面試者經歷就看出來一個人的程度應該有點難。
但話又說回來，一個這麼威的人去參加這個，
說寫不出這個問題，這肯定哪裡有問題(題目沒敘述清楚?還是問題被描述成更複雜?)

參考閱讀:
https://www.techbang.com/posts/24183
https://www.zhihu.com/question/31202353

*/