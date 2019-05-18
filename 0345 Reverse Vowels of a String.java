class Solution {
    public String reverseVowels(String s) {
        int i = 0, j = s.length() - 1;
        char[] ch = s.toCharArray();
        Set<Character> set = new HashSet<Character>();
        set.add('a'); set.add('e'); set.add('i'); set.add('o'); set.add('u');
        set.add('A'); set.add('E'); set.add('I'); set.add('O'); set.add('U');
        while(i < j) {
            if (set.contains(ch[i]) && set.contains(ch[j])) {
                char tmp = ch[i];
                ch[i] = ch[j];
                ch[j] = tmp;                
                i++; j--;
            } else if (set.contains(ch[i])) {
                j--;
            } else if (set.contains(ch[j])){
                i++;
            } else {
                i++; j--;
            }
        }
        return new String(ch);
    }
}