class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        if (words.length <= 1) return true;
        int[] pos = new int[26];
        char[] chs = order.toCharArray();
        for (int i = 0; i < chs.length; ++i) {
            pos[chs[i] - 'a'] = i;
        }
        String prev = words[0];
        for (int i = 1; i < words.length; ++i) {
            if (!check(prev, words[i], pos)) return false;
            prev = words[i];
        }
        return true;
    }
    public boolean check(String prev, String now, int[] pos) {
        int slen = Math.min(prev.length(), now.length());
        char[] chp = prev.toCharArray();
        char[] chn = now.toCharArray();
        for (int i = 0; i < slen; ++i) {
            if (pos[chp[i] - 'a'] > pos[chn[i] - 'a']) return false;
            else if (pos[chp[i] - 'a'] < pos[chn[i] - 'a']) return true;
        }
        if (prev.length() <= now.length()) return true;
        else return false;
    }
}