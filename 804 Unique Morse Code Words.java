class Solution {
    public int uniqueMorseRepresentations(String[] words) {
        String[] mcode = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        Set<String> set = new HashSet<>();
        for (String word : words) {
            StringBuilder sb = new StringBuilder();
            for (char ch : word.toCharArray()) {
                sb.append(mcode[ch - 'a']);
            }
            set.add(sb.toString());
        }
        return set.size();
    }
}