class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<String>();
        combine("", 0, 0, res, n);
        return res;
    }
    public void combine(String s, int l, int r, List<String> res, int n) {
        if (l == n && r == n) res.add(s);
        if (l >= r && l < n) combine(s + "(", l + 1, r, res, n);
        if (l > r) combine(s + ")", l, r + 1, res, n);
    }
}

/* faster solution by macdan36(allocate full char array first)
class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        helper( 0, 0, 0, new char[n*2], result);
        return result;
    }
    
    private void helper(int idx, int leftCount, int unpairedLeft, char[] parens, List<String> result) {
        if (idx == parens.length) {
            result.add(new String(parens));
            return;
        }
        
        if (leftCount < parens.length/2 ) {
            parens[idx] = '(';
            helper( idx+1, leftCount+1, unpairedLeft+1, parens, result);
        } 
        if (unpairedLeft > 0) {
            parens[idx] = ')';
            helper( idx+1, leftCount, unpairedLeft-1, parens, result);
        }
        
        
    }
}
*/