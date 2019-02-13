/* Solution from lee215, use int[26] as Union Map since there are only 26 characters.*/
class Solution {
    int[] uf = new int[26];
    public boolean equationsPossible(String[] equations) {
        for (int i = 0; i < 26; ++i) uf[i] = i;
        for (String e : equations)
            if (e.charAt(1) == '=')
                uf[find(e.charAt(0) - 'a')] = find(e.charAt(3) - 'a');
        for (String e : equations)
            if (e.charAt(1) == '!' && find(e.charAt(0) - 'a') == find(e.charAt(3) - 'a'))
                return false;
        return true;
    }

    public int find(int x) {
        if (x != uf[x]) uf[x] = find(uf[x]);
        return uf[x];
    }
}
/* Solution from zhuojiansen (Union Find)*/
class Solution {
    public boolean equationsPossible(String[] equations) {
        Map<Character, Character> union = new HashMap<>();
        for (char c = 'a'; c <= 'z'; c++) {
            union.put(c, c);
        }
        Set<String> difSet = new HashSet<>();
        for (String equation : equations) {
            if (equation.charAt(1) == '!') {
                difSet.add(equation);
            } else {
                char c1 = equation.charAt(0);
                char c2 = equation.charAt(3);
                char p1 = findAncient(union, c1);
                char p2 = findAncient(union, c2);
                union.put(p1, p2);
            }
        }
        for (String equation : difSet) {
            char c1 = equation.charAt(0);
            char c2 = equation.charAt(3);
            char p1 = findAncient(union, c1);
            char p2 = findAncient(union, c2);
            if (p1 == p2) 
                return false;
        }
        return true;
    }
    private Character findAncient(Map<Character, Character> union, Character c) {
        while (union.get(c) != c)
            c = union.get(c);
        return c;
    }
}